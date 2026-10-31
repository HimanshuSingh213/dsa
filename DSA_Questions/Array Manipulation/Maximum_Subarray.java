// 53. Maximum Subarray

// Given an integer array nums, find the subarray with the largest sum, and return its sum.

// Constraints:
// - 1 <= nums.length <= 10^5
// - -10^4 <= nums[i] <= 10^4

public class Maximum_Subarray {

    // My Solution
    static int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            maxSum = Math.max(maxSum, sum);

            if (sum < 0) {
                sum = 0;
            }

        }

        return maxSum;
    }

    public static void main(String[] args) {
        // --- Provided Example Test Cases ---

        // Example 1: Mixed positive and negative array
        int[] ex1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int exp1 = 6;
        int res1 = maxSubArray(ex1);
        System.out.println("Example 1: " + res1 + (res1 == exp1 ? " (Correct)" : " (Wrong)")); // Expected: 6

        // Example 2: Single positive element
        int[] ex2 = { 1 };
        int exp2 = 1;
        int res2 = maxSubArray(ex2);
        System.out.println("Example 2: " + res2 + (res2 == exp2 ? " (Correct)" : " (Wrong)")); // Expected: 1

        // Example 3: Multiple positive and negative elements
        int[] ex3 = { 5, 4, -1, 7, 8 };
        int exp3 = 23;
        int res3 = maxSubArray(ex3);
        System.out.println("Example 3: " + res3 + (res3 == exp3 ? " (Correct)" : " (Wrong)")); // Expected: 23

        // --- Additional Test Cases ---

        // Test 1: All negative numbers (largest is -1)
        int[] t1 = { -5, -2, -8, -1, -4 };
        int expT1 = -1;
        int resT1 = maxSubArray(t1);
        System.out.println("Test 1:    " + resT1 + (resT1 == expT1 ? " (Correct)" : " (Wrong)")); // Expected: -1

        // Test 2: Two strictly negative numbers
        int[] t2 = { -2, -1 };
        int expT2 = -1;
        int resT2 = maxSubArray(t2);
        System.out.println("Test 2:    " + resT2 + (resT2 == expT2 ? " (Correct)" : " (Wrong)")); // Expected: -1

        // Test 3: All positive numbers (sum of entire array)
        int[] t3 = { 1, 2, 3, 4 };
        int expT3 = 10;
        int resT3 = maxSubArray(t3);
        System.out.println("Test 3:    " + resT3 + (resT3 == expT3 ? " (Correct)" : " (Wrong)")); // Expected: 10

        // Test 4: Alternating positive and negative with overall positive sum
        int[] t4 = { 2, -1, 2, -1, 2 };
        int expT4 = 4;
        int resT4 = maxSubArray(t4);
        System.out.println("Test 4:    " + resT4 + (resT4 == expT4 ? " (Correct)" : " (Wrong)")); // Expected: 4

        // Test 5: All zeros
        int[] t5 = { 0, 0, 0, 0 };
        int expT5 = 0;
        int resT5 = maxSubArray(t5);
        System.out.println("Test 5:    " + resT5 + (resT5 == expT5 ? " (Correct)" : " (Wrong)")); // Expected: 0

        // Test 6: Negative numbers with a zero
        int[] t6 = { -3, -2, 0, -5 };
        int expT6 = 0;
        int resT6 = maxSubArray(t6);
        System.out.println("Test 6:    " + resT6 + (resT6 == expT6 ? " (Correct)" : " (Wrong)")); // Expected: 0

        // Test 7: Large negative element separating two positive subarrays
        int[] t7 = { 10, 20, -50, 15, 25 };
        int expT7 = 40;
        int resT7 = maxSubArray(t7);
        System.out.println("Test 7:    " + resT7 + (resT7 == expT7 ? " (Correct)" : " (Wrong)")); // Expected: 40

        // Test 8: Max subarray at the beginning of the array
        int[] t8 = { 100, -20, -30, 5 };
        int expT8 = 100;
        int resT8 = maxSubArray(t8);
        System.out.println("Test 8:    " + resT8 + (resT8 == expT8 ? " (Correct)" : " (Wrong)")); // Expected: 100

        // Test 9: Max subarray at the end of the array
        int[] t9 = { -5, -10, 20, 30 };
        int expT9 = 50;
        int resT9 = maxSubArray(t9);
        System.out.println("Test 9:    " + resT9 + (resT9 == expT9 ? " (Correct)" : " (Wrong)")); // Expected: 50

        // Test 10: Extreme boundary values (-10000, 10000)
        int[] t10 = { -10000, 10000, -10000 };
        int expT10 = 10000;
        int resT10 = maxSubArray(t10);
        System.out.println("Test 10:   " + resT10 + (resT10 == expT10 ? " (Correct)" : " (Wrong)")); // Expected: 10000
    }
}
