// 867. Transpose Matrix

// Given a 2D integer array matrix, return the transpose of matrix.
//
// The transpose of a matrix is the matrix flipped over its main diagonal,
// switching the matrix's row and column indices.

// Constraints:
// - m == matrix.length
// - n == matrix[i].length
// - 1 <= m, n <= 1000
// - 1 <= m * n <= 10^5
// - -10^9 <= matrix[i][j] <= 10^9

import java.util.Arrays;

public class Transpose_Matrix {

    // My Solution
    static int[][] transpose(int[][] matrix) {

        if (matrix == null || matrix.length == 0) {
            return new int[0][0];
        }

        int[][] T = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                T[j][i] = matrix[i][j];
            }
        }
        return T;
    }

    public static void main(String[] args) {
        // --- Provided Example Test Cases ---

        // Example 1: 3x3 square matrix
        int[][] ex1 = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };
        int[][] exp1 = {
            { 1, 4, 7 },
            { 2, 5, 8 },
            { 3, 6, 9 }
        };
        int[][] res1 = transpose(ex1);
        System.out.println("Example 1: " + Arrays.deepToString(res1)
                + (Arrays.deepEquals(res1, exp1) ? " (Correct)" : " (Wrong)")); // Expected: [[1, 4, 7], [2, 5, 8], [3, 6, 9]]

        // Example 2: 2x3 rectangular matrix
        int[][] ex2 = {
            { 1, 2, 3 },
            { 4, 5, 6 }
        };
        int[][] exp2 = {
            { 1, 4 },
            { 2, 5 },
            { 3, 6 }
        };
        int[][] res2 = transpose(ex2);
        System.out.println("Example 2: " + Arrays.deepToString(res2)
                + (Arrays.deepEquals(res2, exp2) ? " (Correct)" : " (Wrong)")); // Expected: [[1, 4], [2, 5], [3, 6]]

        // --- Additional Test Cases ---

        // Test 1: Single element 1x1 matrix
        int[][] t1 = { { 5 } };
        int[][] expT1 = { { 5 } };
        int[][] resT1 = transpose(t1);
        System.out.println("Test 1:    " + Arrays.deepToString(resT1)
                + (Arrays.deepEquals(resT1, expT1) ? " (Correct)" : " (Wrong)")); // Expected: [[5]]

        // Test 2: Single row matrix (1x3) -> becomes column matrix (3x1)
        int[][] t2 = { { 1, 2, 3 } };
        int[][] expT2 = { { 1 }, { 2 }, { 3 } };
        int[][] resT2 = transpose(t2);
        System.out.println("Test 2:    " + Arrays.deepToString(resT2)
                + (Arrays.deepEquals(resT2, expT2) ? " (Correct)" : " (Wrong)")); // Expected: [[1], [2], [3]]

        // Test 3: Single column matrix (3x1) -> becomes row matrix (1x3)
        int[][] t3 = { { 1 }, { 2 }, { 3 } };
        int[][] expT3 = { { 1, 2, 3 } };
        int[][] resT3 = transpose(t3);
        System.out.println("Test 3:    " + Arrays.deepToString(resT3)
                + (Arrays.deepEquals(resT3, expT3) ? " (Correct)" : " (Wrong)")); // Expected: [[1, 2, 3]]

        // Test 4: 2x2 matrix with negative numbers
        int[][] t4 = {
            { -1, -2 },
            { -3, -4 }
        };
        int[][] expT4 = {
            { -1, -3 },
            { -2, -4 }
        };
        int[][] resT4 = transpose(t4);
        System.out.println("Test 4:    " + Arrays.deepToString(resT4)
                + (Arrays.deepEquals(resT4, expT4) ? " (Correct)" : " (Wrong)")); // Expected: [[-1, -3], [-2, -4]]

        // Test 5: Symmetric 3x3 matrix (transpose equals original)
        int[][] t5 = {
            { 1, 2, 3 },
            { 2, 4, 5 },
            { 3, 5, 6 }
        };
        int[][] expT5 = {
            { 1, 2, 3 },
            { 2, 4, 5 },
            { 3, 5, 6 }
        };
        int[][] resT5 = transpose(t5);
        System.out.println("Test 5:    " + Arrays.deepToString(resT5)
                + (Arrays.deepEquals(resT5, expT5) ? " (Correct)" : " (Wrong)")); // Expected: [[1, 2, 3], [2, 4, 5], [3, 5, 6]]

        // Test 6: 3x2 matrix with all duplicate zeroes
        int[][] t6 = {
            { 0, 0 },
            { 0, 0 },
            { 0, 0 }
        };
        int[][] expT6 = {
            { 0, 0, 0 },
            { 0, 0, 0 }
        };
        int[][] resT6 = transpose(t6);
        System.out.println("Test 6:    " + Arrays.deepToString(resT6)
                + (Arrays.deepEquals(resT6, expT6) ? " (Correct)" : " (Wrong)")); // Expected: [[0, 0, 0], [0, 0, 0]]

        // Test 7: Tall 4x2 matrix -> becomes wide 2x4 matrix
        int[][] t7 = {
            { 1, 2 },
            { 3, 4 },
            { 5, 6 },
            { 7, 8 }
        };
        int[][] expT7 = {
            { 1, 3, 5, 7 },
            { 2, 4, 6, 8 }
        };
        int[][] resT7 = transpose(t7);
        System.out.println("Test 7:    " + Arrays.deepToString(resT7)
                + (Arrays.deepEquals(resT7, expT7) ? " (Correct)" : " (Wrong)")); // Expected: [[1, 3, 5, 7], [2, 4, 6, 8]]

        // Test 8: Wide 2x4 matrix -> becomes tall 4x2 matrix
        int[][] t8 = {
            { 1, 3, 5, 7 },
            { 2, 4, 6, 8 }
        };
        int[][] expT8 = {
            { 1, 2 },
            { 3, 4 },
            { 5, 6 },
            { 7, 8 }
        };
        int[][] resT8 = transpose(t8);
        System.out.println("Test 8:    " + Arrays.deepToString(resT8)
                + (Arrays.deepEquals(resT8, expT8) ? " (Correct)" : " (Wrong)")); // Expected: [[1, 2], [3, 4], [5, 6], [7, 8]]

        // Test 9: 2x2 matrix with mixed signs and zeroes
        int[][] t9 = {
            { -100, 0 },
            { 50, 100 }
        };
        int[][] expT9 = {
            { -100, 50 },
            { 0, 100 }
        };
        int[][] resT9 = transpose(t9);
        System.out.println("Test 9:    " + Arrays.deepToString(resT9)
                + (Arrays.deepEquals(resT9, expT9) ? " (Correct)" : " (Wrong)")); // Expected: [[-100, 50], [0, 100]]
    }
}
