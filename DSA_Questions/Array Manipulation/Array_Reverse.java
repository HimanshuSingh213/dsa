
public class Array_Reverse {
    static void display(int[] arr){
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    static void reverseArr(int[] arr){
        int size = arr.length;
        for (int i = 0; i < size/2; i++) {
            int temp = arr[i];
            arr[i] = arr[size - i - 1];
            arr[size - i - 1] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {24, 15, 12, 8, 5, 9};

        display(arr);

        reverseArr(arr);

        display(arr);

    }
}
