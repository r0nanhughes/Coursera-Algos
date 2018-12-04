import java.util.*;
import java.io.*;

public class tree_orders {
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

	public class TreeOrders {
		class Node {
			int key;
			int left;
			int right;

			Node(int key, int left, int right) {
				this.left = left;
				this.right = right;
				this.key = key;
			}

			@Override
			public String toString() {
				return "Node [key=" + key + ", left=" + left + ", right=" + right + "]";
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


		List<Integer> inOrder() {

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
					result.add(tree[node].key);
					node = tree[node].right;
				}
			}
			return result;
		}

		List<Integer> preOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
			Integer node = 0;

			Stack<Integer> s = new Stack<Integer>();

			s.push(node);

			while (!s.isEmpty()) {
				node = s.pop();
				result.add(tree[node].key);
				//right child is pushed first so that left is processed first
				if (tree[node].right != -1)
					s.push(tree[node].right);
				if (tree[node].left != -1)
					s.push(tree[node].left);
			}
			return result;
		}

		List<Integer> postOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();

			Integer node = 0;
			Integer peekNode = 0;
			Stack<Integer> s = new Stack<Integer>();
			Integer lastNodeVisited = 0;

			while (!s.isEmpty() || node != -1) {
				if (node != -1) {
					s.push(node);
					node = tree[node].left;
				}
				else {
					peekNode  = s.lastElement();

					if (tree[peekNode].right != -1 && lastNodeVisited != tree[peekNode].right) {
						node = tree[peekNode].right;
					}
					else {
						result.add(tree[peekNode].key);
						lastNodeVisited = s.pop();
					}
				}
			}

			return result;
		}
	}

	static public void main(String[] args) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					new tree_orders().run();
				} catch (IOException e) {
				}
			}
		}, "1", 1 << 26).start();
	}

	public void print(List<Integer> x) {
		for (Integer a : x) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public void run() throws IOException {
		TreeOrders tree = new TreeOrders();
		tree.read();
		print(tree.inOrder());
		print(tree.preOrder());
		print(tree.postOrder());
	}
}
