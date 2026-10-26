import java.util.HashMap;

public class Highest_Lowest_freq {
    static int[] getHighLow(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {

            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);

        }

        int maxFreqKey = 0, maxFreqVal = Integer.MIN_VALUE, minFreqKey = 0, minFreqVal = Integer.MAX_VALUE;

        for (int i : freq.keySet()) {
            if (freq.get(i) > maxFreqVal) {
                maxFreqKey = i;
                maxFreqVal = freq.get(i);
            }

            if (freq.get(i) < minFreqVal) {
                minFreqKey = i;
                minFreqVal = freq.get(i);
            }
        }

        return new int[] { minFreqKey, maxFreqKey };
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 7, 7, 7, 5, 5, 5, 5, 8, 8, 9, 9 };

        System.out.println("Highest Freq: " + getHighLow(arr)[1]);
        System.out.println("lowest Freq: " + getHighLow(arr)[0]);
    }
}
