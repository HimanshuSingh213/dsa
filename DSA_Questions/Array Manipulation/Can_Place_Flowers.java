// 605. Can Place Flowers

// You have a long flowerbed in which some of the plots are planted, and some are not.
// However, flowers cannot be planted in adjacent plots.
//
// Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means
// not empty, and an integer n, return true if n new flowers can be planted in the
// flowerbed without violating the no-adjacent-flowers rule and false otherwise.

// Constraints:
// - 1 <= flowerbed.length <= 2 * 10^4
// - flowerbed[i] is 0 or 1.
// - There are no two adjacent flowers in flowerbed.
// - 0 <= n <= flowerbed.length

public class Can_Place_Flowers {

    // My Solution
    static boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0)
                    && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                n--;
                flowerbed[i] = 1;
            }

            if (n <= 0)
                break;
        }

        if (n <= 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        // --- Provided Example Test Cases ---

        // Example 1:
        // Input: flowerbed = [1,0,0,0,1], n = 1
        // Output: true
        int[] fb1 = { 1, 0, 0, 0, 1 };
        int n1 = 1;
        boolean res1 = canPlaceFlowers(fb1, n1);
        System.out.println("Example 1: " + res1 + (res1 == true ? " (Correct)" : " (Wrong)")); // Expected: true

        // Example 2:
        // Input: flowerbed = [1,0,0,0,1], n = 2
        // Output: false
        int[] fb2 = { 1, 0, 0, 0, 1 };
        int n2 = 2;
        boolean res2 = canPlaceFlowers(fb2, n2);
        System.out.println("Example 2: " + res2 + (res2 == false ? " (Correct)" : " (Wrong)")); // Expected: false

        // --- Additional Test Cases ---

        // Test 1: Single plot empty, n = 1
        int[] t1 = { 0 };
        boolean r1 = canPlaceFlowers(t1, 1);
        System.out.println("Test 1:    " + r1 + (r1 == true ? " (Correct)" : " (Wrong)")); // Expected: true

        // Test 2: Single plot empty, n = 0
        int[] t2 = { 0 };
        boolean r2 = canPlaceFlowers(t2, 0);
        System.out.println("Test 2:    " + r2 + (r2 == true ? " (Correct)" : " (Wrong)")); // Expected: true

        // Test 3: Single plot already planted, n = 0
        int[] t3 = { 1 };
        boolean r3 = canPlaceFlowers(t3, 0);
        System.out.println("Test 3:    " + r3 + (r3 == true ? " (Correct)" : " (Wrong)")); // Expected: true

        // Test 4: Single plot already planted, n = 1
        int[] t4 = { 1 };
        boolean r4 = canPlaceFlowers(t4, 1);
        System.out.println("Test 4:    " + r4 + (r4 == false ? " (Correct)" : " (Wrong)")); // Expected: false

        // Test 5: Can place at the beginning
        int[] t5 = { 0, 0, 1 };
        boolean r5 = canPlaceFlowers(t5, 1);
        System.out.println("Test 5:    " + r5 + (r5 == true ? " (Correct)" : " (Wrong)")); // Expected: true

        // Test 6: Can place at the end
        int[] t6 = { 1, 0, 0 };
        boolean r6 = canPlaceFlowers(t6, 1);
        System.out.println("Test 6:    " + r6 + (r6 == true ? " (Correct)" : " (Wrong)")); // Expected: true

        // Test 7: All empty plots (size 5, can place up to 3)
        int[] t7 = { 0, 0, 0, 0, 0 };
        boolean r7 = canPlaceFlowers(t7, 3);
        System.out.println("Test 7:    " + r7 + (r7 == true ? " (Correct)" : " (Wrong)")); // Expected: true

        // Test 8: All empty plots demanding more than capacity
        int[] t8 = { 0, 0, 0, 0, 0 };
        boolean r8 = canPlaceFlowers(t8, 4);
        System.out.println("Test 8:    " + r8 + (r8 == false ? " (Correct)" : " (Wrong)")); // Expected: false

        // Test 9: Even length alternating zeros in middle
        int[] t9 = { 1, 0, 0, 0, 0, 1 };
        boolean r9 = canPlaceFlowers(t9, 1);
        System.out.println("Test 9:    " + r9 + (r9 == true ? " (Correct)" : " (Wrong)")); // Expected: true
    }
}
