import java.util.*;

public class LCM {
  
	  private static long gcd(long a, long b) {
		  
		  if( a == b )
			  return a;
		  
		  if( b > a) {
			  long tmp = a;
			  a = b;
			  b = tmp;
		  }
		  
		  while(true) {
			  
			  long remain = a % b;
			  
			  if( remain == 0) {
				  return b;
			  }
			  
			  a = b;
			  b = remain;
		  }

	  }
	  
	private static long lcm(int a, int b) {
		return (a/gcd(a,b))*b;
    }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    scanner.close();
    System.out.println(lcm(a, b));
  }
}
