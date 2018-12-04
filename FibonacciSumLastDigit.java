import java.math.BigInteger;
import java.util.*;

public class FibonacciSumLastDigit {
	
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
	  
    private static BigInteger getFibonacciSum(long n) {
        return (calc_fib(n+2).subtract(calc_fib(2)).mod(BigInteger.valueOf(10)));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(getFibonacciSum(n));
    }
}

