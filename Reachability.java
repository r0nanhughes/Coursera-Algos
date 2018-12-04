import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Reachability {
    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
    	
    	Stack<Integer> stack = new Stack<Integer>();
    	boolean[] visited = new boolean[adj.length];
    	
    	stack.push(x);
    	
    	while(!stack.isEmpty()) {
    		Integer beingVisited = stack.lastElement();
    		
    		if( beingVisited == y) {
    			return 1;
    		}
    		
    		visited[beingVisited] = true;
    		ArrayList<Integer> paths = adj[beingVisited];
    		
    		int i=0;
    		for( i=0; i<paths.size(); i++) {
    			if( !visited[paths.get(i)]) {
    				stack.push(paths.get(i));
    				break;
    			}
    		}
    		
    		if( i == paths.size()) {
    			stack.pop();
    		}
    		
    	}
        
        return 0;
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
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y));
    }
}

