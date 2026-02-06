import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.solutions.q1822.SignOfTheProductOfAnArray;

import java.util.stream.Stream;

public class q1822 {

    SignOfTheProductOfAnArray signOfTheProductOfAnArray = new SignOfTheProductOfAnArray();

    static Stream<Arguments> vectorProvider(){
        return Stream.of(
               Arguments.arguments(new int[]{-1,-2,-3,-4,3,2,1}, 1),
               Arguments.arguments(new int[]{1,5,0,2,-3}, 0),
               Arguments.arguments(new int[]{-1,1,-1,1,-1}, -1),
               Arguments.arguments(new int[]{41,65,14,80,20,10,55,58,24,56,28,86,96,10,3,84,4,41,13,32,42,43,83,78,82,70,15,-41}, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("vectorProvider")
    void signOfTheProductOfAnArrayTest(int[] nums, int expected){
        int result = signOfTheProductOfAnArray.arraySign(nums);
        Assertions.assertEquals(expected, result);
    }
}
