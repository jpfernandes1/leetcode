import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.solutions.q0066.PlusOne;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class q0066 {

    PlusOne plusOne = new PlusOne();

    static Stream<Arguments> vectorProvider(){
        return Stream.of(
                arguments(new int[]{1, 2, 3}, new int[]{1, 2, 4}),
                arguments(new int[]{4, 3, 2, 1}, new int[]{4, 3, 2, 2}),
                arguments(new int[]{9, 9}, new int[]{1, 0, 0}),
                arguments(new int[]{9, 1, 9}, new int[]{9, 2, 0}),
                arguments(new int[]{9,8,7,6,5,4,3,2,1,0}, new int[]{9,8,7,6,5,4,3,2,1,1}),
                arguments(new int[]{9}, new int[]{1,0})
        );
    }

    @ParameterizedTest
    @MethodSource("vectorProvider")
    public void plusOneTest(int[] digits, int[] expected){
        int[] result = plusOne.plusOne(digits);
        Assertions.assertArrayEquals(expected, result);
    }
}
