/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.actions.user;

import io.github.jass2125.sistema.alocacao.core.business.User;
import io.github.jass2125.sistema.alocacao.core.dao.UserDao;
import io.github.jass2125.sistema.alocacao.core.exceptions.FieldEmptyException;
import io.github.jass2125.sistema.alocacao.core.exceptions.RegexException;
import io.github.jass2125.sistema.alocacao.core.factory.Factory;
import io.github.jass2125.sistema.alocacao.core.factory.FactoryDao;
import io.github.jass2125.sistema.alocacao.core.util.Command;
import io.github.jass2125.sistema.alocacao.core.util.CryptographerPasswordSHA;
import io.github.jass2125.sistema.alocacao.core.util.CryptographyPasswordStrategy;
import io.github.jass2125.sistema.alocacao.core.util.ValidationUser;
import io.github.jass2125.sistema.alocacao.core.util.ValidationUserTemplate;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Classe que edita o usuário
 *
 * @author Anderson Souza
 * @since 2015
 */
public class EditUserCommand implements Command {

    private ValidationUser validator;
    private Factory factory;
    private UserDao dao;
    private String roleUserSession;

    public EditUserCommand() {
        this.validator = new ValidationUser();
        this.factory = new FactoryDao();
        this.dao = factory.createUserDao();
    }

    /**
     * Método por executar a ação de editar usuario
     *
     * @param request Requisição
     * @param response Resposta
     * @return String Retorna o nome da pagina a qual a aplicação será
     * encaminhada
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User userSession = (User) session.getAttribute("user");
        this.roleUserSession = userSession.getRole();
        try {
            /* Pegando parametros */
            int idUser = Integer.parseInt(request.getParameter("idUser"));
            String email = request.getParameter("email");
            String username = request.getParameter("username");
            String name = request.getParameter("name");
            String registry = request.getParameter("registry");
            String role = request.getParameter("role");
            User user = new User(idUser, name, username, email, registry, role, true);
            validator.validatorEmail(email);
            validator.validatorRegistry(registry);
            validator.validatorUsername(username);
                        
            dao.edit(user);
            session.setAttribute("listUsers", dao.list(userSession.getIdUser()));
            return this.roleUserSession + "/gerenciarusuario.jsp";
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            request.getSession().setAttribute("error", "Verifique os dados e tente novamente.");
            return this.roleUserSession + "/gerenciarusuario.jsp";
        } catch (FieldEmptyException | RegexException e) {
            e.printStackTrace();
            request.getSession().setAttribute("error", e.getMessage());
            return this.roleUserSession + "/gerenciarusuario.jsp";
        }
    }
}
