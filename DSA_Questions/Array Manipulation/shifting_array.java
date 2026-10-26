public class shifting_array {
    static void display(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    static void shiftArr(int[] arr){
        for (int i = arr.length-1; i > 0; i--) {
            arr[i] = arr[i-1];
        }
    }

    public static void main(String[] args) {
        int[] arr = { 12, 15, 26, 1, 6, 8 };

        display(arr);

        // Shifting right by 1 position
        shiftArr(arr);

        display(arr);

    }
}
