package org.solutions.q0058;

/*
    58. Length of Last Word

Given a string s consisting of words and spaces, return the length of the last word in the string.
A word is a maximal substring consisting of non-space characters only.

Example 1:
Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.

Example 2:
Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.

Example 3:
Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.

Constraints:
1 <= s.length <= 104
s consists of only English letters and spaces ' '.
There will be at least one word in s.

 */

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {

        int counter = 0;
        int i = s.length()-1;

        while(i > 0) {
            if (s.charAt(i) != ' ') {
                break;
            }
                i--;
        }

        for (int k = i; k >= 0; k--) {
            char c = s.charAt(k);
            if (c == ' '){
                break;
            }
            counter += 1;
        }
        return counter;
    }
}

/**
 * # Intuition
 * The last word in the string is the final sequence of non-space characters. Since the string may contain
 * trailing spaces, the safest approach is to scan the string from the end. First, skip any trailing spaces.
 * Then, count characters until a space is found or the beginning of the string is reached. This avoids extra
 * space usage like split() and keeps the solution efficient.
 *
 * # Approach
 * 1. Start from the last index of the string.
 * 2. Move left while the current character is a space (skip trailing spaces).
 * 3. Once a non-space character is found, start counting.
 * 4. Continue moving left until a space is found or the string ends.
 * 5. Return the counter.
 *
 * This ensures we only traverse the string once.
 *
 * # Complexity
 * - Time complexity:
 * $$O(n)$$: In the worst case, we traverse the entire string once.
 *
 * - Space complexity:
 * $$O(1)$$: We only use a few integer variables.
 */