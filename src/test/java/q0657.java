import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.solutions.q0657.RobotReturnToOrigin;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class q0657 {

    RobotReturnToOrigin robotReturnToOrigin = new RobotReturnToOrigin();

    static Stream<Arguments> vectorProvider(){
        return Stream.of(
                arguments("UD", true),
                arguments("LL", false)
        );
    }

    @ParameterizedTest
    @MethodSource("vectorProvider")
    void robotReturnToOriginTest(String moves, boolean expected){
        boolean result = robotReturnToOrigin.judgeCircle(moves);
        Assertions.assertEquals(expected, result);
    }
}
