import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.solutions.q0912.SortAnArray;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class q0912 {

    SortAnArray sortAnArray = new SortAnArray();

    static Stream<Arguments> vectorProvider(){
        return Stream.of(
                arguments(new int[]{5,2,3,1}, new int[]{1,2,3,5}),
                arguments(new int[]{5,1,1,2,0,0}, new int[]{0,0,1,1,2,5})
        );
    }

    @ParameterizedTest
    @MethodSource("vectorProvider")
    void sortAnArrayTest(int[] nums, int[] expected){
        int[] result = sortAnArray.sortArray(nums);
        Assertions.assertArrayEquals(expected, result);
    }

}
