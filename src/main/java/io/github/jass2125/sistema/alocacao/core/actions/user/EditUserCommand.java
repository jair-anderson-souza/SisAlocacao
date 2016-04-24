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
public class EditUserCommand implements Command  {

    private CryptographyPasswordStrategy cryptographer;
    private ValidationUserTemplate validator;

    public EditUserCommand() {
        validator = new ValidationUser();
        cryptographer = new CryptographerPasswordSHA();
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
        try {
            HttpSession session = request.getSession();
            int idUser = Integer.parseInt(request.getParameter("idUser"));
            String email = request.getParameter("email");
            String username = request.getParameter("username");
            String name = request.getParameter("name");
            String password = request.getParameter("password");

            String registry = request.getParameter("registry");
            String role = request.getParameter("role");
            User user = new User(idUser, name, username, password, email, registry, role, true);
            validator.validatorDataUser(user);
            password = cryptographer.cryptographerSHA(password);
            Factory factory = new FactoryDao();
            UserDao dao = factory.createUserDao();
            dao.edit(user);
            session.setAttribute("listUsers", dao.list(((User) session.getAttribute("user")).getIdUser()));
            return "administrador/gerenciarusuario.jsp";
        } catch (SQLException | ClassNotFoundException | NoSuchAlgorithmException | UnsupportedEncodingException | RegexException e) {
            e.printStackTrace();
            return "error.jsp";
        }catch(FieldEmptyException e){
            e.printStackTrace();
            return "error.jsp";
        }
    }
}
