/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.sistema.alocacao.core.actions.user;

import io.github.jass2125.sistema.alocacao.core.business.User;
import io.github.jass2125.sistema.alocacao.core.dao.UserDao;
import io.github.jass2125.sistema.alocacao.core.factory.Factory;
import io.github.jass2125.sistema.alocacao.core.factory.FactoryDao;
import io.github.jass2125.sistema.alocacao.core.util.Command;
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
public class LoadUserEditionCommand implements Command  {
    private String role;
    /**
     * Método que efetua o carregameto de um usuario da base de dados
     * @param request Requisição
     * @param response Resposta
     * @return String Retorna a pagina para qual a aplicação será encaminhada
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        this.role = (String) ((User) session.getAttribute("user")).getRole();
        try{
           String id = request.getParameter("idUser");
            int idUser = Integer.parseInt(id);
            Factory factory = new FactoryDao();
            UserDao dao = factory.createUserDao();
            User user = dao.findById(idUser);
            
            if(user != null) {
                session.setAttribute("userEditing", user);
                return this.role + "/editarusuario.jsp";
            } else {
                session.setAttribute("error", "Não foi possivel realizar a operação, tente novamente.");
                return this.role + "/gerenciarusuario.jsp";
            }
        } catch(NumberFormatException | SQLException e) {
            e.printStackTrace();
            request.getSession().setAttribute("error", "Ocorreu um problema. Verifique os campos e tente novamente.");
            return "error.jsp";
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoadUserEditionCommand.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            return "error.jsp";
        }
    }

}
