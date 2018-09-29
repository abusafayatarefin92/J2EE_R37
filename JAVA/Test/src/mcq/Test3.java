/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq;

/**
 *
 * @author Safayat
 */
public class Test3 {

    public static void main(String[] args) {
        int x = 3, y = 4;
        switch (x + 3) {
            case 6:
                y = 0;
            case 7:
                y = 1;
            default:
                y += 1;
        }

        System.out.println(y);
    }

}
