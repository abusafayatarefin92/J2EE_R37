
import java.util.Arrays;
import java.util.Collections;

public class SortingArray {
    
    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 8, 6, 9, 15, 16, 11, 7};
        
        for (int a : arr) {
            System.out.print(a + " ");
        }
        
        System.out.println();
        
        System.out.println("Sorted array or ascending order");
        
        int[] a = {4, 2, 1, 8, 6, 9, 15, 16, 11, 7};
        Arrays.sort(a);
        
        for (int j : a) {
            System.out.print(j + " ");
        }
        
        System.out.println();
        
        System.out.println("Descending order");
        
        int[] b = {4, 2, 1, 8, 6, 9, 15, 16, 11, 7};
        Arrays.sort(b);
        
        for (int i = b.length - 1; i >= 0; i--) {
            System.out.print(b[i] + " ");
        }
        
        System.out.println("Array descending order using Reverse");
        
        Integer[] c = {4, 2, 1, 8, 6, 9, 15, 16, 11, 7};
        Arrays.sort(c);
        Collections.reverse(Arrays.asList(c));
        
        System.out.println("Modified Array: " + Arrays.toString(c));
    }
}
