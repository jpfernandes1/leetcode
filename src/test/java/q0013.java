import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.solutions.q0013.RomanToInteger;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class q0013 {

    RomanToInteger romanToInteger = new RomanToInteger();

    static Stream<Arguments> vectorProvider() {

        return Stream.of(
                arguments("III", 3),
                arguments("LVIII", 58),
                arguments("MCMXCIV", 1994)
        );
    }

    @ParameterizedTest
    @MethodSource("vectorProvider")
    public void romanToIntegerTest(String s, int expected) {
        int result = romanToInteger.romanToInt(s);
        Assertions.assertEquals(expected, result);
    }
}
