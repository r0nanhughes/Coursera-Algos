import java.util.*;

public class Partition3 {

    static int partition3(int[] weights) {

        int sum = Arrays.stream(weights).sum();
        
        if( sum%3 != 0)
        	return 0;
    	
        int totalWeight = sum / 3;
        
    	int numWeights = weights.length;
    	
    	int res[][] = new int[numWeights+1][totalWeight+1];

    	for( int i=1; i<=numWeights; i++) {
    		for( int j=1; j<=totalWeight; j++) {
    			if( j < weights[i-1]) {
    				res[i][j] = res[i-1][j];
    			} else {
    				res[i][j] = Math.max(weights[i-1] + res[i-1][j - weights[i-1]], res[i-1][j]);
    			}
    		}
    	}
    	return res[numWeights][totalWeight] == totalWeight ? 1 : 0;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}

