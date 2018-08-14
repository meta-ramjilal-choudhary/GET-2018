import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PostfixEvaluationTest {
	
	private PostfixEvaluation postExp;
	
	PostfixEvaluationTest(){
		postExp = new PostfixEvaluation();
	}

	@ParameterizedTest(name = "{index} => expValue={0}, postExp={1}")
	 @MethodSource("ExpressionProvider")
	void test(double expValue, String exp) {
	    try {
	    	assertEquals(expValue, postExp.getExpressionValue(exp));
	    }
	    catch(EmptyStackException e) {
	    	System.out.println("Expression is invalid!");
	    }
	    catch(NumberFormatException e) {
	    	System.out.println("Expression is invalid!");
	    }
	    catch(ArithmeticException e) {
	    	System.out.println("Divide by Zero is Not Possible!");
	    }
	}

	private static Stream<Arguments> ExpressionProvider() {
	    return Stream.of(
	            Arguments.of(48.0, "5 3 + 8 2 - *"),
	            Arguments.of(70.0, "54 6 + 7 4 - * 9 / 35 15 + + "),
	            Arguments.of(23.0, "10 2 8 * + 3 -"),
	            Arguments.of(-15.0, "2 3 + 180 9 / -"),
	            Arguments.of(48.0, "5 3 + 8 2 - * x"),
	            Arguments.of(48.0, "124  0 /")
	    );
	}
}
