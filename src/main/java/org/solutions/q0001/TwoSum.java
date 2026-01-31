package org.solutions.q0001;

import java.util.HashMap;
import java.util.Map;

/*
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.

    Example 1:

    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
    Example 2:

    Input: nums = [3,2,4], target = 6
    Output: [1,2]
    Example 3:

    Input: nums = [3,3], target = 6
    Output: [0,1]

    Constraints:

    2 <= nums.length <= 10^4
    -10^9 <= nums[i] <= 10^9
    -10^9 <= target <= 10^9
    Only one valid answer exists.

    Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?

 */
 /*

// First solution thought - doesn't work because it is O(n²)
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            while (i + 1 < nums.length) {
                if (target == nums[i] + nums[i + 1]) {
                    return new int[]{i, i + 1};
                }
                i++;
            }
        }
        return new int[0];
    }
}
  */

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {

        // Creating a map we don't need a second iteration because we can store the viewed elements
        // and if we need to access them again it will be a O(1) operation
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // checkin for the value we need to achieve the target
            int missing = target - nums[i];
            if (map.containsKey(missing)) {
                return new int[]{map.get(missing), i};
            }
            // If the value we need is not in the map, add the current value and try again;
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
