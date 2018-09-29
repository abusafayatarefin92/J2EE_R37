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
public class Base {

    int value = 0;

    Base() {
        addValue();
    }

    void addValue() {
        value += 10;
    }

    int getValue() {
        return value;
    }

}
