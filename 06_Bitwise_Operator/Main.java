public class Main {
    public static void main(String[] args) {
        // checking if a number is power of 2 (i.e. 2^i)
        // if a binary number have only 1 set-bit then its a power of 2
        int[] x = { 32, 8, 6, 15, 12, 16, 56, 64 };

        // count set-bit
        for (int i = 0; i < x.length; i++) {

            // ---- BY count SetBit technique ----

            // int count = 0;

            // while (x[i] != 0) {
            // if ((x[i] & 1) == 1)
            // count++;

            // x[i] = x[i] >> 1;
            // }

            // System.out.print("SetBit Count for x[" + i + "]: " + count);
            // if (count == 1) {
            // System.out.println(" -- 2^i");
            // } else {
            // System.out.println(" -- not 2^i");
            // }

            // ---- By Simple Formula --- (n & (n-1) == 0)
            if ((x[i] & (x[i] - 1)) == 0) {
                System.out.println(" -- 2^i");
            } else {
                System.out.println(" -- not 2^i");
            }

        }

        System.out.println(5 & 6);
        System.out.println(5 | 6);
        System.out.println(5 ^ 6);
        System.out.println(~5);
        System.out.println(3 << 2);
        System.out.println(16 >> 2);
    }
}
