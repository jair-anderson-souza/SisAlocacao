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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Classe que efetua o carregamento de um usuario 
 * @author Anderson Souza
 * @since 2015
 */
public class LoadUserEditionCommand implements Command {

    /**
     * Método que efetua o carregameto de um usuario da base de dados
     * @param request Requisição
     * @param response Resposta
     * @return String Retorna a pagina para qual a aplicação será encaminhada
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try{
            String id = request.getParameter("idUser");
            int idUser = Integer.parseInt(id);
            
            Factory factory = new FactoryDao();
            IUserDao dao = factory.createUserDao();
            User user = dao.findById(idUser);
            
            if(user != null){
                HttpSession session = request.getSession();
                session.setAttribute("userEditing", user);
                return "administrador/editarusuario.jsp";
            }else{
                request.setAttribute("error", "Ocorreu um problema. Verifique os campos e tente novamente.");
                return "/pages/home";
            }
        }catch(NumberFormatException | SQLException e){
            request.setAttribute("error", "Ocorreu um problema. Verifique os campos e tente novamente.");
            e.printStackTrace();
            return "/pages/home";
        }
    }

}