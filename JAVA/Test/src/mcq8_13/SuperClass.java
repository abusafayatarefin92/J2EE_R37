/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mcq8_13;

/**
 *
 * @author User
 */
public class SuperClass {

    public int doIt(String str, Integer... data) throws Exception {
        String signature = "(String, Integer[])";
        System.out.println(str + " " + signature);
        return 1;
    }

}
