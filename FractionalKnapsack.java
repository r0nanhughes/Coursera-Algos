import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FractionalKnapsack {
	
	private static double getOptimalValue(int capacity, Integer[][] values) {
		double ret = 0.;
		
		Arrays.sort(values, new Comparator<Integer[]>()
	    {
	        @Override
	        public int compare(Integer[] int1, Integer[] int2)
	        {
	            Double val1 = Double.valueOf((double)int1[0] / int1[1]);
	            Double val2 = Double.valueOf((double)int2[0] / int2[1]);
	        	
	            return val2.compareTo(val1);
	        }
	    });
		
		for( int i=0; i<values.length; i++) {
			
			int value = values[i][0];
			int weight = values[i][1];
			
			if( weight < capacity) {
				ret += value;
				capacity -= weight;
				continue;
			}
			if( weight == capacity) {
				ret += value;
				break;
			}
			if( weight > capacity) {
				ret += (double)value / (weight/capacity);
				break;
			}
			
		}

		return ret;
	}

	public static void main(String args[]) {
		int n, capacity;
		Integer[][] values;
		
		try (Scanner scanner = new Scanner(System.in)) {
			n = scanner.nextInt();
			capacity = scanner.nextInt();
			values = new Integer[n][2];
			
			for (int i = 0; i < n; i++) {
				
				Integer[] parts = new Integer[2];
				parts[0] = scanner.nextInt(); // value
				parts[1] = scanner.nextInt(); // weight
				
				values[i] = parts;
				
			}
			DecimalFormat df = new DecimalFormat("###.0000");
			System.out.println(df.format(getOptimalValue(capacity, values)));

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
} 
