import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Acyclicity {
    private static int acyclic(ArrayList<Integer>[] adj) {
    	int result = 0;
    	Stack<Integer> stack = new Stack<Integer>();
    	int[] visited = new int[adj.length]; // not visited = 0, grey = 1, black = 2
    	
    	for( int i = 0; i < adj.length; i++) {
    
    		stack.push(i);
    	    	
    	    while(!stack.isEmpty()) {
    	    		Integer beingVisited = stack.lastElement();
    	    		
    	    		visited[beingVisited] = 1;
    	    		
    	    		ArrayList<Integer> paths = adj[beingVisited];
    	    		
    	    		int j=0;
    	    		
    	    		for( j=0; j<paths.size(); j++) {
    	    			
    	    			if( visited[paths.get(j)] == 2) { // if already visited, move on
    	    				continue;
    	    			}
    	    			if( visited[paths.get(j)] == 1) { // if found a cycle flag it
    	    				return 1;
    	    			}
    	    			visited[paths.get(j)] = 1;
    	    			
    	    			stack.push(paths.get(j));
    	    			
    	    			break;
    	    			
    	    		}
    	    		
    	    		if( j == paths.size()) {
    	    			visited[beingVisited] = 2;
    	    			stack.pop();
    	    		}
    	    		
    	    	}
    	        
    		}
    	

        return result;
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
        System.out.println(acyclic(adj));
    }
}

