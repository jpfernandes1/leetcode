package org.solutions.q0912;
import java.util.concurrent.ThreadLocalRandom;
/*

    912. Sort an Array

Given an array of integers nums, sort the array in ascending order and return it.
You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.

Example 1:
Input: nums = [5,2,3,1]
Output: [1,2,3,5]
Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the
positions of other numbers are changed (for example, 1 and 5).

Example 2:
Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]
Explanation: Note that the values of nums are not necessarily unique.

Constraints:

1 <= nums.length <= 5 * 104
-5 * 104 <= nums[i] <= 5 * 104

 */

import java.util.concurrent.ThreadLocalRandom;

public class SortAnArray {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    // Overload to simplifies the call
    private void quickSort(int[] nums){
        quickSort(nums,0,nums.length-1);
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low >= high) return;

        int pivotIndex = randomPivot(low, high);
        swap(nums, pivotIndex, high); // move pivot para o final

        int partitionIndex = partition(nums, low, high);

        quickSort(nums, low, partitionIndex - 1);
        quickSort(nums, partitionIndex + 1, high);
    }

    private int randomPivot(int low, int high) {
        return ThreadLocalRandom.current().nextInt(low, high + 1);
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }

        swap(nums, i, high);
        return i;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

/**
 *
 * # Intuition
 * To sort the array efficiently without using built-in functions, we need an algorithm with average time
 * complexity of O(n log n) and minimal extra space.
 *
 * QuickSort is a strong candidate because:
 * - It sorts in-place.
 * - It has O(n log n) average time complexity.
 * - It requires only O(log n) extra space due to recursion.
 *
 * However, QuickSort can degrade to O(n²) if the pivot selection is poor (e.g., always choosing the last
 * element in a sorted array). To avoid this, we randomly select the pivot. This significantly reduces the
 * probability of consistently unbalanced partitions and keeps performance near O(n log n) on average.
 *
 * # Approach
 * 1. Use recursive QuickSort.
 * 2. Select a random pivot index within the current subarray.
 * 3. Swap the pivot with the last element.
 * 4. Partition the array using the Lomuto partition scheme.
 * 5. Recursively sort the left and right partitions.
 *
 * * The partition process ensures that:
 *     - All elements smaller than the pivot are placed before it.
 *     - All elements greater than or equal to the pivot are placed after it.
 *     - The pivot ends up in its final sorted position.
 *
 * # Complexity
 * - Time complexity:
 * Average case: $$O(n log n)$$
 * Worst case: $$O(n²)$$ (very unlikely due to random pivot)
 *
 * - Space complexity:
 * $$O(log n)$$ due to recursive stack calls.
 * Sorting is done in-place.
 *
 */