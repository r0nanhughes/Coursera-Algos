import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class ConnectedComponents {
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        int result = 0;
    	Stack<Integer> stack = new Stack<Integer>();
    	boolean[] visited = new boolean[adj.length];
    	for( int i = 0; i < visited.length; i++) {
    		
    		if(!visited[i]) {
    			result++;
    			
    			stack.push(i);
    	    	
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
    	    			stack.pop();
    	    		}
    	    		
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
            adj[y - 1].add(x - 1);
        }
        System.out.println(numberOfComponents(adj));
    }
}

