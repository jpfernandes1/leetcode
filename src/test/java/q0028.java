import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.solutions.q0028.FindTheIndex;

import java.util.stream.Stream;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class q0028 {

    FindTheIndex find = new FindTheIndex();

    static Stream<Arguments> vectorProvider() {
           return Stream.of(
                    arguments("sadbutsad", "sad", 0),
                    arguments("leetcode", "leeto", -1),
                    arguments("aaa", "aaaa", -1),
                    arguments("a", "a", 0),
                    arguments("mississippi", "issippi", 4)
            );
    }

    @ParameterizedTest
    @MethodSource("vectorProvider")
    public void findTheIndex(String haystack, String needle, int expected) {
        int result = find.strStr(haystack, needle);
        Assertions.assertEquals(expected, result);
    }
}
