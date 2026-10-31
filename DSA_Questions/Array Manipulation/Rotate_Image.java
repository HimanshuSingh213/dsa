// 48. Rotate Image

// You are given an n x n 2D matrix representing an image, rotate the image
// by 90 degrees (clockwise).
//
// You have to rotate the image in-place, which means you have to modify the input 2D
// matrix directly. DO NOT allocate another 2D matrix and do the rotation.

// Constraints:
// - n == matrix.length == matrix[i].length
// - 1 <= n <= 20
// - -1000 <= matrix[i][j] <= 1000

import java.util.Arrays;

public class Rotate_Image {

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
    static void rotate(int[][] matrix) {
        if (matrix.length == 1 && matrix[0].length == 1) {
            return;
        }

        // display(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        // System.out.println("After Transpose: ");
        // display(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length - 1 - j];
                matrix[i][matrix[i].length - 1 - j] = temp;
            }
        }

        // System.out.println("Final Answer");
        // display(matrix);
    }

    public static void main(String[] args) {
        // --- Provided Example Test Cases ---

        // Example 1: 3x3 matrix
        int[][] ex1 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int[][] exp1 = {
                { 7, 4, 1 },
                { 8, 5, 2 },
                { 9, 6, 3 }
        };
        rotate(ex1);
        System.out.println("Example 1: " + Arrays.deepToString(ex1)
                + (Arrays.deepEquals(ex1, exp1) ? " (Correct)" : " (Wrong)")); // Expected: [[7, 4, 1], [8, 5, 2], [9,
                                                                               // 6, 3]]

        // Example 2: 4x4 matrix
        int[][] ex2 = {
                { 5, 1, 9, 11 },
                { 2, 4, 8, 10 },
                { 13, 3, 6, 7 },
                { 15, 14, 12, 16 }
        };
        int[][] exp2 = {
                { 15, 13, 2, 5 },
                { 14, 3, 4, 1 },
                { 12, 6, 8, 9 },
                { 16, 7, 10, 11 }
        };
        rotate(ex2);
        System.out.println("Example 2: " + Arrays.deepToString(ex2)
                + (Arrays.deepEquals(ex2, exp2) ? " (Correct)" : " (Wrong)")); // Expected: [[15, 13, 2, 5], [14, 3, 4,
                                                                               // 1], [12, 6, 8, 9], [16, 7, 10, 11]]

        // --- Additional Test Cases ---

        // Test 1: Minimal 1x1 matrix
        int[][] t1 = { { 1 } };
        int[][] expT1 = { { 1 } };
        rotate(t1);
        System.out.println("Test 1:    " + Arrays.deepToString(t1)
                + (Arrays.deepEquals(t1, expT1) ? " (Correct)" : " (Wrong)")); // Expected: [[1]]

        // Test 2: Minimal 2x2 matrix with positive values
        int[][] t2 = {
                { 1, 2 },
                { 3, 4 }
        };
        int[][] expT2 = {
                { 3, 1 },
                { 4, 2 }
        };
        rotate(t2);
        System.out.println("Test 2:    " + Arrays.deepToString(t2)
                + (Arrays.deepEquals(t2, expT2) ? " (Correct)" : " (Wrong)")); // Expected: [[3, 1], [4, 2]]

        // Test 3: 2x2 matrix with negative numbers
        int[][] t3 = {
                { -1, -2 },
                { -3, -4 }
        };
        int[][] expT3 = {
                { -3, -1 },
                { -4, -2 }
        };
        rotate(t3);
        System.out.println("Test 3:    " + Arrays.deepToString(t3)
                + (Arrays.deepEquals(t3, expT3) ? " (Correct)" : " (Wrong)")); // Expected: [[-3, -1], [-4, -2]]

        // Test 4: 2x2 matrix with all identical elements
        int[][] t4 = {
                { 0, 0 },
                { 0, 0 }
        };
        int[][] expT4 = {
                { 0, 0 },
                { 0, 0 }
        };
        rotate(t4);
        System.out.println("Test 4:    " + Arrays.deepToString(t4)
                + (Arrays.deepEquals(t4, expT4) ? " (Correct)" : " (Wrong)")); // Expected: [[0, 0], [0, 0]]

        // Test 5: 3x3 matrix with row-wise identical elements
        int[][] t5 = {
                { 1, 1, 1 },
                { 2, 2, 2 },
                { 3, 3, 3 }
        };
        int[][] expT5 = {
                { 3, 2, 1 },
                { 3, 2, 1 },
                { 3, 2, 1 }
        };
        rotate(t5);
        System.out.println("Test 5:    " + Arrays.deepToString(t5)
                + (Arrays.deepEquals(t5, expT5) ? " (Correct)" : " (Wrong)")); // Expected: [[3, 2, 1], [3, 2, 1], [3,
                                                                               // 2, 1]]

        // Test 6: 3x3 matrix with zeros and extreme bounds (-1000, 1000)
        int[][] t6 = {
                { -1000, 0, 1000 },
                { 0, 0, 0 },
                { 1000, 0, -1000 }
        };
        int[][] expT6 = {
                { 1000, 0, -1000 },
                { 0, 0, 0 },
                { -1000, 0, 1000 }
        };
        rotate(t6);
        System.out.println("Test 6:    " + Arrays.deepToString(t6)
                + (Arrays.deepEquals(t6, expT6) ? " (Correct)" : " (Wrong)")); // Expected: [[1000, 0, -1000], [0, 0,
                                                                               // 0], [-1000, 0, 1000]]

        // Test 7: 3x3 identity matrix (diagonal 1s)
        int[][] t7 = {
                { 1, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 1 }
        };
        int[][] expT7 = {
                { 0, 0, 1 },
                { 0, 1, 0 },
                { 1, 0, 0 }
        };
        rotate(t7);
        System.out.println("Test 7:    " + Arrays.deepToString(t7)
                + (Arrays.deepEquals(t7, expT7) ? " (Correct)" : " (Wrong)")); // Expected: [[0, 0, 1], [0, 1, 0], [1,
                                                                               // 0, 0]]

        // Test 8: 4x4 alternating pattern matrix
        int[][] t8 = {
                { 1, 0, 1, 0 },
                { 0, 1, 0, 1 },
                { 1, 0, 1, 0 },
                { 0, 1, 0, 1 }
        };
        int[][] expT8 = {
                { 0, 1, 0, 1 },
                { 1, 0, 1, 0 },
                { 0, 1, 0, 1 },
                { 1, 0, 1, 0 }
        };
        rotate(t8);
        System.out.println("Test 8:    " + Arrays.deepToString(t8)
                + (Arrays.deepEquals(t8, expT8) ? " (Correct)" : " (Wrong)")); // Expected: [[0, 1, 0, 1], [1, 0, 1, 0],
                                                                               // [0, 1, 0, 1], [1, 0, 1, 0]]

        // Test 9: 4x4 sequential matrix
        int[][] t9 = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        int[][] expT9 = {
                { 13, 9, 5, 1 },
                { 14, 10, 6, 2 },
                { 15, 11, 7, 3 },
                { 16, 12, 8, 4 }
        };
        rotate(t9);
        System.out.println("Test 9:    " + Arrays.deepToString(t9)
                + (Arrays.deepEquals(t9, expT9) ? " (Correct)" : " (Wrong)")); // Expected: [[13, 9, 5, 1], [14, 10, 6,
                                                                               // 2], [15, 11, 7, 3], [16, 12, 8, 4]]
    }
}
