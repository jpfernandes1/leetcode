package org.solutions.q0709;

/*

    709. To Lower Case

Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.

Example 1:
Input: s = "Hello"
Output: "hello"

Example 2:
Input: s = "here"
Output: "here"

Example 3:
Input: s = "LOVELY"
Output: "lovely"

Constraints:

1 <= s.length <= 100
s consists of printable ASCII characters.

 */

public class ToLowerCase {

    public String toLowerCase(String s) {

        StringBuilder string = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                string.append((char) (c + 32));
            } else {
                string.append((char) (c));
            }
        }
        return string.toString();
    }
}

/**
 *
 * # Intuition
 * The problem asks to convert every uppercase letter in a given string to its lowercase equivalent.
 *
 * In ASCII:
 * Uppercase letters range from 'A' (65) to 'Z' (90)
 * Lowercase letters range from 'a' (97) to 'z' (122)
 *
 * The difference between uppercase and lowercase letters is 32
 * So, for each character in the string, if it falls within the uppercase range ('A' to 'Z'), we convert it by adding 32.
 * Otherwise, we keep the character unchanged
 *
 * I used a StringBuilder to efficiently construct the resulting string.
 *
 * # Approach
 * 1. Initialize a StringBuilder.
 * 2. Iterate through each character of the input string.
 * 3. Check if the character is between 'A' and 'Z'.
 * 4. If true, append (char)(c + 32) to the builder.
 * 5. Otherwise, append the original character.
 * 6. Return the built string.
 *
 * # Complexity
 * - Time complexity:
 * $$O(n)$$ iterate through the string once.
 *
 * - Space complexity:
 * $$O(n)$$ We create a new string to store the result.
 *
 */