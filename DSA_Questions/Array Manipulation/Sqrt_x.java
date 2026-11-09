// 69. Sqrt(x)

// Given a non-negative integer x, return the square root of x rounded down to the
// nearest integer. The returned integer should be non-negative as well.
//
// You must not use any built-in exponent function or operator, such as pow(x, 0.5)
// or x ** 0.5.

// Constraints:
// - 0 <= x <= 2^31 - 1

public class Sqrt_x {

    // My Solution
    static int mySqrt(int x) {
        int s = 1;
        int e = x;
        int ans = 0;

        if( x == 0)
            return x;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (mid == x / mid)
                return mid;
            else if (mid > x / mid) {
                e = mid - 1;
            } else {
                ans = mid;
                s = mid + 1;
            }
        }

        return ans;
    }

    private static String runTest(int x, int expected) {
        try {
            int res = mySqrt(x);
            return res + (res == expected ? " (Correct)" : " (Wrong)");
        } catch (Exception e) {
            return e.getClass().getSimpleName() + " (Wrong)";
        }
    }

    public static void main(String[] args) {
        // --- Provided Example Test Cases ---

        // Example 1:
        // Input: x = 4
        // Output: 2
        // Explanation: The square root of 4 is 2, so we return 2.
        System.out.println("Example 1: " + runTest(4, 2)); // Expected: 2

        // Example 2:
        // Input: x = 8
        // Output: 2
        // Explanation: The square root of 8 is 2.82842..., and since we round it down
        // to the nearest integer, 2 is returned.
        System.out.println("Example 2: " + runTest(8, 2)); // Expected: 2

        // --- Additional Test Cases ---

        // Test 1: Minimum boundary x = 0
        System.out.println("Test 1:    " + runTest(0, 0)); // Expected: 0

        // Test 2: Boundary x = 1
        System.out.println("Test 2:    " + runTest(1, 1)); // Expected: 1

        // Test 3: Smallest non-square x = 2
        System.out.println("Test 3:    " + runTest(2, 1)); // Expected: 1

        // Test 4: Prime non-square x = 3
        System.out.println("Test 4:    " + runTest(3, 1)); // Expected: 1

        // Test 5: Perfect square x = 9
        System.out.println("Test 5:    " + runTest(9, 3)); // Expected: 3

        // Test 6: Non-square right after perfect square x = 10
        System.out.println("Test 6:    " + runTest(10, 3)); // Expected: 3

        // Test 7: Perfect square x = 25
        System.out.println("Test 7:    " + runTest(25, 5)); // Expected: 5

        // Test 8: Non-square x = 26
        System.out.println("Test 8:    " + runTest(26, 5)); // Expected: 5

        // Test 9: Large number near maximum sqrt (46339^2)
        System.out.println("Test 9:    " + runTest(2147395599, 46339)); // Expected: 46339

        // Test 10: Maximum possible input Integer.MAX_VALUE (2147483647)
        System.out.println("Test 10:   " + runTest(2147483647, 46340)); // Expected: 46340
    }
}
