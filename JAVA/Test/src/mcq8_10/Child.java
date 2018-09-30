/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq8_10;

/**
 *
 * @author User
 */
public class Child extends Parent {

    /**
     *
     */
    @Override
    public void method() {
        System.out.println("Hi i am Child");
    }

    public static void main(String args[]) {
        Child child = new Child();
        child.method();
    }
}
