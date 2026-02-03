package org.solutions.q0242;

/*

242. Valid Anagram

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.

Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    /*
        My first thought is that the solution of this challenge is the same of the question 1768,
        sum the Unicode values of the chars of each string. If the final value is the same, t is
        an anagram of s.

    public boolean isAnagram(String s, String t) {

        // first of all let take the sum of the Unicode values of each element of the strings;
        int word1 = getUnicodeSum(s);
        int word2 = getUnicodeSum(t);

        return word1 == word2;
    }

    // this method gets the sum of the Unicode values of a String
    private int getUnicodeSum(String s) {
        int sum = 0;

        for (char c : s.toCharArray()) {
            sum += (int) c;
        }
        return sum;
    }
        But i failed on tests, because some different char can result in the same sum, just like:
        "ggii" -> 103 + 103 + 105 + 105 = 416
        "eekk" -> 101 + 101 + 107 + 107 = 416
     */

    /*

        My second approach was to create two frequency tables and, at the end,
        compare it the both are equals. This method works, but the efficiency
        was not so good (14 ms to process according to leetcode)

         public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {return false;}

        Map<Character, Integer> freqWord1 = mapCharFrequency(s);
        Map<Character, Integer> freqWord2 = mapCharFrequency(t);

        return freqWord1.equals(freqWord2);
    }

    private Map<Character, Integer> mapCharFrequency(String string) {

        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        return freqMap;
    }

     */

    /*

    # Intuition
    The core idea is that two strings are anagrams if they contain the same characters with the same frequencies.
    A frequency counter allows us to track how many times each character appears. By incrementing counts for one
    string and decrementing for the other, we can efficiently check if all counts balance to zero.

    # Approach
    1. Length Check: Immediately return false if the strings have different lengths, as anagrams must be the same length.
    2. Build Frequency Map: Iterate through the first string s, using a HashMap to count each character's occurrences
       (freq.put(c, freq.getOrDefault(c, 0) + 1)).
    3. Verify and Adjust with Second String: Iterate through the second string t:
    - If a character is not in the map, return false (it doesn't exist in s).
    - Get the current count. If it is 1, remove the character from the map entirely (since it will become zero).
      Use continue to skip the decrement step.
    - Otherwise, decrement the count (freq.put(c, count - 1)).

    4. Final Check: If the map is empty, all characters matched with exact frequencies, so return true.

    # Complexity
    - Time complexity:
    $$O(n)$$, where n is the length of the strings. Each character is processed exactly once in each loop.

    - Space complexity:
    $$O(1)$$ for the HashMap, as it stores at most 26 entries (for lowercase English letters).
    This is considered constant space.

    Third approach - one frequency map - created with s, decremented with t;
    This one also worked but reduce only 2 ms comparing with the previously
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {return false;}

        // Creating a freq table
        Map<Character, Integer> freq = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Decreasing according the second string
        for (char c : t.toCharArray()) {
            // If it doesn't contain the current character, its not a anagram;
            if (!freq.containsKey(c)) {
                return false;
            }

            int count = freq.get(c);
            if (count == 1) {
                freq.remove(c);
                continue;
            }

            freq.put(c, count - 1);
        }
        return freq.isEmpty();
    }

     */

    /* Fourth Approach
        This extra challenge gave me a hint:
        "Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?"
        (internet search about Unicode)

        Since s and t consist just of lowercase English letters, what if instead of building a map, I just used a vector
        where each index corresponds to a letter? Ex.: 0 -> a, 1 -> b, 2 -> c...
        Considering that the Unicode value of the lower case letters starts with 'a' (97), if we
        subtract any letter with this, we can reach the index of the new vector:
            a - a = 0;  b - a = 1; c - a = 2 ....
     */

    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {return false;};
        int UNICODE_VALUE_OF_A = (int) 'a';

        // Creating freq vector with the number of letters we'll use
        int[] freq = new int[26];

        // Filling the vector
        for (char c : s.toCharArray()) {
            freq[c - UNICODE_VALUE_OF_A] += 1;
        }

        // Decreasing the vector according to the letters;
        for (char c : t.toCharArray()) {
            if (freq[c - UNICODE_VALUE_OF_A] == 0){
                return false;
            }
            freq[c - UNICODE_VALUE_OF_A] -= 1;
        }

        // If the previous iteration complete, the two Strings are Anagrams;
        return true;
    }
}
