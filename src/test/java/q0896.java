import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.solutions.q0896.MonoticArray;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class q0896 {

    MonoticArray monoticArray = new MonoticArray();

    static Stream<Arguments> vectorProvider(){
        return Stream.of(
                arguments(new int[]{1,2,2,3}, true),
                arguments(new int[]{6,5,4,4}, true),
                arguments(new int[]{1, 3, 2}, false),
                arguments(new int[]{1, 1, 0}, true),
                arguments(new int[]{3, 1, 9}, false)
        );
    }


    @ParameterizedTest
    @MethodSource("vectorProvider")
    void monoticArrayTest(int[] nums, boolean expected){
        boolean result = monoticArray.isMonotonic(nums);
        Assertions.assertEquals(expected, result);
    }
}
