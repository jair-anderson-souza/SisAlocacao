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

/**
 * Classe que atua como Action, recebe a solicitação para cadastrar um novo ususário
 *
 * @author Anderson Souza
 * @since 2015
 */
public class RegisterUserCommand implements Command {
//    private ValidacaoUsuarioTemplate validacao;

    public RegisterUserCommand() {
//        validacao = new ValidacaoUsuario();
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
            Factory factory = new FactoryDao();
            IUserDao dao = factory.createUserDao();
            String username = request.getParameter("username");
            User user = dao.findByUsernameOrEmail(username, email);

            String nome = request.getParameter("nome");
            String senha = request.getParameter("password");

            String matricula = request.getParameter("matricula");
            String papel = request.getParameter("papel");

            User usuario = new User(username, nome, senha, email, matricula, papel, true);
//                this.validacao.validaDadosDoUsuario(usuario);

            dao.add(usuario);
            request.setAttribute("insercao", "Usuario cadastrado com sucesso");
            return "/administrador/home.jsp";

        } catch (SQLException e) {
            return "/pages/home";
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegisterUserCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
