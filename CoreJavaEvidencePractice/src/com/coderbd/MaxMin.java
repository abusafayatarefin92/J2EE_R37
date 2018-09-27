package com.coderbd;

import java.util.Scanner;
import java.util.Arrays;

public class MaxMin {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter length of array: ");
        int n = sc.nextInt();
        Integer[] array = new Integer[n];

        System.out.println("Enter values of array: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);

        System.out.println("Min: " + array[0] + " Max: " + array[array.length - 1]);
    }
}
