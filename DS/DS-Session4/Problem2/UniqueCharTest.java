import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class UniqueCharTest {

	@ParameterizedTest(name = "{index} => string={0}, totalUnique={1}")
	@MethodSource("stringProvider")
	void testUniqueCharCounter(String string, int totalUnique) {
		UniqueChar uniChar = new UniqueChar();
		Assertions.assertEquals(totalUnique, uniChar.numberOfUniqueChar(string));
	}

	private static Stream<Arguments> stringProvider(){
		return Stream.of(
                Arguments.of("abcda", 4),
                Arguments.of("abcdeabcd", 5),
                Arguments.of("aaaaaaaaa", 1),
                Arguments.of("aaaaaaaaaaabbbbbbbbbbbaaaaaaaaaacccccccccdddddd", 4),
                Arguments.of("abcd#$1235ab#45#$df898", 14),
                Arguments.of("", 0),
                Arguments.of(null, 0)
        );
	}
}
