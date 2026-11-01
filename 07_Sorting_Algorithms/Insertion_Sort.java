public class Insertion_Sort {
    static void display(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    static void InsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int prev = i - 1;
            int currVal = arr[i];

            while (prev >= 0 && arr[prev] > currVal) {
                arr[prev + 1] = arr[prev];
                prev--;
            }

            arr[prev + 1] = currVal;

        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 4, 8, 12, 9, 6, 7, 18, 15, 10 };

        display(arr);
        InsertionSort(arr);
        display(arr);
    }
}
