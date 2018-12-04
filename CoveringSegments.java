import java.util.*;

public class CoveringSegments {

	private static List<Integer> optimalPoints(Integer[][] segments) {

		Arrays.sort(segments, new Comparator<Integer[]>()
		{
			@Override
			public int compare(Integer[] int1, Integer[] int2)
			{

				if(int1[0] == int2[0]){
					return int1[1].compareTo(int2[1]);
				}

				return int1[0].compareTo(int2[0]);

			}
		});

		List<Integer> points = new ArrayList<>();

		if( segments.length == 1 ) {
			points.add(segments[0][0]);
			return points;
		}

		int _break = segments[0][1];
		int count = 1;
		
		for( Integer[] segment : segments) {
			int a = segment[0];
			int b = segment[1];

			if( b <= _break) {
				_break = b;
				count++;
				continue;
			}
			
			if( a <= _break) {
				count++;
				continue;
			}
			
			points.add(_break);
			_break = b;
		
			count++;

		}
		points.add(_break);
		return points;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Integer[][] segments = new Integer[n][2];

		for (int i = 0; i < n; i++) {
			segments[i][0] = scanner.nextInt(); // from
			segments[i][1] = scanner.nextInt(); // to
		}

		List<Integer> points = optimalPoints(segments);
		System.out.println(points.size());
		for (int point : points) {
			System.out.print(point + " ");
		}
	}
}

