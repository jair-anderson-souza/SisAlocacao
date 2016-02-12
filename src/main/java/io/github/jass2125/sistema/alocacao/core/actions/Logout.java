/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.sistema.alocacao.core.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Classe que efetua o logout do usuario
 * @author Anderson Souza
 * @since 2015
 */
public class Logout implements Action{

    /**
     * Action que efetua o logout do usuario na aplicação
     * @param request Requisição
     * @param response Resposta
     * @return String
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        
        HttpSession session = request.getSession();
        session.invalidate();
        
        return "index.jsp";
        
    }

}
