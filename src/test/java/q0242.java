import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.solutions.q0242.ValidAnagram;

import java.util.stream.Stream;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class q0242 {

    ValidAnagram validAnagram = new ValidAnagram();

    static Stream<Arguments> vectorProvider(){
        return Stream.of(
                arguments("anagram", "nagaram", true),
                arguments("ggii", "eekk", false),
                arguments("rat", "car", false));

    }

    @ParameterizedTest
    @MethodSource("vectorProvider")
    void isValidAnagramTest(String s, String t, boolean expected){
        boolean result = validAnagram.isAnagram(s, t);
        Assertions.assertEquals(expected, result);
    }
}
