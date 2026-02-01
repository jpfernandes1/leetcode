package org.solutions.q1768;

/*
    1768. Merge Strings Alternately

You are given two strings word1 and word2. Merge the strings by adding letters in alternating order,
starting with word1. If a string is longer than the other, append the additional letters onto the end
of the merged string.

Return the merged string.

Example 1:

Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r

Example 2:

Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b
word2:    p   q   r   s
merged: a p b q   r   s
Example 3:

Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q
merged: a p b q c   d

Constraints:

1 <= word1.length, word2.length <= 100
word1 and word2 consist of lowercase English letters.
 */

public class MergeStringsAlternately {

    /* FIRST SOLUTION THOUGHT

    public String mergeAlternately(String word1, String word2) {
        StringBuilder merged = new StringBuilder();
        boolean nextStep = false;

        if (word1.length() > word2.length() || word1.length() == word2.length()) {
            for (int i = 0; i < word1.length(); i++) {
                merged.append(word1.charAt(i));
                nextStep = true;
                while (nextStep && i < word2.length()) {
                    merged.append(word2.charAt(i));
                    nextStep = false;
                }
            }
        } else {
            for (int i = 0; i < word2.length(); i++) {
                if (i < word1.length()) {
                merged.append(word1.charAt(i));
                }
                merged.append(word2.charAt(i));
            };
        }
        return merged.toString();
    }
     */

    // SECOND SOLUTION THOUGHT - simpler logic
    public String mergeAlternately(String word1, String word2) {

        int longLength = word1.length() > word2.length() ? word1.length() : word2.length();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < longLength; i++) {
            if (i < word1.length()) {
                result.append(word1.charAt(i));
            }

            if (i < word2.length()) {
                result.append(word2.charAt(i));
            }
        }
        return result.toString();
    }
}

/**
 * # Intuition
 * I started by considering how to handle strings of different lengths while maintaining alternating order.
 * Initially, I thought about creating separate logic paths based on which string was longer. However,
 * I realized a simpler approach: iterate through the maximum length of both strings and conditionally
 * append characters only when the index is within each string's bounds.
 *
 * # Approach
 * The solution uses a single loop that runs for the length of the longer string. In each iteration,
 * it first checks if the current index is within the bounds of word1 and appends that character if so.
 * Then it checks if the index is within word2 and appends that character. This ensures that characters
 * are added in alternating order until one string is exhausted, after which the remaining characters of
 * the longer string are appended.
 *
 * # Complexity
 *
 * - Time complexity:
 * $$O(max(n, m))$$ where n = word1.length() and m = word2.length()
 *
 * - Space complexity:
 * $$O(n + m)$$ for the StringBuilder that stores the merged result
 */
