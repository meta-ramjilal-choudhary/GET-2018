import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class InfixToPostfixTest {

	@ParameterizedTest(name = "{index} => postExp={0}, infixExp={1}")
	@MethodSource("ExpressionProvider")
	void test(String postExp, String infixExp) {
		InfixToPostfix infToPost = new InfixToPostfix();
		try {
			Assertions.assertEquals(postExp, infToPost.convertInfixToPostfix(infixExp));
		}
		catch(EmptyStackException e) {
			System.out.println("Not a valid  Infix expression");
		}
		catch(NumberFormatException e){
			System.out.println("Not a valid  Infix expression");
		}
	}
	
	private static Stream<Arguments> ExpressionProvider() {
	    return Stream.of(
	            Arguments.of("2 3 + 5 6 * < ", "( 2 + 3 < 5 * 6 ) "),
	            Arguments.of("2 80 2 / 30 - * 100 + ", "( 2 * ( 80 / 2 - 30 ) + 100 )"),
	            Arguments.of("1 2 7 * 78 - + ", "1 + 2 * 7 - 78"),
	            Arguments.of("2 5 <= 7 3 >= && 6 6 == || ", "( 2 <= 5 && 7 >= 3 || 6 == 6 )")
	    );
	}

}
