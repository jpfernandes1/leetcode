package org.solutions.q0013;

/*

13. Roman to Integer

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, 2 is written as II in Roman numeral, just two ones added together.
12 is written as XII, which is simply X + II. The number 27 is written as XXVII,
which is XX + V + II. Roman numerals are usually written largest to smallest from
left to right. However, the numeral for four is not IIII. Instead, the number four
is written as IV. Because the one is before the five we subtract it making four.
The same principle applies to the number nine, which is written as IX.
There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.
Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].

 */

public class RomanToInteger {

    public int romanToInt(String s) {

        if (s.length() > 15) return 0;
        if (s.isEmpty()) return 0;

        return calculateSum(s);
    }

    private int calculateSum(String s) {

        int sum = 0;
        int prevValue = 0;

        // Iteration from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            int currValue = getValue(s.charAt(i));

            // compare if the previous element is smaller than current.
            // If yes, subtract the current from the total sum;
            if (currValue < prevValue) {
                sum -= currValue;
            } else {
                sum += currValue;
        }

            // saves the current value to check in the next iteration
            prevValue = currValue;
        }
        return sum;
    }

    public int getValue(char c) {

        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}

/*

Intuition
    Roman numerals are normally written from largest to smallest left to right, but there are
    subtraction cases (like IV, IX) that require special handling. My initial thought was that
    processing the string from right to left would simplify the logic because subtraction cases
    become evident when a smaller numeral appears before a larger one in the normal reading direction.

Approach
    I iterate through the Roman numeral string from right to left. For each character, I convert
    it to its integer value using a mapping function. I maintain a running total and track the value
    of the previous numeral processed. When the current numeral's value is less than the previous one,
    it indicates a subtraction case (e.g., IV, IX), so I subtract the current value from the total.
    Otherwise, I add the current value. This approach eliminates the need for extra arrays or complex
    look-ahead logic.

Complexity
    Time complexity: O(n), where n is the length of the string. We traverse the string only once.
    Space complexity: O(1), as we use only a few integer variables regardless of input size.

 */
