
import java.util.*;

public class GCD {
  private static int gcd(int a, int b) {
	  
	  if( a == b )
		  return a;
	  
	  while(true) {
		  
		  int remain = a % b;
		  
		  if( remain == 0) {
			  return b;
		  }
		  
		  a = b;
		  b = remain;
	  }

  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    scanner.close();
    System.out.println(gcd(a, b));
  }
}
