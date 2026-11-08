// 153. Find Minimum in Rotated Sorted Array

// Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
// For example, the array nums = [0,1,2,4,5,6,7] might become:
// - [4,5,6,7,0,1,2] if it was rotated 4 times.
// - [0,1,2,4,5,6,7] if it was rotated 7 times.
//
// Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in
// the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
//
// Given the sorted rotated array nums of unique elements, return the minimum element of this array.
// You must write an algorithm that runs in O(log n) time.

// Constraints:
// - n == nums.length
// - 1 <= n <= 5000
// - -5000 <= nums[i] <= 5000
// - All the integers of nums are unique.
// - nums is sorted and rotated between 1 and n times.

public class Find_Minimum_In_Rotated_Sorted_Array {

    // My Solution
    static int findMin(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        int ans = -1;

        if (nums[s] < nums[e] || nums.length == 1)
            return nums[0];


        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] <= nums[nums.length - 1]) {
                e = mid - 1;
            } else {
                ans = mid;
                s = mid + 1;
            }
        }

        return nums[ans + 1];
    }

    private static String runTest(int[] nums, int expected) {
        try {
            int res = findMin(nums);
            return res + (res == expected ? " (Correct)" : " (Wrong)");
        } catch (Exception e) {
            return e.getClass().getSimpleName() + " (Wrong)";
        }
    }

    public static void main(String[] args) {
        // --- Provided Example Test Cases ---

        // Example 1:
        // Input: nums = [3,4,5,1,2]
        // Output: 1
        int[] nums1 = { 3, 4, 5, 1, 2 };
        System.out.println("Example 1: " + runTest(nums1, 1)); // Expected: 1

        // Example 2:
        // Input: nums = [4,5,6,7,0,1,2]
        // Output: 0
        int[] nums2 = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println("Example 2: " + runTest(nums2, 0)); // Expected: 0

        // Example 3:
        // Input: nums = [11,13,15,17]
        // Output: 11
        int[] nums3 = { 11, 13, 15, 17 };
        System.out.println("Example 3: " + runTest(nums3, 11)); // Expected: 11

        // --- Additional Test Cases ---

        // Test 1: Single element array
        int[] t1 = { 1 };
        System.out.println("Test 1:    " + runTest(t1, 1)); // Expected: 1

        // Test 2: Two elements, already sorted (rotated by 2)
        int[] t2 = { 1, 2 };
        System.out.println("Test 2:    " + runTest(t2, 1)); // Expected: 1

        // Test 3: Two elements, rotated by 1
        int[] t3 = { 2, 1 };
        System.out.println("Test 3:    " + runTest(t3, 1)); // Expected: 1

        // Test 4: Three elements, rotated by 1 (minimum in middle)
        int[] t4 = { 3, 1, 2 };
        System.out.println("Test 4:    " + runTest(t4, 1)); // Expected: 1

        // Test 5: Three elements, rotated by 2 (minimum at end)
        int[] t5 = { 2, 3, 1 };
        System.out.println("Test 5:    " + runTest(t5, 1)); // Expected: 1

        // Test 6: Rotated once, minimum is at the very end
        int[] t6 = { 2, 3, 4, 5, 1 };
        System.out.println("Test 6:    " + runTest(t6, 1)); // Expected: 1

        // Test 7: Rotated by length - 1, minimum is at index 1
        int[] t7 = { 5, 1, 2, 3, 4 };
        System.out.println("Test 7:    " + runTest(t7, 1)); // Expected: 1

        // Test 8: Rotated array with negative numbers
        int[] t8 = { -1, -3, -2 };
        System.out.println("Test 8:    " + runTest(t8, -3)); // Expected: -3

        // Test 9: Larger array with mix of negative and positive numbers
        int[] t9 = { 4, 5, -10, -5, 0, 2 };
        System.out.println("Test 9:    " + runTest(t9, -10)); // Expected: -10
    }
}
