// 2187. Minimum Time to Complete Trips

// You are given an array time where time[i] denotes the time taken by the ith bus
// to complete one trip.
//
// Each bus can make multiple trips successively; that is, the next trip can start
// immediately after completing the current trip. Also, each bus operates
// independently; that is, the trips of one bus do not influence the trips of
// any other bus.
//
// You are also given an integer totalTrips, which denotes the number of trips all
// buses should make in total. Return the minimum time required for all buses to
// complete at least totalTrips trips.

// Constraints:
// - 1 <= time.length <= 10^5
// - 1 <= time[i], totalTrips <= 10^7

public class Minimum_Time_to_Complete_Trips {

    // My Solution
    static long minimumTime(int[] time, int totalTrips) {
        // WRONG DUE TO TLE ERROR
        int i = 1;
        while (6 > 5) {
            int sum = 0;
            for (int j = 0; j < time.length; j++) {
                sum += i / time[j];

            }

            System.out.println("sum: " + sum);

            if (sum >= totalTrips)
                return i;

            i++;
        }

    }

    public static void main(String[] args) {
        // --- Provided Example Test Cases ---

        // Example 1:
        // Input: time = [1,2,3], totalTrips = 5
        // Output: 3
        int[] time1 = { 1, 2, 3 };
        int totalTrips1 = 5;
        System.out.println("Example 1: " + minimumTime(time1, totalTrips1)); // Expected: 3

        // Example 2:
        // Input: time = [2], totalTrips = 1
        // Output: 2
        int[] time2 = { 2 };
        int totalTrips2 = 1;
        System.out.println("Example 2: " + minimumTime(time2, totalTrips2)); // Expected: 2

        // Example 3:
        // Input: time = [3,3,8], totalTrips = 6
        // Output: 9
        int[] time3 = { 3, 3, 8 };
        int totalTrips3 = 6;
        System.out.println("Example 3: " + minimumTime(time3, totalTrips3)); // Expected: 9

        // --- Additional Test Cases ---

        // Test 1: Single bus needing multiple trips
        int[] t1 = { 1 };
        int trips1 = 3;
        System.out.println("Test 1:    " + minimumTime(t1, trips1)); // Expected: 3

        // Test 2: Two buses with identical trip duration
        int[] t2 = { 2, 2 };
        int trips2 = 4;
        System.out.println("Test 2:    " + minimumTime(t2, trips2)); // Expected: 4

        // Test 3: Fast bus vs slow bus
        int[] t3 = { 1, 10 };
        int trips3 = 5;
        System.out.println("Test 3:    " + minimumTime(t3, trips3)); // Expected: 5

        // Test 4: Long trip buses with only 1 total trip required
        int[] t4 = { 5, 10, 15 };
        int trips4 = 1;
        System.out.println("Test 4:    " + minimumTime(t4, trips4)); // Expected: 5

        // Test 5: Two buses with only 1 trip needed
        int[] t5 = { 3, 5 };
        int trips5 = 1;
        System.out.println("Test 5:    " + minimumTime(t5, trips5)); // Expected: 3

        // Test 6: Fast bus finishes all required trips alone
        int[] t6 = { 2, 100 };
        int trips6 = 3;
        System.out.println("Test 6:    " + minimumTime(t6, trips6)); // Expected: 6

        // Test 7: Three identical buses
        int[] t7 = { 4, 4, 4 };
        int trips7 = 6;
        System.out.println("Test 7:    " + minimumTime(t7, trips7)); // Expected: 8

        // Test 8: Different speeds requiring combined trips
        int[] t8 = { 2, 3 };
        int trips8 = 5;
        System.out.println("Test 8:    " + minimumTime(t8, trips8)); // Expected: 6
    }
}
