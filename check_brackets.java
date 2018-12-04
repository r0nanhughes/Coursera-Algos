import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

    char type;
    int position;
	@Override
	public String toString() {
		return "Bracket [type=" + type + ", position=" + position + "]";
	}
    
    
}

class check_brackets {
	
    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        Stack<Bracket> brackets = new Stack<Bracket>();
        Stack<Bracket> all = new Stack<Bracket>();

        boolean check = true;
        for (int position = 0; position < text.length(); position++) {
            char next = text.charAt(position);
            Bracket bracket = new Bracket(next, position+1);
            all.push(bracket);
            
            if (next == '(' || next == '[' || next == '{') {
            	brackets.push(bracket);
            }

            if (next == ')' || next == ']' || next == '}') {
            	if( brackets.isEmpty() ) {
            		check = false;
            		break;
            	}
            	Bracket _top = brackets.pop();
            	if( !_top.Match(next)) {
            		check = false;
            		break;
            	}
            	all.pop();all.pop();
            }
        }
        
        if( check && brackets.isEmpty()) {
        	System.out.println("Success");
        } else {
        	System.out.println(all.pop().position);
        }
    }
}
