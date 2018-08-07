import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

public class PostfixEvaluation {

	PostfixEvaluation(){}
	
	/**
	 * 
	 * @param operand1 - first operand
	 * @param operand2 - second operand
	 * @param operatorAscii - Operator ascii value
	 * @return - Operation computed value
	 * @throws InvalidExpressionException
	 */
	private double operation(double operand1, double operand2, String operator) throws ArithmeticException{
		if(operator.equals("+")) {
			return (operand1 + operand2);
		}
		if(operator.equals("-") ) {
			return (operand1 - operand2);
		}
		if(operator.equals("*")) {
			return (operand1 * operand2);
		}
		if(operator.equals("/")) {
			if(operand2 == 0) {
				throw new ArithmeticException();
			}
			return (operand1 / operand2);
		}
		return 0.0;
	}
	
	/**
	 * 
	 * @param expression - String postfix expression
	 * @return - Evaluation of postfix expression
	 * @throws InvalidExpressionException
	 */
	public double getExpressionValue(String expression) throws EmptyStackException, NumberFormatException, ArithmeticException{
		StringTokenizer st = new StringTokenizer(expression);
		Stack<Double> stack = new Stack<Double>();
		for(int i=0; st.hasMoreTokens(); i++) {
			String token = st.nextToken();
			if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
				double op2 = stack.pop();
				double op1 = stack.pop();
				stack.push(this.operation(op1, op2, token));
			}
			else {
				stack.push(Double.parseDouble(token));
			}
		}
		return stack.pop();
	}
}





