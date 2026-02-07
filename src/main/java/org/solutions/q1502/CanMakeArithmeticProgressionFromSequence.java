package org.solutions.q1502;

/*

    1502. Can Make Arithmetic Progression From Sequence

A sequence of numbers is called an arithmetic progression if the difference between any two consecutive
elements is the same. Given an array of numbers arr, return true if the array can be rearranged to form
an arithmetic progression. Otherwise, return false.

Example 1:
Input: arr = [3,5,1]
Output: true
Explanation: We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively,
between each consecutive elements.

Example 2:
Input: arr = [1,2,4]
Output: false
Explanation: There is no way to reorder the elements to obtain an arithmetic progression.

Constraints:
2 <= arr.length <= 1000
-106 <= arr[i] <= 106
 */

public class CanMakeArithmeticProgressionFromSequence {

    public boolean canMakeArithmeticProgression(int[] arr) {

        int arrLen = arr.length;
        int max = arr[0];
        int min = arr[0];

        for(int n : arr){
            if(n > max) max = n;
            if(n < min) min = n;
        }

        if ((max-min)%(arrLen - 1) != 0) return false;

        // calculate the difference between the numbers
        int rate = (max-min)/(arrLen - 1);

        // If max == min, all the elements are the same and arr is an arithmetic progression with increase rate 0;
        if(max == min) return true;

        // Position control to know if an element appear more than once
        boolean[] seen = new boolean[arrLen];

        for (int v : arr) {

            // Distance from the current value to the first
            int diffToFirst = v - min;
            // If it does not correspond exactly to a step in the arithmetic progression, it is invalid.
            if (diffToFirst % rate != 0) return false;
            // Index where this value should be
            int index = diffToFirst / rate;
            // Out of the Out of range or duplicate = failure.
            if (index < 0 || index >= arrLen || seen[index]) return false;
            // Set position as busy
            seen[index] = true;
        }

        return true;
    }
}
