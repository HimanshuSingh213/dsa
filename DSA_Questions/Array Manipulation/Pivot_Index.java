// 724. Find Pivot Index

// Given an array of integers nums, calculate the pivot index of this array.
//
// The pivot index is the index where the sum of all the numbers strictly to the
// left of the index is equal to the sum of all the numbers strictly to the right
// of the index.
//
// If the index is on the left edge of the array, then the left sum is 0 because
// there are no elements to the left. This also applies to the right edge of the array.
//
// Return the leftmost pivot index. If no such index exists, return -1.

// Constraints:
// - 1 <= nums.length <= 10^4
// - -1000 <= nums[i] <= 1000

public class Pivot_Index {

    // My Solution
    static int pivotIndex(int[] nums) {
        int leftSum = 0;
        int total = 0;

        for (int i : nums) {
            total += i;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                leftSum += nums[i - 1];
            }

            if (total - nums[i] - leftSum == leftSum) {
                return i;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        // --- Provided Example Test Cases ---

        // Example 1:
        // Input: nums = [1,7,3,6,5,6]
        // Output: 3
        int[] nums1 = { 1, 7, 3, 6, 5, 6 };
        int res1 = pivotIndex(nums1);
        System.out.println("Example 1: " + res1 + (res1 == 3 ? " (Correct)" : " (Wrong)")); // Expected: 3

        // Example 2:
        // Input: nums = [1,2,3]
        // Output: -1
        int[] nums2 = { 1, 2, 3 };
        int res2 = pivotIndex(nums2);
        System.out.println("Example 2: " + res2 + (res2 == -1 ? " (Correct)" : " (Wrong)")); // Expected: -1

        // Example 3:
        // Input: nums = [2,1,-1]
        // Output: 0
        int[] nums3 = { 2, 1, -1 };
        int res3 = pivotIndex(nums3);
        System.out.println("Example 3: " + res3 + (res3 == 0 ? " (Correct)" : " (Wrong)")); // Expected: 0

        // --- Additional Test Cases ---

        // Test 1: Single element with zero
        int[] t1 = { 0 };
        int r1 = pivotIndex(t1);
        System.out.println("Test 1:    " + r1 + (r1 == 0 ? " (Correct)" : " (Wrong)")); // Expected: 0

        // Test 2: Single element with non-zero positive value
        int[] t2 = { 5 };
        int r2 = pivotIndex(t2);
        System.out.println("Test 2:    " + r2 + (r2 == 0 ? " (Correct)" : " (Wrong)")); // Expected: 0

        // Test 3: Two elements, both zero
        int[] t3 = { 0, 0 };
        int r3 = pivotIndex(t3);
        System.out.println("Test 3:    " + r3 + (r3 == 0 ? " (Correct)" : " (Wrong)")); // Expected: 0

        // Test 4: Two elements with right element zero (pivot at index 0)
        int[] t4 = { 1, 0 };
        int r4 = pivotIndex(t4);
        System.out.println("Test 4:    " + r4 + (r4 == 0 ? " (Correct)" : " (Wrong)")); // Expected: 0

        // Test 5: Two elements with left element zero (pivot at index 1)
        int[] t5 = { 0, 1 };
        int r5 = pivotIndex(t5);
        System.out.println("Test 5:    " + r5 + (r5 == 1 ? " (Correct)" : " (Wrong)")); // Expected: 1

        // Test 6: Array with negative numbers where leftmost index is pivot
        int[] t6 = { -1, -1, -1, 0, 1, 1 };
        int r6 = pivotIndex(t6);
        System.out.println("Test 6:    " + r6 + (r6 == 0 ? " (Correct)" : " (Wrong)")); // Expected: 0

        // Test 7: Array of all zeros (returns leftmost index 0)
        int[] t7 = { 0, 0, 0 };
        int r7 = pivotIndex(t7);
        System.out.println("Test 7:    " + r7 + (r7 == 0 ? " (Correct)" : " (Wrong)")); // Expected: 0

        // Test 8: Symmetrical array with no valid pivot
        int[] t8 = { 1, 2, 2, 1 };
        int r8 = pivotIndex(t8);
        System.out.println("Test 8:    " + r8 + (r8 == -1 ? " (Correct)" : " (Wrong)")); // Expected: -1

        // Test 9: Zero prefix sum cancellation in middle
        int[] t9 = { -1, -1, 1, 1, 0, 0 };
        int r9 = pivotIndex(t9);
        System.out.println("Test 9:    " + r9 + (r9 == 4 ? " (Correct)" : " (Wrong)")); // Expected: 4
    }
}
