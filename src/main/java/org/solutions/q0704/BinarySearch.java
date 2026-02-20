package org.solutions.q0704;

/*

    704. Binary Search

Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to
search target in nums. If target exists, then return its index. Otherwise, return -1.
You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1

Constraints:
1 <= nums.length <= 104
-104 < nums[i], target < 104
All the integers in nums are unique.
nums is sorted in ascending order.

 */

public class BinarySearch {

    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high){
            int middlePosition = (low + high)/2;
            int middleNumber = nums[middlePosition];

            if (target == middleNumber){
                return middlePosition;
            }

            if (target < middleNumber){
                high = middlePosition - 1;
            } else {
                low = middlePosition + 1;
            }
        }
        return -1;
    }
}

/**
 *
 * # Intuition
 * Since the array is already sorted in ascending order, we don’t need to scan it linearly. Binary Search works by:
 * - Checking the middle element.
 * - If the target is smaller, discard the right half.
 * - If the target is larger, discard the left half.
 * - Repeat the process on the remaining half.
 *
 * Each step cuts the search space in half.
 * That’s why the time complexity becomes O(log n) instead of O(n).
 *
 * # Approach
 *
 * 1. Initialize two pointers:
 * - low at the beginning of the array.
 * - high at the end of the array.
 *
 * 2. While low <= high:
 * - Compute the middle index.
 * - Compare the middle element with the target.
 * - If equal → return the index.
 * - If target is smaller → move high left.
 * - If target is larger → move low right.
 *
 * 3. If the loop ends, the element does not exist → return -1.
 * This implementation is iterative, avoiding recursion stack usage.
 *
 * # Complexity
 * - Time complexity:
 * $$O(log n)$$ Each iteration halves the search space.
 *
 * - Space complexity:
 * $$O(1)$$ No additional memory is used.
 *
 */
