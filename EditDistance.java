import java.util.*;

class EditDistance {
  public static int EditDistanceFunction(String s, String t) {
	  
	  int n = s.length()+1;
	  int m = t.length()+1;
	  
	  int[][] d = new int[n][m];
	  
	  for( int i = 1; i<n; i++) {
		  d[i][0] = i;
	  }
	  
	  for( int i = 1; i<m; i++) {
		  d[0][i] = i;
	  }
    
	  for( int j=1;j<m; j++) {
		  for( int i=1; i<n; i++) {
			  int insertion = d[i][j-1] +1;
			  int deletion = d[i-1][j] +1;
			  int match = d[i-1][j-1];
			  int mismatch = d[i-1][j-1] +1;
			  
			  if( s.charAt(i-1) == t.charAt(j-1)) {
				 d[i][j] = Math.min(insertion, Math.min(deletion, match)); 
			  } else {
				  d[i][j] = Math.min(insertion, Math.min(deletion, mismatch));
			  }
		  }
	  }
    return d[n-1][m-1];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistanceFunction(s, t));
  }

}
