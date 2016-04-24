/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.sistema.alocacao.core.filters;

import io.github.jass2125.sistema.alocacao.core.business.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Anderson Souza 
 * @since 02:21:10, 14-Feb-2016 
 * Encoding UTF-8
 * File Name UserLogon.java
 */

@WebFilter (filterName = "filterUserLogon", urlPatterns = {"/administrador/*", "/aluno/*", "/assistente/*"})
public class UserLogon implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
        HttpSession session = ((HttpSession)((HttpServletRequest) request).getSession());
        HttpServletResponse resp = ((HttpServletResponse) response);
        
        HttpServletRequest req = ((HttpServletRequest) request);
        String path = req.getContextPath();
        
        
        User user = (User) session.getAttribute("user");
        if(user == null){
            resp.sendRedirect(path + "/index.jsp");
        }
        
//        if(session != null && !session.isNew()){
//            chain.doFilter(request, response);
//        }else{
//            resp.sendRedirect("/index.jsp");
//        }
//        chain.doFilter(request, response);
        
//        User user = (User) session.getAttribute("user");
//        if(user == null){
//            resp.sendRedirect("index.jsp");
//        }
    }

    @Override
    public void destroy() {}
    
}
