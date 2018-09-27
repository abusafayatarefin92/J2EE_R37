package com.coderbd;

import java.util.Scanner;

public class OddEven {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int number = sc.nextInt();
        isoddEven(number);
    }

    static void isoddEven(int num) {

        if (num == 0) {
            System.out.println(num + " is Zero");
        } else {
            if (num % 2 == 0) {
                System.out.println(num + " is Even number");
            } else {
                System.out.println(num + " is Odd number");
            }
        }
    }

}
