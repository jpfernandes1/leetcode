import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.solutions.q0709.ToLowerCase;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class q709 {

    ToLowerCase toLowerCase = new ToLowerCase();

    static Stream<Arguments> vectorProvider(){
        return Stream.of(
                arguments("Hello", "hello"),
                arguments("here", "here"),
                arguments("LOVELY", "lovely")
        );
    }

    @ParameterizedTest
    @MethodSource("vectorProvider")
    void toLowerCaseTest(String s, String expected){
        String result = toLowerCase.toLowerCase(s);
        Assertions.assertEquals(expected, result);
    }
}
