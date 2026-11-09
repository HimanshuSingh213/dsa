// 33. Search in Rotated Sorted Array

// There is an integer array nums sorted in ascending order (with distinct values).
//
// Prior to being passed to your function, nums is possibly rotated at an unknown
// pivot index k (1 <= k < nums.length) such that the resulting array is
// [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
//
// Given the array nums after the possible rotation and an integer target, return
// the index of target if it is in nums, or -1 if it is not in nums.
//
// You must write an algorithm with O(log n) runtime complexity.

// Constraints:
// - 1 <= nums.length <= 5000
// - -10^4 <= nums[i] <= 10^4
// - All values of nums are unique.
// - nums is an ascending array that is possibly rotated.
// - -10^4 <= target <= 10^4

public class Search_In_Rotated_Sorted_Array {

    // My Solution
    static int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        int pivot = -1;

        if (nums[e] >= nums[s]) {
            while (s <= e) {
                int mid = s + (e - s) / 2;
                if (nums[mid] == target) {
                    return mid;
                }

                else if (nums[mid] > target) {
                    e = mid - 1;
                }

                else {
                    s = mid + 1;
                }
            }

            return -1;

        } 
        else
            while (s <= e) {
                int mid = s + (e - s) / 2;

                if (nums[mid] <= nums[nums.length - 1]) {
                    e = mid - 1;
                } else {
                    pivot = mid;
                    s = mid + 1;
                }
            }

        if (target > nums[nums.length - 1]) {
            s = 0;
            e = pivot;
        } else {
            s = pivot + 1;
            e = nums.length - 1;
        }

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            else if (nums[mid] > target) {
                e = mid - 1;
            }

            else {
                s = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // --- Provided Example Test Cases ---

        // Example 1:
        // Input: nums = [4,5,6,7,0,1,2], target = 0
        // Output: 4
        int[] nums1 = { 4, 5, 6, 7, 0, 1, 2 };
        int res1 = search(nums1, 0);
        System.out.println("Example 1: " + res1 + (res1 == 4 ? " (Correct)" : " (Wrong)")); // Expected: 4

        // Example 2:
        // Input: nums = [4,5,6,7,0,1,2], target = 3
        // Output: -1
        int[] nums2 = { 4, 5, 6, 7, 0, 1, 2 };
        int res2 = search(nums2, 3);
        System.out.println("Example 2: " + res2 + (res2 == -1 ? " (Correct)" : " (Wrong)")); // Expected: -1

        // Example 3:
        // Input: nums = [1], target = 0
        // Output: -1
        int[] nums3 = { 1 };
        int res3 = search(nums3, 0);
        System.out.println("Example 3: " + res3 + (res3 == -1 ? " (Correct)" : " (Wrong)")); // Expected: -1

        // --- Additional Test Cases ---

        // Test 1: Single element, target present
        int[] t1 = { 1 };
        int r1 = search(t1, 1);
        System.out.println("Test 1:    " + r1 + (r1 == 0 ? " (Correct)" : " (Wrong)")); // Expected: 0

        // Test 2: Two elements unrotated, target is first element
        int[] t2 = { 1, 3 };
        int r2 = search(t2, 1);
        System.out.println("Test 2:    " + r2 + (r2 == 0 ? " (Correct)" : " (Wrong)")); // Expected: 0

        // Test 3: Two elements unrotated, target is second element
        int[] t3 = { 1, 3 };
        int r3 = search(t3, 3);
        System.out.println("Test 3:    " + r3 + (r3 == 1 ? " (Correct)" : " (Wrong)")); // Expected: 1

        // Test 4: Two elements rotated, target is first element
        int[] t4 = { 3, 1 };
        int r4 = search(t4, 3);
        System.out.println("Test 4:    " + r4 + (r4 == 0 ? " (Correct)" : " (Wrong)")); // Expected: 0

        // Test 5: Two elements rotated, target is second element
        int[] t5 = { 3, 1 };
        int r5 = search(t5, 1);
        System.out.println("Test 5:    " + r5 + (r5 == 1 ? " (Correct)" : " (Wrong)")); // Expected: 1

        // Test 6: Target is maximum element (at pivot)
        int[] t6 = { 4, 5, 6, 7, 0, 1, 2 };
        int r6 = search(t6, 7);
        System.out.println("Test 6:    " + r6 + (r6 == 3 ? " (Correct)" : " (Wrong)")); // Expected: 3

        // Test 7: Target in the left sorted segment
        int[] t7 = { 4, 5, 6, 7, 0, 1, 2 };
        int r7 = search(t7, 5);
        System.out.println("Test 7:    " + r7 + (r7 == 1 ? " (Correct)" : " (Wrong)")); // Expected: 1

        // Test 8: Target at the very end of the array
        int[] t8 = { 4, 5, 6, 7, 0, 1, 2 };
        int r8 = search(t8, 2);
        System.out.println("Test 8:    " + r8 + (r8 == 6 ? " (Correct)" : " (Wrong)")); // Expected: 6

        // Test 9: Negative numbers in rotated sorted array
        int[] t9 = { 5, 6, -3, -2, -1, 0, 1 };
        int r9 = search(t9, -2);
        System.out.println("Test 9:    " + r9 + (r9 == 3 ? " (Correct)" : " (Wrong)")); // Expected: 3

        // Test 10: Target missing between boundary values
        int[] t10 = { 5, 1, 3 };
        int r10 = search(t10, 2);
        System.out.println("Test 10:   " + r10 + (r10 == -1 ? " (Correct)" : " (Wrong)")); // Expected: -1
    }
}
