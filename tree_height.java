import java.util.*;
import java.io.*;

public class tree_height {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

    class Node {
    	private int key;
    	private Node parent = null;
    	private List<Node> children;
    	private int level = 0;
    	
    	public Node() {
    		this.children = new ArrayList<>();
    	}
    	public Node(int key) {
    		this.children = new ArrayList<>();
    		this.key = key;
    	}
    	
		public void addChild(Node child) {
			child.parent = this;
			this.children.add(child);
		}
		@Override
		public String toString() {
			return "Node [key=" + key + ", parent=" + parent + ", children=" + children + "]";
		}

		
    }
    
	public class TreeHeight {
		int n;
		int root;
		List<Node> nodes = new ArrayList<Node>();
		Node rootNode;
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
		for( int i = 0; i < n; i++) {
			nodes.add(new Node(i));
		}
			
			for (int child_index = 0; child_index < n; child_index++) {
				int parent_index = in.nextInt();
				
				if( parent_index == -1) {
					root = child_index;
				} else {
					nodes.get(parent_index).addChild(nodes.get(child_index));
				}
			}
			
			rootNode = nodes.get(root);
		}

		int computeHeight() {
			int height = 0;
			
			if( rootNode == null) 
				return 0;
			
			Queue<Node> q = new LinkedList<>();
			
			q.add(rootNode);
			
			while( !q.isEmpty() ) {
				Node _node = q.remove();
				if( _node.parent == null) {
					height = 1;
					_node.level = 1;
				} else {
					_node.level = _node.parent.level + 1;
					height = _node.level;
				}
				for ( Node node : _node.children ) {
					q.add(node);
				}
			}
			return height;
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
