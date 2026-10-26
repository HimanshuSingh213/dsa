import java.util.Arrays;

public class Alternate_Print {
    static void display(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    static void printAlt(int[] arr){
        Arrays.sort(arr);

        System.out.print("[ ");

        int i = 0;
        while (i < arr.length/2) {
            System.out.print(arr[i] + " ");
            System.out.print(arr[arr.length - i - 1] + " ");
            i++;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] arr = { 12, 15, 26, 1, 6, 8 };

        display(arr);

        // printing alternate highest and lowest
        printAlt(arr);


    }

}
