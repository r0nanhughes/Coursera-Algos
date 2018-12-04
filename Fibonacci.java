import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;

    long last = 1;
    long prev = 0;
    long fib = 0;
    
    for( int i = 2; i<=n; ++i) {
    	fib = last + prev;
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
