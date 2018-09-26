
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class OneDFromScanner {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the length of the array");
        int arraySize = input.nextInt();
        Integer[] arr = new Integer[arraySize];

        System.out.println("Enter values of array");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.nextInt();
        }

        Arrays.sort(arr);
        Collections.reverse(Arrays.asList(arr));
        System.out.println(Arrays.toString(arr));
    }
}
