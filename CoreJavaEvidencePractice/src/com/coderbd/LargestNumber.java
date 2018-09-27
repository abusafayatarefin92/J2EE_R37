/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.coderbd;

import java.util.Scanner;
public class LargestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        islargestNumber(sc.nextInt(), sc.nextInt(), sc.nextInt());
    }
    
    static void islargestNumber(int n1, int n2, int n3){
        if(n1 > n2 && n1 > n3){
            System.out.println(n1 + " is largest number");
        }else if(n2 > n1 && n2 > n3){
            System.out.println(n2 + " is largest number");
        }else if(n3 > n1 && n3 > n2){
            System.out.println(n3 + " is largest number");
        }else if(n1 >= n2){
            System.out.println(n2 + " is largest number");
        }
    }
}
