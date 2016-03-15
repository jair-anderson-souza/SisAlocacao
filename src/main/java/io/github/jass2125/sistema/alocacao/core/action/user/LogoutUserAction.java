/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.sistema.alocacao.core.action.user;

import io.github.jass2125.sistema.alocacao.core.util.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Classe que atua como Action, recebe a solicitação para realizar o logout do usuario
 * @author Anderson Souza
 * @since 2015
 */
public class LogoutUserAction implements Action {

    /**
     * Método por executar a ação de logout na aplicação
     * @param request Parametro que corresponde a requisição do usuário
     * @param response Parametro que corresponde a resposta a ser retornada
     * @return String Nome da pagina ao qual a aplicação será encaminhada
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.invalidate();        
        return "index.jsp";
        
    }

}
