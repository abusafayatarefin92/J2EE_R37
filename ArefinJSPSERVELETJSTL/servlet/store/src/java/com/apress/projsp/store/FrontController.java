/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apress.projsp.store;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author User
 */
public class FrontController  extends HttpServlet{
    public void init() throws ServletException{
        HashMap products = new HashMap();
        
        Product p = new Product("Dog", "9.99", 1);
        products.put("1", p);
        
        p = new Product("Cat", "4.99", 2);
        products.put("2", p);
        
        p = new Product("Fish", "1.99", 3);
        products.put("3", p);
        
        //Store products in the servlet context
        getServletContext().setAttribute("products", products);
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        //load the action
        String name = req.getPathInfo().substring(1);
        String viewName = "/error.jsp";
        
        try {
            name = "com.apress.projsp.store." + name;
            
            Class c = getClass().getClassLoader().loadClass(name);
            Action action = (Action)c.newInstance();
            viewName = action.process(req, res);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (InstantiationException e) {
            e.printStackTrace();
        }catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewName);
        dispatcher.forward(req, res);
    }
    
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        doPost(req, res);
    }
}
