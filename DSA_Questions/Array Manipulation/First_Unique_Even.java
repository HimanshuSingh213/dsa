// 3866. First Unique Even Element

// You are given an integer array nums.
// Return an integer denoting the first even integer (earliest by array index)
// that appears exactly once in nums. If no such integer exists, return -1.
//
// An integer x is considered even if it is divisible by 2.

// Constraints:
// - 1 <= nums.length <= 100
// - 1 <= nums[i] <= 100

import java.util.HashMap;
import java.util.Map;

public class First_Unique_Even {

    // My Solution
    static int firstUniqueEven1(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 0) {

                // 1 -> if same int was there
                // 0 -> if no same int was there
                int check = 0;
                // System.out.println("even num: " + nums[i]);

                for (int j = 0; j < nums.length; j++) {
                    if (j == i)
                        continue;
                    if (nums[j] == nums[i]) {
                        check = 1;
                        break;
                    }
                }
                // System.out.println("check -> " + check + " for " + nums[i]);

                if (check != 1 && i != -1)
                    return nums[i];
            }
        }

        return -1;
    }

    // My Solution 2
    static int firstUniqueEven(int[] nums) {

        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 0) {
                m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);

            }
        }


        for(int i = 0; i < nums.length; i++){
            if((nums[i] & 1) == 0){
                if(m.get(nums[i]) == 1){
                    return nums[i];
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // --- Provided Example Test Cases ---

        // Example 1:
        // Input: nums = [3, 4, 2, 5, 4, 6]
        // Output: 2
        int[] nums1 = { 3, 4, 2, 5, 4, 6 };
        System.out.println("Example 1: " + firstUniqueEven(nums1)); // Expected: 2

        // Example 2:
        // Input: nums = [4, 4]
        // Output: -1
        int[] nums2 = { 4, 4 };
        System.out.println("Example 2: " + firstUniqueEven(nums2)); // Expected: -1

        // --- Additional Test Cases ---

        // Test 1: Single even number
        int[] t1 = { 2 };
        System.out.println("Test 1:    " + firstUniqueEven(t1)); // Expected: 2

        // Test 2: Single odd number
        int[] t2 = { 5 };
        System.out.println("Test 2:    " + firstUniqueEven(t2)); // Expected: -1

        // Test 3: Only odd numbers
        int[] t3 = { 1, 3, 5, 7 };
        System.out.println("Test 3:    " + firstUniqueEven(t3)); // Expected: -1

        // Test 4: Multiple unique evens (should return first by index)
        int[] t4 = { 8, 6, 4 };
        System.out.println("Test 4:    " + firstUniqueEven(t4)); // Expected: 8

        // Test 5: First even duplicated, second even unique
        int[] t5 = { 2, 2, 6 };
        System.out.println("Test 5:    " + firstUniqueEven(t5)); // Expected: 6

        // Test 6: Unique even at the very end
        int[] t6 = { 4, 4, 8, 8, 10 };
        System.out.println("Test 6:    " + firstUniqueEven(t6)); // Expected: 10

        // Test 7: Mixed with odds in between duplicates
        int[] t7 = { 1, 2, 3, 2, 5, 6, 7 };
        System.out.println("Test 7:    " + firstUniqueEven(t7)); // Expected: 6

        // Test 8: All elements same even number
        int[] t8 = { 6, 6, 6, 6 };
        System.out.println("Test 8:    " + firstUniqueEven(t8)); // Expected: -1
    }
}
