import java.util.HashMap;

public class Finding_Mode {

    static int getMode(int[] arr) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            // if (!freq.containsKey(arr[i])) {
            // freq.put(arr[i], 1);
            // }
            // else{
            // freq.replace(arr[i], (freq.get(arr[i])) + 1);
            // }

            // Both ways can be used

            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }


        int  maxFreqKey = -1, maxFreqVal = Integer.MIN_VALUE;

        for (int i : freq.keySet()) {
            if(freq.get(i) > maxFreqVal){
                maxFreqKey = i;
                maxFreqVal = freq.get(i);
            }
        }

        return maxFreqKey;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 7, 7, 7, 5, 5, 5, 5, 8, 8, 9, 9 };

        System.out.println("Mode of arr: " + getMode(arr));
    }
}
