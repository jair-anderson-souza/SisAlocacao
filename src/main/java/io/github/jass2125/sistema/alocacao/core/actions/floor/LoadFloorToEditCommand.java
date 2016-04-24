/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.actions.floor;

import io.github.jass2125.sistema.alocacao.core.business.Floor;
import io.github.jass2125.sistema.alocacao.core.business.User;
import io.github.jass2125.sistema.alocacao.core.dao.FloorDao;
import io.github.jass2125.sistema.alocacao.core.factory.Factory;
import io.github.jass2125.sistema.alocacao.core.factory.FactoryDao;
import io.github.jass2125.sistema.alocacao.core.util.Command;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Anderson Souza
 */
public class LoadFloorToEditCommand implements Command  {

    private Factory factory;
    private FloorDao dao;

    public LoadFloorToEditCommand() {
        factory = new FactoryDao();
        dao = factory.createFloorDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        try {
            Long idFloor = Long.parseLong(request.getParameter("idFloor"));
            Floor floor = dao.findById(idFloor);
            request.getSession().setAttribute("floorToEdit", floor);
            return user.getRole() + "/editarbloco.jsp";
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            //mandar mensagem de erros
            request.getSession().setAttribute("error", "O bloco não pode ser carregado.");
            return user.getRole() + "/gerenciarbloco.jsp";

        }
    }

}
