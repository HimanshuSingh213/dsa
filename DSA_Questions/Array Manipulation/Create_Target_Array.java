// 1389. Create Target Array in the Given Order

// Given two arrays of integers nums and index. Your task is to create target array under the following rules:

// Initially target array is empty.
// From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
// Repeat the previous step until there are no elements to read in nums and index.
// Return the target array.

// It is guaranteed that the insertion operations will be valid.

public class Create_Target_Array {

    static void display(int[] arr){
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    static int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];
        int i = 0;
        while(i < index.length){
            if(i > index[i]){
                for(int j = nums.length - 1; j > index[i]; j--){
                    target[j] = target[j-1];
                }
            }
            target[index[i]] = nums[i];
            i++;

        }

        return target;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4};
        int[] index = {0,1,2,2,1};

        // output = [0,4,1,3,2]
        int[] target = createTargetArray(nums, index);
        display(target);
    }
}
