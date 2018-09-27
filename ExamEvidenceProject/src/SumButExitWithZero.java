
import java.util.Scanner;

public class SumButExitWithZero {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int sum = 0;
        int n = 0;

        System.out.print("Enter a number: ");

        do {
            n = sc.nextInt();
            sum += n;
        } while (n != 0);

        System.out.println("Sum: " + sum);
    }
}
