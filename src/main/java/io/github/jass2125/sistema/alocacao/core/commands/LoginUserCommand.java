/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.sistema.alocacao.core.commands;

import io.github.jass2125.sistema.alocacao.core.business.User;
import io.github.jass2125.sistema.alocacao.core.dao.IUserDao;
import io.github.jass2125.sistema.alocacao.core.factory.Factory;
import io.github.jass2125.sistema.alocacao.core.factory.FactoryDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Classe que atua como Action, recebe a solicitação para efetuar o login do ususário
 * @author Anderson Souza
 * @since 2015
 */


public class LoginUserCommand implements Command {
    
    /**
     * Método por executar a ação de carregar feriado pra edição
     * @param request Parametro que corresponde a requisição do usuário
     * @param response Parametro que corresponde a resposta a ser retornada
     * @return String Nome da pagina ao qual a aplicação será encaminhada
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try{
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            
            Factory factory = new FactoryDao();
            IUserDao dao = factory.createUserDao();
            
            User user = dao.findByLoginAndPassword(login, password);
            HttpSession session = request.getSession();
            
            if (user != null) {
                session.setAttribute("user", user);
                session.setMaxInactiveInterval(60 * 60);
                return user.getRole() + "/home.jsp"; // Redirect to home page.
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
