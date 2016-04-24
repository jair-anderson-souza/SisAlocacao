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
import io.github.jass2125.sistema.alocacao.core.util.CryptographerPasswordSHA;
import io.github.jass2125.sistema.alocacao.core.util.CryptographyPasswordStrategy;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Classe que atua como Action, recebe a solicitação para efetuar o login do
 * ususário
 *
 * @author Anderson Souza
 * @since 2015
 */
public class LoginUserCommand implements Command {

    private CryptographyPasswordStrategy cryptographer;
    private String role;
    private Factory factory;
    private UserDao dao;

    public LoginUserCommand() {
        cryptographer = new CryptographerPasswordSHA();
        factory = new FactoryDao();
        dao = factory.createUserDao();
    }

    /**
     * Método por executar a ação de carregar feriado pra edição
     *
     * @param request Parametro que corresponde a requisição do usuário
     * @param response Parametro que corresponde a resposta a ser retornada
     * @return String Nome da pagina ao qual a aplicação será encaminhada
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            String login = request.getParameter("login");
            String password = request.getParameter("password");

            password = cryptographer.cryptographerSHA(password);
            User user = dao.findByLoginAndPassword(login, password);
            HttpSession session = request.getSession();

            if (user != null) {
                session.setAttribute("user", user);
                session.setMaxInactiveInterval(60 * 60);
                role = (String) ((User) request.getSession().getAttribute("user")).getRole();
                return this.role + "/home.jsp";
            } else {
                session.setAttribute("error", "Usuario e senha desconhecidos. Por favor, tente novamente.");
                return "index.jsp";
            }
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            request.getSession().setAttribute("error", "Ocorreu um erro, por favor tente novamente.");
            return "index.jsp";

        }

    }

}
