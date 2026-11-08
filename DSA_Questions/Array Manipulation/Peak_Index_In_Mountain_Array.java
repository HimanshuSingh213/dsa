// 852. Peak Index in a Mountain Array

// You are given an integer mountain array arr of length >= 3 where the values will
// increase to a peak element and then decrease.
//
// Return the index of the peak element.
//
// Your task is to solve it in O(log(arr.length)) time complexity.

// Constraints:
// - 3 <= arr.length <= 10^5
// - 0 <= arr[i] <= 10^6
// - arr is guaranteed to be a mountain array.

public class Peak_Index_In_Mountain_Array {

    // My Solution
    static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid + 1] > arr[mid]) {
                start = mid + 1;
            }
            else{
                ans = mid;
                end = mid - 1;
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        // --- Provided Example Test Cases ---

        // Example 1:
        // Input: arr = [0,1,0]
        // Output: 1
        int[] arr1 = { 0, 1, 0 };
        int res1 = peakIndexInMountainArray(arr1);
        System.out.println("Example 1: " + res1 + (res1 == 1 ? " (Correct)" : " (Wrong)")); // Expected: 1

        // Example 2:
        // Input: arr = [0,2,1,0]
        // Output: 1
        int[] arr2 = { 0, 2, 1, 0 };
        int res2 = peakIndexInMountainArray(arr2);
        System.out.println("Example 2: " + res2 + (res2 == 1 ? " (Correct)" : " (Wrong)")); // Expected: 1

        // Example 3:
        // Input: arr = [0,10,5,2]
        // Output: 1
        int[] arr3 = { 0, 10, 5, 2 };
        int res3 = peakIndexInMountainArray(arr3);
        System.out.println("Example 3: " + res3 + (res3 == 1 ? " (Correct)" : " (Wrong)")); // Expected: 1

        // --- Additional Test Cases ---

        // Test 1: Minimal size 3 with peak in middle
        int[] t1 = { 1, 3, 2 };
        int r1 = peakIndexInMountainArray(t1);
        System.out.println("Test 1:    " + r1 + (r1 == 1 ? " (Correct)" : " (Wrong)")); // Expected: 1

        // Test 2: Peak at index 2 in length 4
        int[] t2 = { 0, 1, 2, 0 };
        int r2 = peakIndexInMountainArray(t2);
        System.out.println("Test 2:    " + r2 + (r2 == 2 ? " (Correct)" : " (Wrong)")); // Expected: 2

        // Test 3: Peak near beginning of longer array
        int[] t3 = { 0, 5, 4, 3, 2, 1 };
        int r3 = peakIndexInMountainArray(t3);
        System.out.println("Test 3:    " + r3 + (r3 == 1 ? " (Correct)" : " (Wrong)")); // Expected: 1

        // Test 4: Peak near end of longer array
        int[] t4 = { 1, 2, 3, 4, 5, 0 };
        int r4 = peakIndexInMountainArray(t4);
        System.out.println("Test 4:    " + r4 + (r4 == 4 ? " (Correct)" : " (Wrong)")); // Expected: 4

        // Test 5: Symmetric mountain of odd length
        int[] t5 = { 1, 2, 3, 2, 1 };
        int r5 = peakIndexInMountainArray(t5);
        System.out.println("Test 5:    " + r5 + (r5 == 2 ? " (Correct)" : " (Wrong)")); // Expected: 2

        // Test 6: Steep incline, gentle descent
        int[] t6 = { 0, 100, 99, 98, 97, 96 };
        int r6 = peakIndexInMountainArray(t6);
        System.out.println("Test 6:    " + r6 + (r6 == 1 ? " (Correct)" : " (Wrong)")); // Expected: 1

        // Test 7: Gentle incline, steep descent
        int[] t7 = { 10, 20, 30, 40, 50, 0 };
        int r7 = peakIndexInMountainArray(t7);
        System.out.println("Test 7:    " + r7 + (r7 == 4 ? " (Correct)" : " (Wrong)")); // Expected: 4

        // Test 8: Large number values
        int[] t8 = { 1000, 2000, 3000, 2500, 1500 };
        int r8 = peakIndexInMountainArray(t8);
        System.out.println("Test 8:    " + r8 + (r8 == 2 ? " (Correct)" : " (Wrong)")); // Expected: 2

        // Test 9: Mountain of length 7 with peak at index 3
        int[] t9 = { 2, 4, 6, 8, 5, 3, 1 };
        int r9 = peakIndexInMountainArray(t9);
        System.out.println("Test 9:    " + r9 + (r9 == 3 ? " (Correct)" : " (Wrong)")); // Expected: 3
    }
}
