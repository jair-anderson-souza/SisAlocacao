/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.sistema.alocacao.core.actions;

import io.github.jass2125.sistema.alocacao.core.business.User;
import io.github.jass2125.sistema.alocacao.core.dao.IUserDao;
import io.github.jass2125.sistema.alocacao.core.factory.Factory;
import io.github.jass2125.sistema.alocacao.core.factory.FactoryImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Classe que atua como Action, recebe a solicitação para efetuar o login do ususário
 * @author Anderson Souza
 * @since 2015
 */


public class LoginUsuario implements Action {
    
    /**
     * Método por executar a ação de carregar feriado pra edição
     * @param request Parametro que corresponde a requisição do usuário
     * @param response Parametro que corresponde a resposta a ser retornada
     * @return String Nome da pagina ao qual a aplicação será encaminhada
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try{
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            Factory factory = new FactoryImpl();
            IUserDao dao = factory.createUserDao();
            
            User usuario = dao.findByUsernameAndPassword(username, password);
            HttpSession session = request.getSession();
            
            if (usuario != null) {
                session.setAttribute("usuario", usuario);
                session.setMaxInactiveInterval(60 * 60);
                return usuario.getRole() + "/home.jsp"; // Redirect to home page.
            } else {
                session.setAttribute("error", "Usuario e senha desconhecidos. Por favor, tente novamente."); 
                return "index.jsp"; 
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
}
