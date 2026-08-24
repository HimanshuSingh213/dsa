import java.util.Scanner;

public class number_palindrome {
    static boolean isPalindrome(int num) {
        int originalNum = num;
        int finalNum = 0;

        while (num != 0) {
            int digit = num % 10;
            finalNum = finalNum * 10 + digit;
            num /= 10;
        }

        return (finalNum == originalNum);
            
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = sc.nextInt();

        System.out.println(
                isPalindrome(num) ? ("Yes, " + num + " is a Palindrome") : ("No, " + num + " is not a Palindrome."));

        sc.close();
    }
}
