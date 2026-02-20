import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.solutions.q0704.BinarySearch;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class q0704 {

    BinarySearch binarySearch = new BinarySearch();

    static Stream<Arguments> vectorProvider(){
        return Stream.of(
                arguments(new int[]{-1,0,3,5,9,12}, 9, 4),
                arguments(new int[]{-1,0,3,5,9,12}, 2, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("vectorProvider")
    public void binarySearch(int[] nums, int target, int expectedIndex){
        int result = binarySearch.search(nums, target);
        Assertions.assertEquals(expectedIndex, result);
    }
}
