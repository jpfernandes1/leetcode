import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.solutions.q0283.MoveZeroes;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class q0283 {

    MoveZeroes moveZeroes = new MoveZeroes();

    static Stream<Arguments> vectorProvider(){
        return Stream.of(
               arguments(new int[]{0, 1, 0, 3, 12}, new int[]{1, 3, 12, 0, 0}),
               arguments(new int[]{0, 1, 0}, new int[]{1, 0, 0}),
               arguments(new int[]{0, 0, 1}, new int[]{1, 0, 0}),
               arguments(new int[]{0}, new int[]{0})
        );
    }

    @ParameterizedTest
    @MethodSource("vectorProvider")
    public void moveZeroes(int[] nums, int[] expected){
        moveZeroes.moveZeroes(nums);

        Assertions.assertArrayEquals(expected, nums);
    }
}
