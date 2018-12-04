import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class BuildHeap {
    private int[] data;
    private List<Swap> swaps;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new BuildHeap().solve();
    }

    private void readData() throws IOException {
        int n = in.nextInt();
        data = new int[n];
        for (int i = 0; i < n; ++i) {
          data[i] = in.nextInt();
        }
    }

    private void writeResponse() {
        out.println(swaps.size());
        for (Swap swap : swaps) {
          out.println(swap.index1 + " " + swap.index2);
        }
    }

    private int LeftChild(int i) {
    	return 2*i;
    }
    
    private int RightChild(int i) {
    	return (2*i) + 1;
    }
    
    private void shiftDown(int i) {
    	int minIndex = i;
    	int l = LeftChild(i);
    	int r = RightChild(i);
    	
    	if( l <= data.length && data[l-1] < data[minIndex-1]) {
    		minIndex = l;
    	}
    	if( r <= data.length && data[r-1] < data[minIndex-1]) {
    		minIndex = r;
    	}
    	if( i != minIndex) {
    		swaps.add(new Swap(i-1, minIndex-1));
            int tmp = data[i-1];
            data[i-1] = data[minIndex-1];
            data[minIndex-1] = tmp;
            shiftDown(minIndex);
    	}
    	
    }
    private void generateSwaps() {
      swaps = new ArrayList<Swap>();
      
      for( int i=Math.floorDiv(data.length, 2); i>0; i--) {
    	  shiftDown(i);
      }
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        generateSwaps();
        writeResponse();
        out.close();
    }

    static class Swap {
        int index1;
        int index2;

        public Swap(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
