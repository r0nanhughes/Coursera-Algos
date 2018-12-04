import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int money) {
    	int[] coins = new int[3];
    	coins[0] = 1;
    	coins[1] = 3;
    	coins[2] = 4;
    	
    	int[] MinNumCoins = new int[money+1];
    	int numCoins = 0;
    	MinNumCoins[0] = 0;
    	for( int m=1; m<=money; m++) {
    		MinNumCoins[m] = Integer.MAX_VALUE;
    		for( int i=0; i<coins.length; i++) {
    			if( m >= coins[i]) {
    				numCoins = MinNumCoins[m-coins[i]] + 1;
    				if( numCoins < MinNumCoins[m]) {
    					MinNumCoins[m] = numCoins;
    				}
    			}
    		}
    	}
        //write your code here
        return MinNumCoins[money];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

