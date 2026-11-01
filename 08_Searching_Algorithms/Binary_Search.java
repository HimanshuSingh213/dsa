public class Binary_Search {

    static int BinarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            System.out.println("mid: " + nums[mid]);
            System.out.println("start: " + nums[start]);
            System.out.println("end: " + nums[end]);

            if (nums[mid] == target) {
                return mid;
            }

            else if (nums[mid] < target) {
                start = mid + 1;
            }

            else if (nums[mid] > target) {
                end = mid - 1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 5, 6, 7, 8, 9, 10, 12, 15, 18 };

        System.out.println(BinarySearch(arr, 10));
    }
}
