/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq8_3;

/**
 *
 * @author User
 */
public class Derived extends Base {

    public Derived() {
        this("IDB");
        System.out.print("Derived");
    }

    public Derived(String s) {
        System.out.print(s);
    }

    public static void main(String[] args) {
        new Derived();
    }
}
