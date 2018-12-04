import java.util.*;
import java.io.*;

// Using in-order, if not ordered result then not binary search tree
public class is_bst {
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

    public class IsBST {
        class Node {
            int key;
            int left;
            int right;

            Node(int key, int left, int right) {
                this.left = left;
                this.right = right;
                this.key = key;
            }
        }

        int nodes;
        Node[] tree;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            nodes = in.nextInt();
            tree = new Node[nodes];
            for (int i = 0; i < nodes; i++) {
                tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
            }
        }
		
        boolean isBinarySearchTree() {
        	
        	if( nodes == 0 || nodes == 1) {
        		return true;
        	}
        	
        	ArrayList<Integer> result = new ArrayList<Integer>();
        	
        	Integer node = 0;

			Stack<Integer> s = new Stack<Integer>();

			while (!s.isEmpty() || node != -1) {
				if (node != -1) {
					s.push(node);
					node = tree[node].left;
				}
				else {
					node = s.pop();
					if(!result.isEmpty() && result.get(result.size()-1) > tree[node].key) {
							return false;
					}
					result.add(tree[node].key);
					node = tree[node].right;
				}
			}
          return true;
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new is_bst().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        IsBST tree = new IsBST();
        tree.read();
        if (tree.isBinarySearchTree()) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }
}
