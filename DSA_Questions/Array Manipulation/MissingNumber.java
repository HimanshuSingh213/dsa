public class MissingNumber {

    static int missingNum(int[] arr, int range){
        int xorSum = 0;
        for (int i : arr) {
            xorSum = xorSum ^ i;
        }

        for (int i = 0; i < range; i++) {
            xorSum = xorSum ^ i;
        }

        return xorSum;
    }
    public static void main(String[] args) {
        // range = 7
        int[] arr = { 2, 3, 5, 1, 4, 0 };

        int range = 7;

        System.out.println("Missing number: " + missingNum(arr, range));
    }
}
