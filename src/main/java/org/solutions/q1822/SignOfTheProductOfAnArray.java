package org.solutions.q1822;

/*

    1822. Sign of the Product of an Array

Implement a function signFunc(x) that returns:

1 if x is positive.
-1 if x is negative.
0 if x is equal to 0.
You are given an integer array nums. Let product be the product of all values in the array nums.

Return signFunc(product).

Example 1:
Input: nums = [-1,-2,-3,-4,3,2,1]
Output: 1
Explanation: The product of all values in the array is 144, and signFunc(144) = 1

Example 2:
Input: nums = [1,5,0,2,-3]
Output: 0
Explanation: The product of all values in the array is 0, and signFunc(0) = 0

Example 3:
Input: nums = [-1,1,-1,1,-1]
Output: -1
Explanation: The product of all values in the array is -1, and signFunc(-1) = -1

Constraints:

1 <= nums.length <= 1000
-100 <= nums[i] <= 100

 */

public class SignOfTheProductOfAnArray {

    /*
        My first thought was to iterate on the vector and use a variable to keep the current signal.
        The math is simple, if the nums[i] element is negative, we multiply the variable by -1 and it
        becomes negative. But if another negative element appears, multiplying by -1 again will turn it positive.
        If a zero appears in the iteration, return 0 immediately, because from then on, all multiplications will
        result in 0.

     */
    public int arraySign(int[] nums) {
        int result = 1;

        for (int n : nums) {
            // Always a negative element appears, change the signal;
            if (n < 0) {
                result *= -1;
            }
            // If a zero appears, all the following multiplications would result in 0
            if (n == 0) {
                return 0;
            }
        }
        // If no zeros appear, just re
        return result;
    }
}

/**
 *
 * # Intuition
 * The problem does not require computing the actual product of the array, only its sign.
 * Multiplying large values is unnecessary and may cause overflow.
 *
 * # Approach
 * Iterate through the array while maintaining a variable representing the current sign:
 *
 * initialize the sign as 1;
 * if a value is negative, multiply the sign by -1;
 * if a value is 0, return 0 immediately;
 * after processing all elements, return the final sign.
 *
 * # Complexity
 * - Time complexity:
 * $$O(n)$$, where n is the length of the array.
 *
 * - Space complexity:
 * $$O(1)$$, since only a single variable is used.
 *
 */