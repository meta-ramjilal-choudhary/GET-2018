import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

public class InfixToPostfix {

	InfixToPostfix(){}
	
	/**
	 * Define Operators precedence from heighest to lowest 
	 * @param operator - operator of expression
	 * @return - precedence of operator
	 */
	private int precedence(String operator) {
		if(operator.equals("(") || operator.equals(")")) {
			return 8;
		}
		if(operator.equals("!")) {
			return 7;
		}
		if(operator.equals("*") || operator.equals("/")) {
			return 6;
		}
		if(operator.equals("+") || operator.equals("-")) {
			return 5;
		}
		if(operator.equals("<") || operator.equals(">") || operator.equals("<=") || operator.equals(">=")) {
			return 4;
		}
		if(operator.equals("==") || operator.equals("!=")) {
			return 3;
		}
		if(operator.equals("&&")) {
			return 2;
		}
		if(operator.equals("||")) {
			return 1;
		}
		return -1;
	}
	
	/**
	 * 
	 * @param expression - infix expression 
	 * @return - Postfix expression
	 * @throws EmptyStackException
	 * @throws NumberFormatException
	 */
	public String convertInfixToPostfix(String expression) throws EmptyStackException, NumberFormatException{
		
		StringTokenizer st = new StringTokenizer(expression);
		Stack<String> stack = new Stack<String>();
		StringBuilder sb = new StringBuilder("");
		
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			if(this.precedence(token) > 0) {
				if(stack.isEmpty()) {
					stack.push(token);
				}
				else if(token.equals(")")) {
					String op = stack.pop();
					while(!op.equals("(")) {
						sb.append(op+" ");
						op = stack.pop();
					}
				}
				else {
					while(!stack.peek().equals("(") && (this.precedence(stack.peek()) > this.precedence(token))) {
						sb.append(stack.pop() + " ");
					}
					stack.push(token);
				}
			}
			else {
				Integer.parseInt(token);
				sb.append(token+" ");
			}
		}
		if(!stack.empty()) {
			while(!stack.empty()) {
				sb.append(stack.pop()+" ");
			}
		}
		return sb.toString();
	}
}
