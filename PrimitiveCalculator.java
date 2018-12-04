import java.util.*;

public class PrimitiveCalculator {
	private static int[][] optimal_sequence(int n) {

		int[][] out = new int[n+1][2];

		if( n == 1) {
			out[1][0] = 0;
			out[1][1] = 1;
			return out;
		}
		out[0][0] = 0;

		for( int i=1; i<out.length; i++) {
			out[i][0] = out[i-1][0] + 1;
			out[i][1] = 1;

			if( i%2 == 0) {
				if( i/2 == 1) {
					out[i][0] = 1;
				} else {
					out[i][0] = Math.min(out[i][0], out[i/2][0] + 1);
				}
				out[i][1] = 2;
			}

			if( i%3 == 0) {
				if( i/3 == 1) {
					out[i][0] = 1;
				} else {
					out[i][0] = Math.min(out[i][0], out[i/3][0] + 1);
				}
				out[i][1] = 3;
			}
		}
		return out;

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] sequence = optimal_sequence(n);
		System.out.println(sequence[n][0]);
		
		Stack<Integer> stack = new Stack<>();
		stack.push(n);

		while(n > 1) {
			if( sequence[n][1] == 1) {
				n-=1;
			} else if( sequence[n][1] == 2) {
				n/=2;
			} else if( sequence[n][1] == 3) {
				n/=3;
			}
			stack.push(n);
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		

	}
}

