import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.solutions.q0058.LengthOfLastWord;

import java.util.stream.Stream;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.testng.Assert.assertEquals;


public class q0058 {

    LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();

static Stream<Arguments> vectorProvider(){
    return Stream.of(
            arguments("Hello World", 5),
            arguments("   fly me   to   the moon  ", 4),
            arguments("luffy is still joyboy", 6)

    );
}

    @ParameterizedTest
    @MethodSource("vectorProvider")
    void shouldReturnTheLenOfTheLastWord(String s, int wordLen){
    int result = lengthOfLastWord.lengthOfLastWord(s);
    assertEquals(result, wordLen);
    }
}
