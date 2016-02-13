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
import io.github.jass2125.sistema.alocacao.core.util.CryptographerPasswordSHA;
import io.github.jass2125.sistema.alocacao.core.util.CryptographyPasswordStrategy;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe que atua como Action, recebe a solicitação para cadastrar um novo
 * ususário
 *
 * @author Anderson Souza
 * @since 2015
 */
public class RegisterUserCommand implements Command {
//    private ValidacaoUsuarioTemplate validacao;

    private CryptographyPasswordStrategy cryptographer;

    public RegisterUserCommand() {
//        validacao = new ValidacaoUsuario();
        cryptographer = new CryptographerPasswordSHA();
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
            Factory factory = new FactoryDao();
            IUserDao dao = factory.createUserDao();
            User user = dao.findByUsernameOrEmail(username, email);

            if (user == null) {
                String name = request.getParameter("name");
                String password = request.getParameter("password");
                password = cryptographer.cryptographerSHA(password);
                String registry = request.getParameter("registry");
                String role = request.getParameter("role");
                user = new User(name, username, password, email, registry, role, true);
                dao.add(user);
            }
            request.getSession().setAttribute("insertion", "Usuario cadastrado com sucesso");
            return "administrador/gerenciarusuario.jsp";

        } catch (SQLException e) {
        } catch (ClassNotFoundException ex) {
        } catch (NoSuchAlgorithmException ex) {
        } catch (UnsupportedEncodingException ex) {
        }
        return null;
    }
}
