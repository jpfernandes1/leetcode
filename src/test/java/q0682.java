import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.solutions.q0682.BaseballGame;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class q0682 {

    BaseballGame baseballGame = new BaseballGame();

    static Stream<Arguments> vectorProvider(){
        return Stream.of(
                arguments(new String[]{"5","2","C","D","+"}, 30),
                arguments(new String[]{"5","-2","4","C","D","9","+","+"}, 27),
                arguments(new String[]{"1","C"}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("vectorProvider")
    void baseballGameTest(String[] operations, int expected){
        int result = baseballGame.calPoints(operations);
        Assertions.assertEquals(expected, result);
    }
}

/**
 *
 * # Intuition
 * Since operations depend on the most recent valid scores, a stack is a natural choice because it provides easy access
 * to the last inserted elements. Every time we push a value into the stack, we add it to a variable called sum.
 * Every time we remove a value, we subtract it from the sum. This avoids another iteration at the end just to get the total score.
 *
 * # Approach
 * 1. Initialize a stack to store valid scores.
 * 2. Maintain an integer sum to track the total score dynamically.
 * 3. Iterate through each operation:
 *
 * "+":
 * Temporarily pop the last score.
 * Compute the new score as the sum of the last two scores.
 * Push both values back in correct order.
 * Add the new score to sum.
 *
 * "D":
 * Double the last score.
 * Push it onto the stack.
 * Add it to sum.
 *
 * "C":
 * Pop the last score.
 * Subtract it from sum.
 *
 * Integer value:
 * Parse it.
 * Push it to the stack.
 * Add it to sum.
 * Return sum.
 *
 * All operations are processed in a single pass.
 *
 * # Complexity
 * - Time complexity:
 * &&O(n)&& We iterate through the operations array once.
 * Each stack operation (push, pop, peek) runs in O(1).
 * Therefore, the total time complexity is linear.
 *
 * - Space complexity:
 * In the worst case, all operations are valid scores and stored in the stack.
 * Thus, auxiliary space grows linearly with input size.
 *
 */