import java.util.Scanner;

public class count_of_numbers {
    
    static int CountDigits(int num){
        int count = 0;

        while(num != 0){
            count++;
            num /= 10;
        }

        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = sc.nextInt();

        System.out.println("Total digits: " + CountDigits(num));

        sc.close();
    }
}
