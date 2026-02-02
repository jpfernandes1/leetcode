package org.solutions.q0028;

/*

    28. Find the Index of the First Occurrence in a String

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.

Example 2:
Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.

Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.

 */

public class FindTheIndex {

/*
# Intuition
My first thought was to scan thought the haystack and, whenever we encounter a character matching the
first character of the needle, perform a detailed comparison of subsequent characters to check for a
complete match.

# Approach
I implemented a two-pointer sliding window approach:
1. Handle edge cases: return 0 for empty needle (following strStr convention),
   return -1 if needle is longer than haystack.
2. Iterate through haystack positions where a full match could still fit
   (up to `haystack.length() - needle.length()`).
   - Only perform detailed comparison when current character matches needle's first character.
   - For each potential match, compare subsequent characters in inner loop starting from index 1.
3. Return starting index if all needle characters match.
4. Return -1 if no complete match found after checking all positions.

# Complexity
- Time complexity:
Worst case: $$O((n-m+1) \times m)$$ where n = haystack length, m = needle length
Best case: $$O(n)$$ when first character matches are rare

- Space complexity:
$$O(1)$$, using only constant extra space for indices and comparisons.

 */

    public int strStr(String haystack, String needle) {

        if (needle.isEmpty()) {return -1;}
        if (haystack.length() < needle.length()) {return -1;}

        // Check while there are enough characters to include the entire needle,
        // If the number of remaining characters is less than the length of the needle
        // it is no longer possible to find it.
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
            int needleIndex = 0;
            // Once the first letter of needle match with any letter of haystack,
            // Compares the following haystack substring starting from i with the needle
            for (needleIndex = 1; needleIndex < needle.length(); needleIndex++) {
                // If one char doesn't match, return to the first iteration
                if (haystack.charAt(i + needleIndex) != needle.charAt(needleIndex)){
                    break;
                }
            }
                // If the inner loop has traversed the entire needle, we have found the match.
                if (needleIndex == needle.length()) {
                return i;
                }
            }
        }
        return -1;
    }
}
