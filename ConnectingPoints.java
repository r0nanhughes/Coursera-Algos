import java.awt.geom.Point2D;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ConnectingPoints {
	
	private int[] parent;
	private int[] rank;
	
	private double minimumDistance(int[] x, int[] y) {
		
		List<Edge> edges = new ArrayList<>();
		
		double result = 0.;
		
		for( int i=0; i< x.length; i++) {
			for( int j=0; j<x.length; j++) {
				if( i != j) {
					edges.add(new Edge(i, j, Point2D.distance(x[i], y[i], x[j], y[j])));
				}
			}
		}
		
		this.parent = new int[edges.size()];
		this.rank = new int[edges.size()];
		
		for( int i=0; i<parent.length; i++) {
			MakeSet(i);
		}
		
		Collections.sort(edges);
		
		for( Edge edge : edges) {
			if( Find(edge.from) != Find(edge.to)) {
				result+=edge.cost;
				Union(edge.from, edge.to);
			}
		}

		BigDecimal bd = new BigDecimal(Double.toString(result));
	    bd = bd.setScale(9, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	    
    }

    private void MakeSet(int i) {
    	parent[i] = i;
    	rank[i] = 0;
    }
    
    private int Find(int i) {
    	while( i != parent[i]) {
    		i = parent[i];
    	}
    	return i;
    }
    
    private void Union(int i, int j) {
    	int i_id = Find(i);
    	int j_id = Find(j);
    	
    	if( i_id == j_id)
    		return;
    	
    	if( rank[i_id] > rank[j_id]) {
    		parent[j_id] = i_id;
    	} else {
    		parent[i_id] = j_id;
    		if( rank[i_id] == rank[j_id]) {
    			rank[j_id] = rank[j_id] + 1;
    		}
    	}
    }
    
    static class Edge implements Comparable<Edge>{
        int from;
        int to;
        double cost;

        public Edge(int from, int to, double cost) {
        	this.from = from;
        	this.to = to;
        	this.cost = cost;
        }

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.cost, o.cost);
		}
        
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
        }
        ConnectingPoints p = new ConnectingPoints();
        System.out.println(p.minimumDistance(x, y));
    }
}

