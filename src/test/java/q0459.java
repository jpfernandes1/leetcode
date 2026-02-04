import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.solutions.q0459.RepeatedSubstringPatterns;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class q0459 {

    RepeatedSubstringPatterns repeatedSubstringPatterns =  new RepeatedSubstringPatterns();
    static Stream<Arguments> vectorProvider () {
        return Stream.of(
                arguments("abab", true),
                arguments("aba", false),
                arguments("abcabcabcabc", true),
                arguments("ab", false)
        );
    }


    @ParameterizedTest
    @MethodSource("vectorProvider")
    public void repeatedSubstringTest(String s, boolean expected){
        boolean result = repeatedSubstringPatterns.repeatedSubstringPattern(s);
        Assertions.assertEquals(expected, result);
    }
}

