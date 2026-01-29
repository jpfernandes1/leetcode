
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.solutions.q0001.TwoSum;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class q0001 {

        TwoSum twoSum = new TwoSum();

    // Defining the parameters (3 different vectors + target + expected result)
    static Stream<Arguments> vectorProvider() {
        return Stream.of(
                arguments(new int[]{2,7,1,15}, 9, new int[]{0,1}),
                arguments(new int[]{3,2,4}, 6, new int[]{1,2}),
                arguments(new int[]{3,3}, 6, new int[]{0,1})
        );
    }

    @ParameterizedTest
    @MethodSource("vectorProvider")
    public void testTwoSum(int[] input, int targetSum, int[] expected) {
        int[] result = twoSum.twoSum(input, targetSum);
        assertArrayEquals(expected, result);

    }
}
