/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.sistema.alocacao.core.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Anderson Souza  
 * @since 14:08:45, 12-Feb-2016 
 * Package io.github.jass2125.sistema.alocacao.core.commands
 * Project Name Sistema-Alocacao
 * Encoding UTF-8
 * File Name Command.java
 */
public interface Command {
    /**
     * Método que define o command 
     * @param request Parametro que corresponde a requisição do usuário
     * @param response Parametro que corresponde a resposta a ser retornada
     * @return String Retorna a pagina para qual a aplicação será encaminhada
     */
    public String execute(HttpServletRequest request, HttpServletResponse response);
}
