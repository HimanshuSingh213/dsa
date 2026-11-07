// 3833. Count Dominant Indices

// You are given an integer array nums of length n.
// An element at index i is called dominant if:
// nums[i] > average(nums[i + 1], nums[i + 2], ..., nums[n - 1])
//
// The rightmost element of any array is never dominant because there are no
// elements to its right.
//
// Return the number of dominant indices in nums.

// Constraints:
// - 1 <= nums.length <= 100
// - 1 <= nums[i] <= 100

public class Count_Dominant_Indices {

    // My Solution
    static int dominantIndices(int[] nums) {
        float sum = 0f;
        float prevSum = 0f;
        int domIndexes = 0;
        for(int n: nums){
            sum += n;
        }

        for(int i = 0; i < nums.length - 1; i++){
            prevSum += nums[i];
            float avg = (sum - prevSum)/(nums.length - i - 1);
            if(nums[i] > avg){
                domIndexes++;
            }
            
        }

        return domIndexes;
    }

    public static void main(String[] args) {
        // --- Provided Example Test Cases ---

        // Example 1:
        // Input: nums = [5, 4, 3]
        // Output: 2
        // Explanation:
        // - i = 0: 5 > average(4, 3) = 3.5 (dominant)
        // - i = 1: 4 > average(3) = 3.0 (dominant)
        // - i = 2: rightmost element (not dominant)
        int[] nums1 = { 5, 4, 3 };
        int res1 = dominantIndices(nums1);
        System.out.println("Example 1: " + res1 + (res1 == 2 ? " (Correct)" : " (Wrong)")); // Expected: 2

        // Example 2:
        // Input: nums = [4, 1, 2]
        // Output: 1
        // Explanation:
        // - i = 0: 4 > average(1, 2) = 1.5 (dominant)
        // - i = 1: 1 not > average(2) = 2.0
        // - i = 2: rightmost element
        int[] nums2 = { 4, 1, 2 };
        int res2 = dominantIndices(nums2);
        System.out.println("Example 2: " + res2 + (res2 == 1 ? " (Correct)" : " (Wrong)")); // Expected: 1

        // --- Additional Test Cases ---

        // Test 1: Single element array (no elements to the right)
        int[] t1 = { 1 };
        int r1 = dominantIndices(t1);
        System.out.println("Test 1:    " + r1 + (r1 == 0 ? " (Correct)" : " (Wrong)")); // Expected: 0

        // Test 2: Length 2 array, first element smaller than second
        int[] t2 = { 3, 4 };
        int r2 = dominantIndices(t2);
        System.out.println("Test 2:    " + r2 + (r2 == 0 ? " (Correct)" : " (Wrong)")); // Expected: 0

        // Test 3: Length 2 array, first element strictly greater than second
        int[] t3 = { 4, 3 };
        int r3 = dominantIndices(t3);
        System.out.println("Test 3:    " + r3 + (r3 == 1 ? " (Correct)" : " (Wrong)")); // Expected: 1

        // Test 4: All equal elements (strictly greater required, none dominant)
        int[] t4 = { 2, 2, 2 };
        int r4 = dominantIndices(t4);
        System.out.println("Test 4:    " + r4 + (r4 == 0 ? " (Correct)" : " (Wrong)")); // Expected: 0

        // Test 5: First element dominates, remainder are small identical values
        int[] t5 = { 10, 1, 1, 1 };
        int r5 = dominantIndices(t5);
        System.out.println("Test 5:    " + r5 + (r5 == 1 ? " (Correct)" : " (Wrong)")); // Expected: 1

        // Test 6: Strictly increasing array (no index dominant)
        int[] t6 = { 1, 2, 3, 4, 5 };
        int r6 = dominantIndices(t6);
        System.out.println("Test 6:    " + r6 + (r6 == 0 ? " (Correct)" : " (Wrong)")); // Expected: 0

        // Test 7: Strictly decreasing array (all elements except last are dominant)
        int[] t7 = { 5, 4, 3, 2, 1 };
        int r7 = dominantIndices(t7);
        System.out.println("Test 7:    " + r7 + (r7 == 4 ? " (Correct)" : " (Wrong)")); // Expected: 4

        // Test 8: Multiple dominants with descending gradient
        int[] t8 = { 10, 5, 2, 1 };
        int r8 = dominantIndices(t8);
        System.out.println("Test 8:    " + r8 + (r8 == 3 ? " (Correct)" : " (Wrong)")); // Expected: 3

        // Test 9: Mixed values with multiple dominant indices
        int[] t9 = { 6, 7, 2, 1 };
        int r9 = dominantIndices(t9);
        System.out.println("Test 9:    " + r9 + (r9 == 3 ? " (Correct)" : " (Wrong)")); // Expected: 3
    }
}
