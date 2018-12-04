import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class JobQueue {
    private int numThreads;
    private JobThread[] threads;
    private int[] jobs;

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new JobQueue().solve();
    }

    private void readData() throws IOException {
        numThreads = in.nextInt();
        int m = in.nextInt();
        jobs = new int[m];
        threads = new JobThread[numThreads];
        
        for( int i = 0; i < numThreads; i++) {
        	threads[i] = new JobThread(i, BigInteger.ZERO);
        }
        for (int i = 0; i < m; ++i) {
            jobs[i] = in.nextInt();
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
    	
    	if( l < threads.length) {
    		if (threads[l].nextFinishTime.compareTo(threads[minIndex].nextFinishTime) == -1) {
    			minIndex = l;
    		} else if(threads[l].nextFinishTime.compareTo(threads[minIndex].nextFinishTime) == 0) {
    			if(threads[l].id < threads[minIndex].id ) {
    				minIndex = l;
    			}
    		}
    	}
    	if( r < threads.length) {
    		if (threads[r].nextFinishTime.compareTo(threads[minIndex].nextFinishTime) == -1) {
    			minIndex = r;
    		} else if(threads[r].nextFinishTime.compareTo(threads[minIndex].nextFinishTime) == 0) {
    			if(threads[r].id < threads[minIndex].id ) {
    				minIndex = r;
    			}
    		}
    	}
    	if( i != minIndex) {
    	    JobThread tmp = threads[i];
    	    threads[i] = threads[minIndex];
    	    threads[minIndex] = tmp;
            shiftDown(minIndex);
    	}
    	
    }
    private void assignJobs() {

    	for( int i=0; i<jobs.length; i++) {
    		System.out.println(threads[0].id + " " + threads[0].nextFinishTime);
    		threads[0].nextFinishTime = threads[0].nextFinishTime.add(BigInteger.valueOf(jobs[i]));
    		shiftDown(0);
    	}
    }

    public void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        assignJobs();
        out.close();
    }

    static class JobThread implements Comparable<JobThread> {
    	int id;
    	BigInteger nextFinishTime;
    	
    	public JobThread(int id, BigInteger nextFinishTime) {
    		this.id = id;
    		this.nextFinishTime = nextFinishTime;
    	}

		@Override
		public String toString() {
			return "JobThread [id=" + id + ", nextFinishTime=" + nextFinishTime + "]";
		}

		@Override
		public int compareTo(JobThread o) {
			// TODO Auto-generated method stub
			return 0;
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
