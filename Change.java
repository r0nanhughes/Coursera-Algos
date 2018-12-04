import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        
    	int _10, _5;
    	int mod;
    	
    	_10 = m / 10;
    	mod = m % 10;
    	
    	if( mod == 0)
    		return _10;
    	
    	_5 = mod / 5;
    	mod = mod % 5;
    	
    	if( mod == 0)
    		return _10 + _5;
    	
    	return _10 + _5 + mod;
    	
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

