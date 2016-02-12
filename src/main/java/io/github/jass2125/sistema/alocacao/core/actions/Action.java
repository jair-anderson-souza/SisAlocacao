/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.sistema.alocacao.core.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interface que define as actions
 * @author Anderson Souza
 * @since 2015
 */
public interface Action {
    
    /**
     * Método que define a action 
     * @param request Requisição
     * @param response Resposta
     * @return String Retorna a pagina para qual a aplicação será encaminhada
     */
    public String execute(HttpServletRequest request, HttpServletResponse response);
    
}
