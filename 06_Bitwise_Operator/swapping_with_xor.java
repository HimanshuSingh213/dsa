public class swapping_with_xor {
    public static void main(String[] args) {
        int x = 12, y = 16;
        // Formula :
        // x = x ^ y
        // b = x ^ y
        // x = x ^ y => output - x and y get swapped

        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println(x + " " + y);
    }
}
