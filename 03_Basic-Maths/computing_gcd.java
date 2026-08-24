import java.util.Scanner;

public class computing_gcd {

    // Euclidean Algorithm
    static int computeGCD(int a, int b){
        // gcd(a, b) = gcd(b, a % b)

        // Given two positive integers A and B (where A > B)
        // Divide A by B to find the remainder R ((A mod B = R)).
        // Replace A with B, and replace B with R.
        // Repeat the division until the remainder is 0.
        // The last non-zero remainder is the (gcd(A, B)).

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

        System.out.println("GCD of " + a + " and " + b + " is " + computeGCD(a, b));

        sc.close();
    }
}
