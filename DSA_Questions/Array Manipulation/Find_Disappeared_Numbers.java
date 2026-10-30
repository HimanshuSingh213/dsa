// 448. Find All Numbers Disappeared in an Array

// Given an array nums of n integers where nums[i] is in the range [1, n], return an array
// of all the integers in the range [1, n] that do not appear in nums.

// Constraints:
// - n == nums.length
// - 1 <= n <= 10^5
// - 1 <= nums[i] <= n

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Find_Disappeared_Numbers {

    // My Solution
    static List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> l = new ArrayList<>();
        Map<Integer, Integer> m = new HashMap<>();

        for (int n : nums) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }

        for(int i = 1; i <= nums.length; i++){
            if(m.getOrDefault(i, -1) == -1){
                l.add(i);
            }
        }

        return l;
    }

    // My Solution 2 Slower one
    static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> l = new ArrayList<>(nums.length);

        for (int n : nums) {
            l.add(n);
        }

        Collections.sort(l);

        for(int i = 0; i < nums.length; i++){
            int actualPosition = Math.abs(l.get(i)) - 1;
            int currentElement = Math.abs(l.get(actualPosition));
            l.set(actualPosition, currentElement*(-1));
        }

        System.out.println(l);
        for (int i = 0; i < nums.length; i++) {
            if(l.get(i) > 0){
                l.addLast(i+1);
            }
        }

        l.subList(0, nums.length).clear();

        return l;
    }

    // My Solution 3 -- FASTEST
    static List<Integer> findDisappearedNumbers3(int[] nums) {
        List<Integer> l = new ArrayList<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            int position = Math.abs(nums[i]) - 1;

            if(nums[position] > 0){
                nums[position] *= -1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0){
                l.add(i+1);
            }
        }

        return l;
    }

    static List<Integer> findDisappearedNumbers(int[] nums) {
        return findDisappearedNumbers3(nums);
    }


    public static void main(String[] args) {
        // --- Provided Example Test Cases ---

        // Example 1:
        // Input: nums = [4,3,2,7,8,2,3,1]
        // Output: [5,6]
        int[] nums1 = { 4, 3, 2, 7, 8, 2, 3, 1 };
        List<Integer> exp1 = Arrays.asList(5, 6);
        List<Integer> res1 = findDisappearedNumbers(nums1);
        System.out.println("Example 1: " + res1 + (res1.equals(exp1) ? " (Correct)" : " (Wrong)")); // Expected: [5, 6]

        // Example 2:
        // Input: nums = [1,1]
        // Output: [2]
        int[] nums2 = { 1, 1 };
        List<Integer> exp2 = Arrays.asList(2);
        List<Integer> res2 = findDisappearedNumbers(nums2);
        System.out.println("Example 2: " + res2 + (res2.equals(exp2) ? " (Correct)" : " (Wrong)")); // Expected: [2]

        // --- Additional Test Cases ---

        // Test 1: Single element matching range [1] -> none missing
        int[] t1 = { 1 };
        List<Integer> expT1 = Arrays.asList();
        List<Integer> resT1 = findDisappearedNumbers(t1);
        System.out.println("Test 1:    " + resT1 + (resT1.equals(expT1) ? " (Correct)" : " (Wrong)")); // Expected: []

        // Test 2: Two identical elements out of range 1 -> missing 1
        int[] t2 = { 2, 2 };
        List<Integer> expT2 = Arrays.asList(1);
        List<Integer> resT2 = findDisappearedNumbers(t2);
        System.out.println("Test 2:    " + resT2 + (resT2.equals(expT2) ? " (Correct)" : " (Wrong)")); // Expected: [1]

        // Test 3: All elements identical to 1 -> missing [2, 3, 4]
        int[] t3 = { 1, 1, 1, 1 };
        List<Integer> expT3 = Arrays.asList(2, 3, 4);
        List<Integer> resT3 = findDisappearedNumbers(t3);
        System.out.println("Test 3:    " + resT3 + (resT3.equals(expT3) ? " (Correct)" : " (Wrong)")); // Expected: [2, 3, 4]

        // Test 4: Already complete sorted permutation [1, 2, 3, 4] -> none missing
        int[] t4 = { 1, 2, 3, 4 };
        List<Integer> expT4 = Arrays.asList();
        List<Integer> resT4 = findDisappearedNumbers(t4);
        System.out.println("Test 4:    " + resT4 + (resT4.equals(expT4) ? " (Correct)" : " (Wrong)")); // Expected: []

        // Test 5: Reverse sorted permutation [3, 2, 1] -> none missing
        int[] t5 = { 3, 2, 1 };
        List<Integer> expT5 = Arrays.asList();
        List<Integer> resT5 = findDisappearedNumbers(t5);
        System.out.println("Test 5:    " + resT5 + (resT5.equals(expT5) ? " (Correct)" : " (Wrong)")); // Expected: []

        // Test 6: Missing the first number (1)
        int[] t6 = { 2, 3, 2 };
        List<Integer> expT6 = Arrays.asList(1);
        List<Integer> resT6 = findDisappearedNumbers(t6);
        System.out.println("Test 6:    " + resT6 + (resT6.equals(expT6) ? " (Correct)" : " (Wrong)")); // Expected: [1]

        // Test 7: Missing the last number (n)
        int[] t7 = { 1, 2, 2 };
        List<Integer> expT7 = Arrays.asList(3);
        List<Integer> resT7 = findDisappearedNumbers(t7);
        System.out.println("Test 7:    " + resT7 + (resT7.equals(expT7) ? " (Correct)" : " (Wrong)")); // Expected: [3]

        // Test 8: Multiple duplicates and missing numbers
        int[] t8 = { 1, 1, 2, 2 };
        List<Integer> expT8 = Arrays.asList(3, 4);
        List<Integer> resT8 = findDisappearedNumbers(t8);
        System.out.println("Test 8:    " + resT8 + (resT8.equals(expT8) ? " (Correct)" : " (Wrong)")); // Expected: [3, 4]

        // Test 9: One duplicate at the end, missing n
        int[] t9 = { 1, 2, 3, 4, 4 };
        List<Integer> expT9 = Arrays.asList(5);
        List<Integer> resT9 = findDisappearedNumbers(t9);
        System.out.println("Test 9:    " + resT9 + (resT9.equals(expT9) ? " (Correct)" : " (Wrong)")); // Expected: [5]
    }
}
