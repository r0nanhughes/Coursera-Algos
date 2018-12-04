import java.util.*;

public class Dijkstra {
    private static long distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
        
    	long[] dist = new long[adj.length];
    	int[] prev = new int[adj.length];
    	boolean[] processed = new boolean[adj.length];
    	for( int i=0; i<adj.length; i++) {
    		dist[i] = Integer.MAX_VALUE;
    		prev[i] = -1;
    	}
    	
    	dist[s] = 0;
    	
    	PriorityQueue<Node> q = new PriorityQueue<>();
    	MakeQueue(dist, q);
    	
    	while( !q.isEmpty()) {
    		Node u = q.remove();
    		
    		if(u.v == t) {
    			break;
    		}
    		if(!processed[u.v]) {
    			processed[u.v] = true;
    			int count = 0;
    			for(Integer v : adj[u.v]) {
    				if( dist[v] > u.d + cost[u.v].get(count)) {
    					dist[v] = u.d + cost[u.v].get(count);
    					prev[v] = u.v;
    					q.add(new Node(v, dist[v]));
    				}
    				count++;
    			}
    		}
    		
    	}
    	return dist[t] == Integer.MAX_VALUE ? -1 : dist[t];
    }

    private static void MakeQueue(long[] dist, PriorityQueue<Node> q) {
    	for( int i=0; i<dist.length; i++) {
    		q.add(new Node(i, dist[i]));
    	}
    }
    static class Node implements Comparable<Node> {
    	int v;
    	long d;
    	
    	public Node(int v, long d) {
    		this.v = v;
    		this.d = d;
    	}

    	@Override
		public String toString() {
			return "Node [v=" + v + ", d=" + d + "]";
		}

		@Override
		public int compareTo(Node o) {
			if( this.d > o.d)
				return 1;
			else if( this.d < o.d)
				return -1;
			
			return 0;
		}
		
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
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, cost, x, y));
    }
}

