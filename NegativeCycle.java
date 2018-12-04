import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NegativeCycle {
	private static int negativeCycle(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost) {
		// write your code here
		Integer[] dist = new Integer[adj.length];
		Arrays.fill(dist, 0); // init distances to zero to solve the separated nodes issue
		dist[0] = 0;

		for( int i=0; i<adj.length-1; i++) {

			for( int j=0; j<adj.length; j++) {
				ArrayList<Integer> edges = adj[j];
				int count = 0;
				for( Integer edge : edges) {
					Integer edge_cost = cost[j].get(count);
					Integer _cost = dist[j] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dist[j] + edge_cost;
					if( _cost < dist[edge]) {
						dist[edge] = _cost;
					}
					count++;
				}
			}
		}
		for( int i=0; i<adj.length-1; i++) {
			for( int j=0; j<adj.length; j++) {
				ArrayList<Integer> edges = adj[j];
				int count = 0;
				for( Integer edge : edges) {
					Integer edge_cost = cost[j].get(count);
					Integer _cost = dist[j] == Integer.MAX_VALUE ? Integer.MAX_VALUE : dist[j] + edge_cost;
					if( _cost < dist[edge]) {
						return 1;
					}
					count++;
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
		ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<Integer>();
			cost[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			int x, y, w;
			x = scanner.nextInt();
			y = scanner.nextInt();
			w = scanner.nextInt();
			adj[x - 1].add(y - 1);
			cost[x - 1].add(w);
		}
		System.out.println(negativeCycle(adj, cost));
	}
}

