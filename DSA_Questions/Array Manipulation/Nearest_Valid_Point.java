// 1779. Find Nearest Point That Has the Same X or Y Coordinate

// You are given two integers, x and y, which represent your current location on a
// Cartesian grid: (x, y). You are also given an array points where each points[i] = [ai, bi]
// represents that a point exists at (ai, bi). A point is valid if it shares the same
// x-coordinate or the same y-coordinate as your location.
//
// Return the index (0-indexed) of the valid point with the smallest Manhattan distance
// from your current location. If there are multiple, return the smallest index. If there
// are no valid points, return -1.
//
// The Manhattan distance between two points (x1, y1) and (x2, y2) is abs(x1 - x2) + abs(y1 - y2).

// Constraints:
// - 1 <= points.length <= 10^4
// - points[i].length == 2
// - 1 <= x, y, ai, bi <= 10^4

public class Nearest_Valid_Point {

    // My Solution
    static int nearestValidPoint(int x, int y, int[][] points) {
        int minDistance = Integer.MAX_VALUE;
        int answer = -1;
        for (int i = 0; i < points.length; i++) {
            // checking valid points
            if (points[i][0] == x || points[i][1] == y) {
                int d = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);
                if (d < minDistance) {
                    minDistance = d;
                    answer = i;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // --- Provided Example Test Cases ---

        // Example 1:
        // Input: x = 3, y = 4, points = [[1,2],[3,1],[2,4],[2,3],[4,4]]
        // Output: 2
        int[][] p1 = { { 1, 2 }, { 3, 1 }, { 2, 4 }, { 2, 3 }, { 4, 4 } };
        int res1 = nearestValidPoint(3, 4, p1);
        System.out.println("Example 1: " + res1 + (res1 == 2 ? " (Correct)" : " (Wrong)")); // Expected: 2

        // Example 2:
        // Input: x = 3, y = 4, points = [[3,4]]
        // Output: 0
        int[][] p2 = { { 3, 4 } };
        int res2 = nearestValidPoint(3, 4, p2);
        System.out.println("Example 2: " + res2 + (res2 == 0 ? " (Correct)" : " (Wrong)")); // Expected: 0

        // Example 3:
        // Input: x = 3, y = 4, points = [[2,3]]
        // Output: -1
        int[][] p3 = { { 2, 3 } };
        int res3 = nearestValidPoint(3, 4, p3);
        System.out.println("Example 3: " + res3 + (res3 == -1 ? " (Correct)" : " (Wrong)")); // Expected: -1

        // --- Additional Test Cases ---

        // Test 1: Single point sharing x only
        int[][] t1 = { { 1, 5 } };
        int r1 = nearestValidPoint(1, 1, t1);
        System.out.println("Test 1:    " + r1 + (r1 == 0 ? " (Correct)" : " (Wrong)")); // Expected: 0

        // Test 2: Single point sharing y only
        int[][] t2 = { { 5, 1 } };
        int r2 = nearestValidPoint(1, 1, t2);
        System.out.println("Test 2:    " + r2 + (r2 == 0 ? " (Correct)" : " (Wrong)")); // Expected: 0

        // Test 3: Multiple points with equal smallest distance (returns smallest index)
        int[][] t3 = { { 2, 1 }, { 2, 3 } };
        int r3 = nearestValidPoint(2, 2, t3);
        System.out.println("Test 3:    " + r3 + (r3 == 0 ? " (Correct)" : " (Wrong)")); // Expected: 0

        // Test 4: Closer valid point appears later in array
        int[][] t4 = { { 5, 10 }, { 5, 6 } };
        int r4 = nearestValidPoint(5, 5, t4);
        System.out.println("Test 4:    " + r4 + (r4 == 1 ? " (Correct)" : " (Wrong)")); // Expected: 1

        // Test 5: Same coordinates appearing multiple times (returns smallest index)
        int[][] t5 = { { 3, 3 }, { 3, 3 } };
        int r5 = nearestValidPoint(3, 3, t5);
        System.out.println("Test 5:    " + r5 + (r5 == 0 ? " (Correct)" : " (Wrong)")); // Expected: 0

        // Test 6: Multiple invalid points, none valid
        int[][] t6 = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
        int r6 = nearestValidPoint(10, 10, t6);
        System.out.println("Test 6:    " + r6 + (r6 == -1 ? " (Correct)" : " (Wrong)")); // Expected: -1

        // Test 7: Comparing x-aligned vs y-aligned point distance
        int[][] t7 = { { 4, 8 }, { 1, 4 } };
        int r7 = nearestValidPoint(4, 4, t7);
        System.out.println("Test 7:    " + r7 + (r7 == 1 ? " (Correct)" : " (Wrong)")); // Expected: 1

        // Test 8: Large gap between valid and invalid points
        int[][] t8 = { { 1000, 2 }, { 1, 1000 } };
        int r8 = nearestValidPoint(1, 1, t8);
        System.out.println("Test 8:    " + r8 + (r8 == 1 ? " (Correct)" : " (Wrong)")); // Expected: 1
    }
}
