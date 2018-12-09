/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apress.projsp.store;

/**
 *
 * @author User
 */
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
    /**
     * Preforms the processing associated with this action.
     * 
     * @param request the HttpServletRequest instance
     * @param response
     * @param request the HttpServletResponse instance
     * @return the name of the next view
     */
    
    public String process(HttpServletRequest request, HttpServletResponse response)
        throws ServletException;
    
}
