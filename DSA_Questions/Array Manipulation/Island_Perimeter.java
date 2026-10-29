// 463. Island Perimeter

// You are given row x col grid representing a map where grid[i][j] = 1 represents land
// and grid[i][j] = 0 represents water.
//
// Grid cells are connected horizontally/vertically (not diagonally). The grid is completely
// surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
//
// The island doesn't have "lakes", meaning the water inside isn't connected to the water
// around the island. One cell is a square with side length 1. The grid is rectangular, width
// and height don't exceed 100. Determine the perimeter of the island.

// Constraints:
// - row == grid.length
// - col == grid[i].length
// - 1 <= row, col <= 100
// - grid[i][j] is 0 or 1.
// - There is exactly one island in grid.

public class Island_Perimeter {

    // My Solution
    static int islandPerimeter(int[][] grid) {
        int p = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    if (i == 0) {
                        p++;
                    }
                    if (i == grid.length - 1) {
                        p++;
                    }
                    if (j == 0) {
                        p++;
                    }
                    if (j == grid[i].length - 1) {
                        p++;
                    }
                    if (i != 0) {
                        if (grid[i - 1][j] == 0) {
                            p++;
                        }
                    }
                    if (i != grid.length - 1) {
                        if (grid[i + 1][j] == 0) {
                            p++;
                        }
                    }
                    if (j != 0) {
                        if (grid[i][j - 1] == 0) {
                            p++;
                        }
                    }
                    if (j != grid[i].length - 1) {
                        if (grid[i][j + 1] == 0) {
                            p++;
                        }
                    }
                }
            }
        }

        return p;
    }

    public static void main(String[] args) {
        // --- Provided Example Test Cases ---

        // Example 1:
        // Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
        // Output: 16
        int[][] grid1 = {
            { 0, 1, 0, 0 },
            { 1, 1, 1, 0 },
            { 0, 1, 0, 0 },
            { 1, 1, 0, 0 }
        };
        System.out.println("Example 1: " + islandPerimeter(grid1)); // Expected: 16

        // Example 2:
        // Input: grid = [[1]]
        // Output: 4
        int[][] grid2 = {
            { 1 }
        };
        System.out.println("Example 2: " + islandPerimeter(grid2)); // Expected: 4

        // Example 3:
        // Input: grid = [[1,0]]
        // Output: 4
        int[][] grid3 = {
            { 1, 0 }
        };
        System.out.println("Example 3: " + islandPerimeter(grid3)); // Expected: 4

        // --- Additional Test Cases ---

        // Test 1: Single row, two adjacent lands
        int[][] t1 = { { 1, 1 } };
        System.out.println("Test 1:    " + islandPerimeter(t1)); // Expected: 6

        // Test 2: Single column, two vertical lands
        int[][] t2 = { { 1 }, { 1 } };
        System.out.println("Test 2:    " + islandPerimeter(t2)); // Expected: 6

        // Test 3: 2x2 solid square of land
        int[][] t3 = { { 1, 1 }, { 1, 1 } };
        System.out.println("Test 3:    " + islandPerimeter(t3)); // Expected: 8

        // Test 4: L-shaped island
        int[][] t4 = { { 1, 0 }, { 1, 1 } };
        System.out.println("Test 4:    " + islandPerimeter(t4)); // Expected: 8

        // Test 5: Horizontal line island surrounded by water
        int[][] t5 = {
            { 0, 0, 0 },
            { 1, 1, 1 },
            { 0, 0, 0 }
        };
        System.out.println("Test 5:    " + islandPerimeter(t5)); // Expected: 8

        // Test 6: Cross '+' shaped island
        int[][] t6 = {
            { 0, 1, 0 },
            { 1, 1, 1 },
            { 0, 1, 0 }
        };
        System.out.println("Test 6:    " + islandPerimeter(t6)); // Expected: 12

        // Test 7: Single cell island with water borders
        int[][] t7 = {
            { 0, 0, 0 },
            { 0, 1, 0 },
            { 0, 0, 0 }
        };
        System.out.println("Test 7:    " + islandPerimeter(t7)); // Expected: 4

        // Test 8: 1x4 horizontal strip of land
        int[][] t8 = { { 1, 1, 1, 1 } };
        System.out.println("Test 8:    " + islandPerimeter(t8)); // Expected: 10
    }
}
