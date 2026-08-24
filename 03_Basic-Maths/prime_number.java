import java.util.Scanner;

public class prime_number {

    // Basic Way
    // static boolean isPrime(int num){
    // if(num < 1) return false;

    // for (int i = 2; i < num; i++) {
    // if(num%i == 0) return false;
    // }

    // return true;
    // }

    // Optimised Way
    static boolean isPrime(int num) {
        if (num < 1)
            return false;

        for (int i = 2; i*i <= num; i++) {
            System.out.println("index" + i);
            if (num % i == 0)
                return false;
        }

        return true;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = sc.nextInt();

        System.out.println(
                isPrime(num) ? ("Yes, " + num + " is a Prime no.") : ("No, " + num + " is not a Prime no."));

        sc.close();
    }
}
