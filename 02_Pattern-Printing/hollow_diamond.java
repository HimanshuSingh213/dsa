import java.util.Scanner;

public class hollow_diamond {
    public static void main(String[] args) {
        System.out.print("Enter the no. of lines: ");
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();

        // upper hollow triangle
        for (int i = 0; i < rows - 1; i++) {
            // leading spaces
            for (int j = 0; j < rows - i; j++) {
                System.out.print("  ");
            }

            // hollow triangle
            for (int j = 0; j < 2 * i + 1; j++) {
                if (i == 0) {
                    System.out.print("* ");
                } else {
                    if (j == 0 || j == 2 * i) {
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                }

            }

            System.out.println();
        }

        // lower hollow inverted triangle
        for (int i = 0; i < rows; i++) {

            // leading spaces
            for (int j = 0; j < i + 1; j++) {
                System.out.print("  ");
            }

            // hollow inverted triangle
            for (int j = 0; j < 2 * (rows - i) - 1; j++) {
                if (i == rows - 1) {
                    System.out.print("* ");
                } else {
                    if (j == 0 || j == 2 * (rows - i - 1)) {
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }

                }

            }
            System.out.println();
        }

        sc.close();
    }
}
