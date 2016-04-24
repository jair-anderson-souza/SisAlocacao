/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.actions.user;

import io.github.jass2125.sistema.alocacao.core.business.User;
import io.github.jass2125.sistema.alocacao.core.dao.UserDao;
import io.github.jass2125.sistema.alocacao.core.exceptions.FieldEmptyException;
import io.github.jass2125.sistema.alocacao.core.factory.Factory;
import io.github.jass2125.sistema.alocacao.core.factory.FactoryDao;
import io.github.jass2125.sistema.alocacao.core.util.CryptographerPasswordSHA;
import io.github.jass2125.sistema.alocacao.core.util.CryptographyPasswordStrategy;
import io.github.jass2125.sistema.alocacao.core.util.ValidationUser;
import io.github.jass2125.sistema.alocacao.core.util.ValidationUserTemplate;
import io.github.jass2125.sistema.alocacao.core.exceptions.RegexException;
import io.github.jass2125.sistema.alocacao.core.util.Command;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 * Classe que atua como Action, recebe a solicitação para cadastrar um novo
 * ususário
 *
 * @author Anderson Souza
 * @since 2015
 */
public class RegisterUserCommand implements Command {

    private ValidationUserTemplate validator;
    private CryptographyPasswordStrategy cryptographer;
    private Factory factory;
    private UserDao dao;
    private String role;

    public RegisterUserCommand() {
        validator = new ValidationUser();
        cryptographer = new CryptographerPasswordSHA();
        factory = new FactoryDao();
        dao = factory.createUserDao();
    }

    /**
     * Método que executa o cadastro de um novo usuario na aplicação
     *
     * @param request Parametro que corresponde a requisição do usuário
     * @param response Parametro que corresponde a resposta a ser retornada
     * @return String Nome da pagina ao qual a aplicação será encaminhada
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            String email = request.getParameter("email");
            String username = request.getParameter("username");

            User user = dao.findByUsernameOrEmail(username, email);
            if (user == null) {
                String name = request.getParameter("name");
                String password = request.getParameter("password");
                String registry = request.getParameter("registry");
                String role = request.getParameter("role");
                user = new User(name, username, password, email, registry, role, true);
                validator.validatorDataUser(user);
                user.setPassword(cryptographer.cryptographerSHA(password));
                dao.add(user);
                HttpSession session = request.getSession();
                this.role = (String)((User)session.getAttribute("user")).getRole();
                session.setAttribute("listUsers", dao.list(((User) session.getAttribute("user")).getIdUser()));
                return this.role + "/gerenciarusuario.jsp";
            } else {
                request.getSession().setAttribute("error", "Email e/ou Username existentes");
                return "administrador/gerenciarusuario.jsp";
            }
        } catch (SQLException | ClassNotFoundException | NoSuchAlgorithmException | UnsupportedEncodingException | RegexException e) {
            e.printStackTrace();
            return "error.jsp";
        } catch (FieldEmptyException e) {
            e.printStackTrace();
            request.getSession().setAttribute("error", e.getMessage());
            return "error.jsp";
        }

    }

}
