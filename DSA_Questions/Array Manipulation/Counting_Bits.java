// 338. Counting Bits

// Given an integer n, return an array ans of length n + 1 such that for each i
// (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

// Constraints:
// - 0 <= n <= 10^5

import java.util.Arrays;

public class Counting_Bits {

    // My Solution
    static int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            // the recurrence relation (using old values)
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        // --- Provided Example Test Cases ---

        // Example 1:
        // Input: n = 2
        // Output: [0,1,1]
        int[] exp1 = { 0, 1, 1 };
        int[] res1 = countBits(2);
        System.out.println("Example 1: " + Arrays.toString(res1)
                + (Arrays.equals(res1, exp1) ? " (Correct)" : " (Wrong)")); // Expected: [0, 1, 1]

        // Example 2:
        // Input: n = 5
        // Output: [0,1,1,2,1,2]
        int[] exp2 = { 0, 1, 1, 2, 1, 2 };
        int[] res2 = countBits(5);
        System.out.println("Example 2: " + Arrays.toString(res2)
                + (Arrays.equals(res2, exp2) ? " (Correct)" : " (Wrong)")); // Expected: [0, 1, 1, 2, 1, 2]

        // --- Additional Test Cases ---

        // Test 1: Minimum boundary n = 0
        int[] expT1 = { 0 };
        int[] resT1 = countBits(0);
        System.out.println("Test 1:    " + Arrays.toString(resT1)
                + (Arrays.equals(resT1, expT1) ? " (Correct)" : " (Wrong)")); // Expected: [0]

        // Test 2: Single bit n = 1
        int[] expT2 = { 0, 1 };
        int[] resT2 = countBits(1);
        System.out.println("Test 2:    " + Arrays.toString(resT2)
                + (Arrays.equals(resT2, expT2) ? " (Correct)" : " (Wrong)")); // Expected: [0, 1]

        // Test 3: Odd number n = 3
        int[] expT3 = { 0, 1, 1, 2 };
        int[] resT3 = countBits(3);
        System.out.println("Test 3:    " + Arrays.toString(resT3)
                + (Arrays.equals(resT3, expT3) ? " (Correct)" : " (Wrong)")); // Expected: [0, 1, 1, 2]

        // Test 4: Power of 2 n = 4
        int[] expT4 = { 0, 1, 1, 2, 1 };
        int[] resT4 = countBits(4);
        System.out.println("Test 4:    " + Arrays.toString(resT4)
                + (Arrays.equals(resT4, expT4) ? " (Correct)" : " (Wrong)")); // Expected: [0, 1, 1, 2, 1]

        // Test 5: All 1s in 3-bit representation n = 7
        int[] expT5 = { 0, 1, 1, 2, 1, 2, 2, 3 };
        int[] resT5 = countBits(7);
        System.out.println("Test 5:    " + Arrays.toString(resT5)
                + (Arrays.equals(resT5, expT5) ? " (Correct)" : " (Wrong)")); // Expected: [0, 1, 1, 2, 1, 2, 2, 3]

        // Test 6: Next power of 2 n = 8
        int[] expT6 = { 0, 1, 1, 2, 1, 2, 2, 3, 1 };
        int[] resT6 = countBits(8);
        System.out.println("Test 6:    " + Arrays.toString(resT6)
                + (Arrays.equals(resT6, expT6) ? " (Correct)" : " (Wrong)")); // Expected: [0, 1, 1, 2, 1, 2, 2, 3, 1]

        // Test 7: Arbitrary even number n = 10
        int[] expT7 = { 0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2 };
        int[] resT7 = countBits(10);
        System.out.println("Test 7:    " + Arrays.toString(resT7)
                + (Arrays.equals(resT7, expT7) ? " (Correct)" : " (Wrong)")); // Expected: [0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2]

        // Test 8: All 1s in 4-bit representation n = 15
        int[] expT8 = { 0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4 };
        int[] resT8 = countBits(15);
        System.out.println("Test 8:    " + Arrays.toString(resT8)
                + (Arrays.equals(resT8, expT8) ? " (Correct)" : " (Wrong)")); // Expected: [0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4]
    }
}
