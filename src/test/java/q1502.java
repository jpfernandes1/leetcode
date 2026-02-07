import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.solutions.q1502.CanMakeArithmeticProgressionFromSequence;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class q1502 {

    CanMakeArithmeticProgressionFromSequence canMakeArithmeticProgressionFromSequence = new CanMakeArithmeticProgressionFromSequence();

    static Stream<Arguments> vectorProvider(){
        return Stream.of(
               // arguments(new int[]{3,5,1}, true),
               // arguments(new int[]{1,2,4}, false),
               // arguments(new int[]{0,0,0,0}, true),
                arguments(new int[]{1,2,3,2,5}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("vectorProvider")
    void canMakeArithmeticProgressionFromSequenceTest(int[] arr, boolean expected){
        boolean result = canMakeArithmeticProgressionFromSequence.canMakeArithmeticProgression(arr);
        Assertions.assertEquals(expected, result);
    }
}
