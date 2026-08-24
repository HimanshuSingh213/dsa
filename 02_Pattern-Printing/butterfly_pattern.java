import java.util.Scanner;

public class butterfly_pattern {
    public static void main(String[] args) {
        System.out.print("Enter the no. of lines: ");
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();

        // upper Half
        // for loop for traversing rows
        for (int i = 0; i < rows; i++) {
            // for loop for traversing coloumns
            for (int j = 0; j < 2 * (i + 1); j++) {

                // print the stars
                System.out.print("* ");

                // create spaces between it
                if (j == i)
                    for (int j2 = 0; j2 < 2 * rows - (2 * (i + 1)); j2++) {
                        System.out.print("  ");
                    }
            }
            System.out.println();
        }

        // lower Half
        // for loop for traversing rows
        for (int i = 0; i < rows; i++) {
            // for loop for traversing columns
            for (int j = 0; j < 2 * (rows - i); j++) {

                // printing stars
                System.out.print("* ");

                // create spaces between it
                if (j == rows - i - 1)
                    for (int j2 = 0; j2 < 2 * i; j2++) {
                        System.out.print("  ");
                    }
            }
            System.out.println();
        }

        sc.close();
    }
}
