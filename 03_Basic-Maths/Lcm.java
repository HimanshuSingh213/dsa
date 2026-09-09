import java.util.Scanner;

public class Lcm {

    static int computeGCD(int a, int b) {

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number a: ");
        int a = sc.nextInt();

        System.out.print("Enter the number b: ");
        int b = sc.nextInt();

        // LCM x HCF(gcd) = a x b
        System.out.println("LCM of " + a + " and " + b + " is " + (a * b) / computeGCD(a, b)); 

        sc.close();
    }
}
