package org.solutions.q0283;

import java.util.Arrays;

/*
    283. Move Zeroes

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]

Constraints:
1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1

Follow up: Could you minimize the total number of operations done?
 */
public class MoveZeroes {
/*
    My first intuition is to create a loop that finds a zero and then a second loop search for the next number
    that is not a zero and the switch them. This works, But is not efficient (46 ms to run in LeetCode).


    public void moveZeroes(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {

                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
            }
        }
    }
*/
    /* Second solution - One loop
        I thought about creating just one loop and use a marker to know where to switch.
     */

    public void moveZeroes(int[] nums) {

        // the current index to switch
        int indexChange = 0;
        int numsLen = nums.length;

        // First indentify all the numbers != 0 and switch with the current indexChange of each loop
        for (int i = 0; i < numsLen; i++){
            if (nums[i] != 0){
                nums[indexChange] = nums[i];
                indexChange++;
            }
        }

        // Then we need to fill the remaining positions of the vector with 0;
        while(indexChange != numsLen){
            nums[indexChange] = 0;
            indexChange++;
        }
    }
}

/**
 *
 * # Intuition
 * The core challenge is to move all zeros to the end while preserving the relative order of non-zero elements.
 * Instead of swapping each zero with subsequent non-zero elements (which could be O(n²)), we can think about
 * rebuilding the array in two phases: first, collect all non-zero elements in their original order,
 * then fill the remaining positions with zeros.
 *
 * # Approach
 *
 * 1. Use a write pointer (indexChange) that tracks where the next non-zero element should be placed.
 * 2. Iterate through the array, and whenever a non-zero element is found, copy it to the indexChange
 *    position and increment the pointer.
 * 3. After processing all elements, fill all remaining positions from indexChange to the end of the array with zeros.
 *
 * This approach ensures each element is processed exactly once in each phase, minimizing operations while maintaining
 * the required order.
 *
 * # Complexity
 * - Time complexity:
 * $$O(n)$$, where n is the length of the array. We perform two linear passes: one to move non-zero elements and
 * one to fill zeros.
 *
 * - Space complexity:
 * $$O(1)$$, as the algorithm operates in-place with only a constant amount of extra space for pointers.
 *
 */

