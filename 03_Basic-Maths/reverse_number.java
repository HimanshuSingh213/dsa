import java.util.Scanner;

public class reverse_number {
    static int RevNum(int num){
        int finalNum = 0;

        while(num != 0){
            int digit = num%10;
            finalNum = finalNum*10 + digit;
            num /= 10;
        }

        return finalNum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = sc.nextInt();

        System.out.println("Reversed number is: " + RevNum(num));

        sc.close();
    }
}
