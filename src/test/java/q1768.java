import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.solutions.q1768.MergeStringsAlternately;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.testng.Assert.assertEquals;

public class q1768 {

        MergeStringsAlternately mergeStringsAlternately = new MergeStringsAlternately();

    static Stream<Arguments> vectorProvider() {
        return Stream.of(
                arguments("abc", "pqr", "apbqcr"),
                arguments("ab", "pqrs", "apbqrs"),
                arguments("abcd", "pq", "apbqcd")
        );
    }

    @ParameterizedTest
    @MethodSource("vectorProvider")
    public void mergeStringsTest(String a, String b,  String c) {
        String result = mergeStringsAlternately.mergeAlternately(a, b);
        assertEquals(result, c);
    }

}
