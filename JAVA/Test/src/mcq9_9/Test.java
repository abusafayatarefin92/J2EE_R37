/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq9_9;

/**
 *
 * @author User
 */
public class Test {

    public static void main(String args[]) {
        try {
            String arr[] = new String[10];
            arr = null;
            arr[0] = "one";
            System.out.print(arr[0]);
        } catch (Exception ex) {
            System.out.print("exception");
        }
    }
}
