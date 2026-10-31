// 54. Spiral Matrix

// Given an m x n matrix, return all elements of the matrix in spiral order.

// Constraints:
// - m == matrix.length
// - n == matrix[i].length
// - 1 <= m, n <= 10
// - -100 <= matrix[i][j] <= 100

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Spiral_Matrix {

    static void display(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            System.out.println("[]");
            return;
        }
        int maxLen = 0;
        for (int[] row : matrix) {
            for (int val : row) {
                maxLen = Math.max(maxLen, String.valueOf(val).length());
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%" + maxLen + "d", matrix[i][j]);
                if (j < matrix[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(" ]");
        }
    }

    // My Solution
    static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return ans;
        }

        int startingRow = 0, startingCol = 0, endingRow = matrix.length - 1, endingCol = matrix[0].length - 1;

        while (startingRow <= endingRow && startingCol <= endingCol) {

            // i is same , j is increasing
            // Right -> Left
            for (int j = startingCol; j <= endingCol; j++) {
                ans.add(matrix[startingRow][j]);
            }
            startingRow++;

            // i is increasing, j is same
            // Top -> Bottom
            for (int i = startingRow; i <= endingRow; i++) {
                ans.add(matrix[i][endingCol]);
            }
            endingCol--;

            // i is same , j is decreasing
            // Right -> Left
            if (startingRow <= endingRow) {
                for (int j = endingCol; j >= startingCol; j--) {
                    ans.add(matrix[endingRow][j]);
                }
                endingRow--;
            }

            // i is decreasing, j is same
            // Bottom -> Top
            if (startingCol <= endingCol) {
                for (int i = endingRow; i >= startingRow; i--) {
                    ans.add(matrix[i][startingCol]);
                }
                startingCol++;
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        // --- Provided Example Test Cases ---

        // Example 1: 3x3 square matrix
        int[][] ex1 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        List<Integer> exp1 = Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5);
        List<Integer> res1 = spiralOrder(ex1);
        System.out.println("Example 1: " + res1
                + (res1.equals(exp1) ? " (Correct)" : " (Wrong)")); // Expected: [1, 2, 3, 6, 9, 8, 7, 4, 5]

        // Example 2: 3x4 rectangular matrix
        int[][] ex2 = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };
        List<Integer> exp2 = Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7);
        List<Integer> res2 = spiralOrder(ex2);
        System.out.println("Example 2: " + res2
                + (res2.equals(exp2) ? " (Correct)" : " (Wrong)")); // Expected: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]

        // --- Additional Test Cases ---

        // Test 1: Single element 1x1 matrix
        int[][] t1 = { { 1 } };
        List<Integer> expT1 = Arrays.asList(1);
        List<Integer> resT1 = spiralOrder(t1);
        System.out.println("Test 1:    " + resT1
                + (resT1.equals(expT1) ? " (Correct)" : " (Wrong)")); // Expected: [1]

        // Test 2: Single row matrix (1x4)
        int[][] t2 = { { 1, 2, 3, 4 } };
        List<Integer> expT2 = Arrays.asList(1, 2, 3, 4);
        List<Integer> resT2 = spiralOrder(t2);
        System.out.println("Test 2:    " + resT2
                + (resT2.equals(expT2) ? " (Correct)" : " (Wrong)")); // Expected: [1, 2, 3, 4]

        // Test 3: Single column matrix (4x1)
        int[][] t3 = {
                { 1 },
                { 2 },
                { 3 },
                { 4 }
        };
        List<Integer> expT3 = Arrays.asList(1, 2, 3, 4);
        List<Integer> resT3 = spiralOrder(t3);
        System.out.println("Test 3:    " + resT3
                + (resT3.equals(expT3) ? " (Correct)" : " (Wrong)")); // Expected: [1, 2, 3, 4]

        // Test 4: 2x2 square matrix
        int[][] t4 = {
                { 1, 2 },
                { 3, 4 }
        };
        List<Integer> expT4 = Arrays.asList(1, 2, 4, 3);
        List<Integer> resT4 = spiralOrder(t4);
        System.out.println("Test 4:    " + resT4
                + (resT4.equals(expT4) ? " (Correct)" : " (Wrong)")); // Expected: [1, 2, 4, 3]

        // Test 5: 2x3 wide matrix
        int[][] t5 = {
                { 1, 2, 3 },
                { 4, 5, 6 }
        };
        List<Integer> expT5 = Arrays.asList(1, 2, 3, 6, 5, 4);
        List<Integer> resT5 = spiralOrder(t5);
        System.out.println("Test 5:    " + resT5
                + (resT5.equals(expT5) ? " (Correct)" : " (Wrong)")); // Expected: [1, 2, 3, 6, 5, 4]

        // Test 6: 3x2 tall matrix
        int[][] t6 = {
                { 1, 2 },
                { 3, 4 },
                { 5, 6 }
        };
        List<Integer> expT6 = Arrays.asList(1, 2, 4, 6, 5, 3);
        List<Integer> resT6 = spiralOrder(t6);
        System.out.println("Test 6:    " + resT6
                + (resT6.equals(expT6) ? " (Correct)" : " (Wrong)")); // Expected: [1, 2, 4, 6, 5, 3]

        // Test 7: 3x3 matrix with negative numbers and zeros
        int[][] t7 = {
                { -1, 0, 1 },
                { 2, -2, 3 },
                { 4, 5, -3 }
        };
        List<Integer> expT7 = Arrays.asList(-1, 0, 1, 3, -3, 5, 4, 2, -2);
        List<Integer> resT7 = spiralOrder(t7);
        System.out.println("Test 7:    " + resT7
                + (resT7.equals(expT7) ? " (Correct)" : " (Wrong)")); // Expected: [-1, 0, 1, 3, -3, 5, 4, 2, -2]

        // Test 8: 4x4 matrix
        int[][] t8 = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        List<Integer> expT8 = Arrays.asList(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10);
        List<Integer> resT8 = spiralOrder(t8);
        System.out.println("Test 8:    " + resT8
                + (resT8.equals(expT8) ? " (Correct)" : " (Wrong)")); // Expected: [1, 2, 3, 4, 8, 12, 16, 15, 14, 13,
                                                                      // 9, 5, 6, 7, 11, 10]

        // Test 9: 2x4 matrix with identical elements
        int[][] t9 = {
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 }
        };
        List<Integer> expT9 = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0);
        List<Integer> resT9 = spiralOrder(t9);
        System.out.println("Test 9:    " + resT9
                + (resT9.equals(expT9) ? " (Correct)" : " (Wrong)")); // Expected: [0, 0, 0, 0, 0, 0, 0, 0]
    }
}
