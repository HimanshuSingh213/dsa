import java.util.Scanner;

public class diamond {
    public static void main(String[] args) {
        System.out.print("Enter the no. of lines: ");
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();

        // upper triangle
        for (int i = 0; i < rows; i++) {
            // space
            for (int j = 0; j < rows - i; j++) {
                System.out.print("  ");
            }

            // printing triangle pattern
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        // lower inverted triangle
        for (int i = 0; i < rows; i++) {
            if (i == 0) {
                continue;
            }

            // spaces
            for (int j = 0; j < i+1; j++) {
                System.out.print("  ");
            }

            // inverted triangle pattern
            for (int j = 0; j < (2 * rows - 2 * i - 1); j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        sc.close();
    }
}
