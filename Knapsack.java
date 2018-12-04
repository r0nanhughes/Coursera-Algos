import java.util.*;

public class Knapsack {
    static int optimalWeight(int totalWeight, int[] weights) {

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
    	return res[numWeights][totalWeight];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

