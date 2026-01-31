package q0009;

import java.util.*;

/*
    Given an integer x, return true if x is a palindrome, and false otherwise.

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore, it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore, it is not a palindrome.

Constraints:  -231 <= x <= 231 - 1

Follow up: Could you solve it without converting the integer to a string?

 */
public class PalindromeNumber {

    /*
        Thoughts:  at first look using a stacks is the simplest way to inverse the elements order and compare.
     */
    public boolean isPalindrome(int x) {

        if (x < 0) return false;           // Negative numbers can't be Palindrome
        if (x < 10) return true;           // One-digit number is a Palindrome
        if (x % 10 == 0) return false;     // Numbers that end with 0 can't be palindromes

        List<Integer> digits = getArrayFromNumber(x);
        Stack<Integer> stack = buildStack(digits);

        return compareCollections(stack, digits);
    }

    /**
     *
     * This function uses a mathematical formula to obtain the digits from the least significant
     * to the most (reverse order)
     */
    public List<Integer> getArrayFromNumber(int x) {
        List<Integer> digits = new ArrayList<>();
        while (x > 0) {
            digits.add(x % 10);  // takes the last digit - less significant
            x /= 10;             // removes the last digit
        }
        return digits;
    }

    /**
     * After obtaining the list in reverse order, we need to put it on a stack to
     * extract it in the correct order and compare it.
     */
    public Stack<Integer> buildStack(List<Integer> digits){

        Stack<Integer> stack = new Stack<>();

        // Stack the digits in the correct order (most significant first).
        for (int i = 0; i <= digits.size() - 1; i++) {
            stack.push(digits.get(i));
        }
        return stack;
    }

    /**
     * This method compares the two collections built to check if the number is a Palindrome
     */
    public boolean compareCollections(Stack<Integer> stack, List<Integer> digits){

        for (int digit : digits) {
            if (digit != stack.pop()) {
                return false;
            }
        }
        return true;
    }

}
