// 1640. Check Array Formation Through Concatenation

// You are given an array of distinct integers arr and an array of integer arrays pieces,
// where the integers in pieces are distinct. Your goal is to form arr by concatenating
// the arrays in pieces in any order. However, you are not allowed to reorder the integers
// in each array pieces[i].
//
// Return true if it is possible to form the array arr from pieces. Otherwise, return false.

// Constraints:
// - 1 <= pieces.length <= arr.length <= 100
// - sum(pieces[i].length) == arr.length
// - 1 <= pieces[i].length <= arr.length
// - 1 <= arr[i], pieces[i][j] <= 100
// - The integers in arr are distinct.
// - The integers in pieces are distinct (i.e., if we flatten pieces in a 1D array, all
//   integers in this array are distinct).

import java.util.HashMap;
import java.util.Map;

public class Check_Array_Formation_Through_Concatenation {

    static void display(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    // My Solution
    static boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> map = new HashMap<>();

        for(int i = 0; i < pieces.length; i++){
            map.put(pieces[i][0], pieces[i]);
        }

        int i = 0;
        while (i < arr.length) {
            if(map.getOrDefault(arr[i], null) != null){
                int[] val = map.get(arr[i]);
                for (int j = 0; j < val.length; j++) {
                    if(arr[i + j] != val[j]){
                        return false;
                    }
                }

                i += val.length;
            }
            else{
                i++;
                return false;
            }


        }

        return true;
    }

    public static void main(String[] args) {
        // --- Provided Example Test Cases ---

        // Example 1:
        // Input: arr = [15,88], pieces = [[88],[15]]
        // Output: true
        int[] arr1 = { 15, 88 };
        int[][] pieces1 = { { 88 }, { 15 } };
        boolean res1 = canFormArray(arr1, pieces1);
        System.out.println("Example 1: " + res1 + (res1 == true ? " (Correct)" : " (Wrong)")); // Expected: true

        // Example 2:
        // Input: arr = [49,18,16], pieces = [[16,18,49]]
        // Output: false
        int[] arr2 = { 49, 18, 16 };
        int[][] pieces2 = { { 16, 18, 49 } };
        boolean res2 = canFormArray(arr2, pieces2);
        System.out.println("Example 2: " + res2 + (res2 == false ? " (Correct)" : " (Wrong)")); // Expected: false

        // Example 3:
        // Input: arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
        // Output: true
        int[] arr3 = { 91, 4, 64, 78 };
        int[][] pieces3 = { { 78 }, { 4, 64 }, { 91 } };
        boolean res3 = canFormArray(arr3, pieces3);
        System.out.println("Example 3: " + res3 + (res3 == true ? " (Correct)" : " (Wrong)")); // Expected: true

        // --- Additional Test Cases ---

        // Test 1: Single element piece matching
        int[] t1 = { 1 };
        int[][] p1 = { { 1 } };
        boolean r1 = canFormArray(t1, p1);
        System.out.println("Test 1:    " + r1 + (r1 == true ? " (Correct)" : " (Wrong)")); // Expected: true

        // Test 2: Single element piece not matching
        int[] t2 = { 1 };
        int[][] p2 = { { 2 } };
        boolean r2 = canFormArray(t2, p2);
        System.out.println("Test 2:    " + r2 + (r2 == false ? " (Correct)" : " (Wrong)")); // Expected: false

        // Test 3: Multiple 1-element pieces in identical order
        int[] t3 = { 1, 2, 3 };
        int[][] p3 = { { 1 }, { 2 }, { 3 } };
        boolean r3 = canFormArray(t3, p3);
        System.out.println("Test 3:    " + r3 + (r3 == true ? " (Correct)" : " (Wrong)")); // Expected: true

        // Test 4: Multiple 1-element pieces in reversed order
        int[] t4 = { 1, 2, 3 };
        int[][] p4 = { { 3 }, { 2 }, { 1 } };
        boolean r4 = canFormArray(t4, p4);
        System.out.println("Test 4:    " + r4 + (r4 == true ? " (Correct)" : " (Wrong)")); // Expected: true

        // Test 5: Pieces with multiple elements in correct contiguous order
        int[] t5 = { 1, 2, 3, 4 };
        int[][] p5 = { { 1, 2 }, { 3, 4 } };
        boolean r5 = canFormArray(t5, p5);
        System.out.println("Test 5:    " + r5 + (r5 == true ? " (Correct)" : " (Wrong)")); // Expected: true

        // Test 6: Piece with elements inverted internally (cannot reorder inside piece)
        int[] t6 = { 1, 2, 3, 4 };
        int[][] p6 = { { 2, 1 }, { 3, 4 } };
        boolean r6 = canFormArray(t6, p6);
        System.out.println("Test 6:    " + r6 + (r6 == false ? " (Correct)" : " (Wrong)")); // Expected: false

        // Test 7: Interleaved piece skipping elements in arr
        int[] t7 = { 1, 2, 3 };
        int[][] p7 = { { 1, 3 }, { 2 } };
        boolean r7 = canFormArray(t7, p7);
        System.out.println("Test 7:    " + r7 + (r7 == false ? " (Correct)" : " (Wrong)")); // Expected: false

        // Test 8: Single piece covering the whole array correctly
        int[] t8 = { 10, 20, 30 };
        int[][] p8 = { { 10, 20, 30 } };
        boolean r8 = canFormArray(t8, p8);
        System.out.println("Test 8:    " + r8 + (r8 == true ? " (Correct)" : " (Wrong)")); // Expected: true

        // Test 9: Complete mismatch of values
        int[] t9 = { 1, 2 };
        int[][] p9 = { { 3 }, { 4 } };
        boolean r9 = canFormArray(t9, p9);
        System.out.println("Test 9:    " + r9 + (r9 == false ? " (Correct)" : " (Wrong)")); // Expected: false
    }
}
