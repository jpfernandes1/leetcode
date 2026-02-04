package org.solutions.q0459;

/*
    459. Repeated Substring Pattern

Given a string s, check if it can be constructed by taking a substring of it and appending
multiple copies of the substring together.

Example 1:

Input: s = "abab"
Output: true
Explanation: It is the substring "ab" twice.
Example 2:

Input: s = "aba"
Output: false
Example 3:

Input: s = "abcabcabcabc"
Output: true
Explanation: It is the substring "abc" four times or the substring "abcabc" twice.

Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.

 */

public class RepeatedSubstringPatterns {

    public boolean repeatedSubstringPattern(String s) {

        int textLen = s.length();
        if (textLen == 1) return false; // one char string can't have substring

        // The iteration needs to go halfway, because if the substring is bigger than string/2,
        // we can know that is no way to fit a repetition of it;
        for (int subLen = 1; subLen <= textLen/2; subLen++) {
            // if cant divide, cant be a repetition
            if (textLen % subLen == 0) {
                // each repetition increases the substring length
                String pattern = s.substring(0, subLen);
                boolean matched = true;

                // divide the string in small blocks with the substring size to compare if they are equals;
                // Lets start from the block 1, since the block 0 is the pattern we are testing;
                for (int block = 1; block < textLen/subLen ; block++) {
                    int start = block * subLen;
                    int end = start + subLen;

                    // If one of the blocks doesn't match, it finishes this loop for and get back to the loop for above
                    if (!pattern.equals(s.substring(start, end))) {
                        matched = false;
                        break;
                    }
                }
                if (matched) return true;
            }
        }
        return false;
    }
}

/**
 * # Intuition
 * Once a string can be formed by repeating a substring, then this substring must be a divisor of the string's total
 * length. Furthermore, the substring cannot be longer than half of the string, as it must repeat at least twice.
 *
 * # Approach
 * 1. Edge Case: A single-character string cannot have a repeating substring (returns false).
 * 2. Substring Length Iteration: Only consider substring lengths from 1 up to half the string length (textLen/2).
 * 3. Divisibility Check: For each candidate substring length, first verify that the total length is divisible by
 *    it (textLen % subLen == 0). If not, it's impossible for that substring to repeat and form the full string.
 * 4. Pattern Extraction: Extract the candidate substring (pattern) from the start of the string (indices 0 to subLen).
 * 5. Block Comparison: Divide the string into blocks of size subLen. Start comparing from the second block
 *    (block index 1) since the first block is the pattern itself. For each subsequent block, check if it equals pattern.
 * 6. Early Termination: If any block doesn't match, immediately break out of the inner loop and try the next substring length.
 * 7. Success Condition: If all blocks match for a given substring length, return true. If no substring length works,
 *    return false.
 *
 * # Complexity
 * - Time complexity:
 * $$O(n⋅d)$$ where n is the string length and d is the number of divisors of n. In the worst case we test all lengths
 * up to n/2 and the inner loop runs in O(n), giving $$O(n2)$$. However, with the divisibility check and early
 * termination, performance is much better in practice.
 *
 * - Space complexity:
 * $$O(1)$$ extra space (not counting the input string), as we only store a few integers and the pattern substring.
 */
