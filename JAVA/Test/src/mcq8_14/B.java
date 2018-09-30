/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq8_14;

/**
 *
 * @author User
 */
class B extends A {

    B() {
    }

    B(String s) {
        super(s);
    }

    void test() {
        A a = new B();
    }
}
