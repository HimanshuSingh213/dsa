// 3637. Trionic Array I

// You are given an integer array nums of length n. An array is defined as trionic
// if there exist indices 0 < p < q < n - 1 such that:
// 1. nums[0...p] is strictly increasing.
// 2. nums[p...q] is strictly decreasing.
// 3. nums[q...n - 1] is strictly increasing.
//
// Return true if nums is trionic, otherwise return false.

// Constraints:
// - 3 <= nums.length <= 100
// - -1000 <= nums[i] <= 1000

public class Trionic_Array_I {

    // My Solution
    static boolean isTrionic(int[] nums) {
        int p = -1, q = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                p = i + 1;
            } else {
                break;
            }
        }

        System.out.println("p - " + p);

        if (p == -1 || p == nums.length - 1) {
            return false;
        } else {
            for (int i = p; i < nums.length - 1; i++) {
                if (nums[i + 1] < nums[i]) {
                    q = i + 1;
                } else {
                    break;
                }
            }
        }

        System.out.println("q - " + q);

        if (q == -1 || p == q || q == nums.length - 1) {
            return false;
        } else {
            for (int i = q; i < nums.length - 1; i++) {
                if (nums[i + 1] <= nums[i]) {
                    return false;
                }
            }

        }

        return true;
    }

    private static String runTest(int[] nums, boolean expected) {
        try {
            boolean res = isTrionic(nums);
            return res + (res == expected ? " (Correct)" : " (Wrong)");
        } catch (Exception e) {
            return e.getClass().getSimpleName() + " (Wrong)";
        }
    }

    public static void main(String[] args) {
        // --- Provided Example Test Cases ---

        // Example 1:
        // Input: nums = [1,3,5,4,2,6]
        // Output: true
        int[] nums1 = { 1, 3, 5, 4, 2, 6 };
        System.out.println("Example 1: " + runTest(nums1, true)); // Expected: true

        // Example 2:
        // Input: nums = [2,1,3]
        // Output: false
        int[] nums2 = { 2, 1, 3 };
        System.out.println("Example 2: " + runTest(nums2, false)); // Expected: false

        // --- Additional Test Cases ---

        // Test 1: Minimal valid trionic array of length 4 (p=1, q=2)
        int[] t1 = { 1, 3, 2, 4 };
        System.out.println("Test 1:    " + runTest(t1, true)); // Expected: true

        // Test 2: Length 4 all strictly increasing (no descent or second ascent)
        int[] t2 = { 1, 2, 3, 4 };
        System.out.println("Test 2:    " + runTest(t2, false)); // Expected: false

        // Test 3: Length 4 all strictly decreasing (no ascent phases)
        int[] t3 = { 4, 3, 2, 1 };
        System.out.println("Test 3:    " + runTest(t3, false)); // Expected: false

        // Test 4: Mountain array (increase then decrease, missing final increase)
        int[] t4 = { 1, 3, 5, 2 };
        System.out.println("Test 4:    " + runTest(t4, false)); // Expected: false

        // Test 5: Valley array (decrease then increase, missing first increase)
        int[] t5 = { 5, 2, 4, 6 };
        System.out.println("Test 5:    " + runTest(t5, false)); // Expected: false

        // Test 6: Equal adjacent elements in first ascent (must be strictly increasing)
        int[] t6 = { 1, 2, 2, 1, 3 };
        System.out.println("Test 6:    " + runTest(t6, false)); // Expected: false

        // Test 7: Equal adjacent elements in descent phase (must be strictly decreasing)
        int[] t7 = { 1, 3, 2, 2, 4 };
        System.out.println("Test 7:    " + runTest(t7, false)); // Expected: false

        // Test 8: Longer valid trionic array (p=3, q=6)
        int[] t8 = { 1, 2, 3, 4, 3, 2, 1, 2, 3, 4 };
        System.out.println("Test 8:    " + runTest(t8, true)); // Expected: true

        // Test 9: Valid trionic array with negative integers
        int[] t9 = { -10, -5, -8, 0 };
        System.out.println("Test 9:    " + runTest(t9, true)); // Expected: true
    }
}
