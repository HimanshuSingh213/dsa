
public class Sorting_of_0s_1s {

    static void display(int[] arr){
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }
    public static void main(String[] args) {
        int[] arr = { 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 };

        int start = 0, end = arr.length - 1;

        while (start < end) {
            if((arr[start] == 1) && (arr[end] == 0)){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }

            if(arr[start] == 0)
                start++;
            if(arr[end] == 1)
                end--;

        }

        display(arr);
    }
}
