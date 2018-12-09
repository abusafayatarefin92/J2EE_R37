/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apress.projsp.store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class MainAction implements Action{

    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException {
        return "/main.jsp";
    }
    
}
