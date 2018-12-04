import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Toposort {
	private static Stack<Integer> toposort(ArrayList<Integer>[] adj) {
		Stack<Integer> order = new Stack<Integer>();

		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[adj.length]; 
		
		for( int i = 0; i < adj.length; i++) {

			if( !visited[i]) {
				stack.push(i);
			}

			while(!stack.isEmpty()) {
				Integer beingVisited = stack.lastElement();

				visited[beingVisited] = true;

				ArrayList<Integer> paths = adj[beingVisited];

				int j=0;

	    		for( j=0; j<paths.size(); j++) {
	    			if( !visited[paths.get(j)]) {
	    				stack.push(paths.get(j));
	    				break;
	    			}
	    		}
	    		
	    		if( j == paths.size()) {
	    			order.add(stack.pop());
	    		}
			}
		}

		return order;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			int x, y;
			x = scanner.nextInt();
			y = scanner.nextInt();
			adj[x - 1].add(y - 1);
		}
		Stack<Integer> order = toposort(adj);
		int size = order.size();
		for (int x=0; x<size;x++) {
			System.out.print((order.pop() + 1) + " ");
		}
	}
}

