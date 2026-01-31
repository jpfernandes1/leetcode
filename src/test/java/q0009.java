import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.solutions.q0009.PalindromeNumber;

import java.util.stream.Stream;
import static org.junit.jupiter.params.provider.Arguments.arguments;


public class q0009 {

   PalindromeNumber palindromeNumber = new PalindromeNumber();

   static Stream<Arguments> vectorProvider() {
       return Stream.of(
             arguments(121, true),
             arguments(-121, false),
             arguments(10, false),
             arguments(123, false)
       );
   }

   @ParameterizedTest
   @MethodSource("vectorProvider")
   public void testPalindromeNumber(Integer number, boolean expected) {
       boolean result = palindromeNumber.isPalindrome(number);
       Assertions.assertEquals(expected, result);
   }

}
