package org.solutions.q0896;

/*
    896. Monotonic Array

An array is monotonic if it is either monotone increasing or monotone decreasing.
An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
Given an integer array nums, return true if the given array is monotonic, or false otherwise.

Example 1:
Input: nums = [1,2,2,3]
Output: true

Example 2:
Input: nums = [6,5,4,4]
Output: true

Example 3:
Input: nums = [1,3,2]
Output: false

Constraints:

1 <= nums.length <= 105
-105 <= nums[i] <= 105

 */

public class MonoticArray {

    /*
        My first thought was to find the pattern by subtracting n+1 and n and the check
        if the following elements keep it;

     */

    public boolean isMonotonic(int[] nums) {

        int numLen = nums.length;

        // We need to get a beacon with the initial elements and then check if the others follow the same direction
        int flag = 0;
        for(int i = 0; i < numLen-1; i++) {
            // if the first ones are equals, try index + 1
            if (nums[i] - nums[i+1] == 0) {continue;}
            // If they're not equals, set flag with their difference (positive means is increasing, negative decreasing)
            flag = nums[i+1] - nums[i] ;
            break;
        }

        for (int n = 1; n < numLen - 1; n++){
            // If the current are equals, there is no way to take conclusion. Go to next step
            if (nums[n] == nums[n+1]){ continue;}
            // If flag is negative and n+1 is smaller than n, everything is ok, go to next step;
            if (flag < 0 && nums[n+1] - nums[n] < 0){continue;}
            // if flag is positive and n+1 é bigger than n, everything is ok, go to next step;
            if (flag > 0 && nums[n+1] - nums[n] > 0){continue;}

            // If none of the checks were actioned, it may return false immediately;
            return false;
        }
        return true;
    }
}

/**
 *
 * # Intuition
 * A monotonic array must follow a single direction: increasing or decreasing. Equal adjacent values do not define a
 * direction, so the first non-equal pair can be used as a reference to determine whether the array is increasing or decreasing.
 *
 * # Approach
 * First, scan the array to find the first pair of elements with different values and use it to define the direction
 * (increasing or decreasing). Then, iterate through the array and ensure that every non-equal adjacent pair follows the same direction.
 * If any pair violates the detected direction, return false.
 * If no violations are found, the array is monotonic.
 *
 * # Complexity
 * - Time complexity:
 * $$O(n)$$, where n is the length of the array.
 *
 * - Space complexity:
 * $$O(1)$$, since only a few variables are used.
 */