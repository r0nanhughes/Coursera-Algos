import java.math.BigInteger;
import java.util.*;

public class FibonacciHuge {
	
	  private static BigInteger calc_fib(long n) {
		    if (n <= 1)
		      return BigInteger.valueOf(n);

		    BigInteger last = BigInteger.valueOf(1);
		    BigInteger prev = BigInteger.valueOf(0);
		    BigInteger fib = BigInteger.valueOf(0);
		    
		    for( int i = 2; i<=n; ++i) {
		    	fib = last.add(prev);
		    	prev = last;
		    	last = fib;
		    }
		    return fib;
		    
		  }
	  
    private static long getPisanoPeriodCount(long n, long m) {
        
    	long base = 0;
    	long next = 1;
    	
    	long count = 2;
    	
    	while(true) {
    		
    		long check = base + next;
    		    		
    		if( check == m) {
    			check = 0;
    		}
    		if( check > m) {
    			check = check - m;
    		}
    		
    		count++;
    		base = next;
    		next = check;
    		
    		if( base == 0 && next == 1)
    			break;
    	}
    	
    	return count - 2;

    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        scanner.close();
        
        BigInteger fibModulo = calc_fib(n % getPisanoPeriodCount(n, m)).mod(BigInteger.valueOf(m));
        System.out.println(fibModulo);
    }
}

