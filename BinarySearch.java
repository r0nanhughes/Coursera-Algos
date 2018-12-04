import java.io.*;
import java.util.*;

public class BinarySearch {

    static int binarySearchRec(int[] a, int low, int high, int x) {
    	
        if( low > high )
        	return -1;

        int mid = (int)(high - low) / 2 + low;

    	if( a[mid] == x )
    		return mid;
    	else if( x > a[mid] )
    		return binarySearchRec(a, mid+1, high, x);
    	else    		
    		return binarySearchRec(a, low, mid-1, x);
    	
    }

    static int binarySearch(int[] a, int low, int high, int x) {

    int index = -1;
    
    while (low <= high) {
        int mid = (low + high) / 2;
        if (a[mid] < x) {
            low = mid + 1;
        } else if (a[mid] > x) {
            high = mid - 1;
        } else if (a[mid] == x) {
            index = mid;
            break;
        }
    }
    return index;
    }
    
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
          b[i] = scanner.nextInt();
        }
        
        //Arrays.sort(a);
        
        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            System.out.print(binarySearch(a, 0, a.length-1, b[i]) + " ");
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
