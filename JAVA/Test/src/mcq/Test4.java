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
public class Test4 {

    public static void main(String[] args) {
        double sum = 0;
        for (double d = 0; d < 10;) {
            d += 0.1;
            sum += sum + d;
        }
        
        System.out.println(sum);
    }

}
