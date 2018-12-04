import java.util.Scanner;

public class Fibonacci_LastDigit {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

    int last = 1;
    int prev = 0;
    int fib = 0;
    
    for( int i = 2; i<=n; ++i) {
    	fib = (last + prev)%10;
    	prev = last;
    	last = fib;
    }
    return fib;
    
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.close();
    System.out.println(calc_fib(n));
  }
}
