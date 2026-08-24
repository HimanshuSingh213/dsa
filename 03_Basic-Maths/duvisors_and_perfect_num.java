import java.util.Scanner;

public class duvisors_and_perfect_num {

    static boolean isPerfectnum(int num) {
        int sum = 1;

        for (int i = 2; i * i < num; i++) {
            if (num % i == 0) {
                int firstFactor = i;
                int secondFactor = num / i;
                sum += firstFactor + secondFactor;
            }
        }

        return sum == num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = sc.nextInt();

        System.out.println(
                isPerfectnum(num) ? ("Yes, " + num + " is a Perfect no.") : ("No, " + num + " is not a Perfect no."));

        sc.close();
    }
}
