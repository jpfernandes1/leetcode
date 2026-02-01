import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.solutions.q0389.FindTheDifference;

import java.util.stream.Stream;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class q0389 {

    FindTheDifference diff = new FindTheDifference();
    static Stream<Arguments> vectorProvider() {
        return Stream.of(
                arguments("abcd", "abcde", "e"),
                arguments("", "y", "y")
        );
    }

    @ParameterizedTest
    @MethodSource("vectorProvider")
    public void findTheDifferenceTest(String s1, String s2, char expected) {
        char result =  diff.findTheDifference(s1, s2);
        Assertions.assertEquals(expected, result);
    }
}
