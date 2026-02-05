package org.solutions.q0066;

/*
    66. Plus One

You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit
of the integer. The digits are ordered from most significant to least significant in left-to-right order.
The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].

Example 2:
Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].

Example 3:
Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].

Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9
digits does not contain any leading 0's.

 */

public class PlusOne {

    /*
        At first sign seems like i need to iterate from the end to the beginning and sum 1 to this.
        If it is a 9, should become a 0 and the next position gains 1.. and so on;
        If reach the limit of the vector, before incrementing we need to increase it length;

     */

    /*

        First written solution - It worked and is efficient, but with unnecessary complexity.
        public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0 ; i--) {
            if (digits[i] != 9) break;
            if (digits[i] == 9 && i == 0) {
                int[] newVector = new int[digits.length + 1];
                for (int n = digits.length - 1; n >= 0; n--) {
                    newVector[n + 1] = digits[n];
                }
                digits = newVector;
            }
        }

        for (int i = digits.length - 1; i >= 0 ; i--) {
            if (digits[i] != 9){
                    digits[i] += 1;
                    break;
                } else {
                    digits[i] = 0;
                    continue;
                }
            }
        return digits;
    }
     */

    // New solution, refactoring of the previous one with the same logic;
    public int[] plusOne(int[] digits) {

        // check all elements
        for (int i = digits.length - 1; i >= 0 ; i--) {
            // if its not a 9 just increment and finish
            if (digits[i] != 9) {
                digits[i] += 1;
                return digits;
            }
            // If its a nine, switch for 0 and go to the next loop;
            digits[i] = 0;
        }

        // If tho loop finish, it means that the element at index 0 was a 9 and now is a 0, so we need to create
        // a new vector with one more index and fill it with 1;
        int[] newVector = new int[digits.length + 1];
        newVector[0] = 1;

        return newVector;
    }
}

/**
 *
 * # Intuition
 * The number behaves exactly like manual addition. Starting from the last digit, adding one may cause a carry
 * if the digit is 9. This carry can propagate to the left until a digit smaller than 9 is found.
 * If  digits[0] is a 9, the result needs one extra digit at the beginning.
 *
 * # Approach
 * Traverse the array from right to left:
 * If the current digit is not 9, increment it and return the array immediately.
 * If the digit is 9, set it to 0 and continue to propagate the carry.
 * If the loop finishes, it means all digits were 9. In this case, create a new array with one extra position
 * and set the first digit to 1.
 *
 * # Complexity
 * - Time complexity:
 * $$O(n)$$, where n is the number of digits.
 *
 * - Space complexity:
 * $$O(1)$$ in the common case,
 * $$O(n)$$ only when a new array is required (all digits are 9).
 *
 */
