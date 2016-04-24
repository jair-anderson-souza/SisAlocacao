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
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Anderson Souza
 */
public class EditFloorCommand implements Command {

    private Factory factory;
    private FloorDao dao;

    public EditFloorCommand() {
        factory = new FactoryDao();
        dao = factory.createFloorDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        try {
            Long idFloor = Long.parseLong(request.getParameter("idFloor"));
            String description = request.getParameter("description");
            Floor floor = new Floor(idFloor, description);
            dao.update(floor);
            List<Floor> listFloors = dao.getListFloor();
            session.setAttribute("listFloors", listFloors);
            return user.getRole() + "/gerenciarbloco.jsp";
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            session.setAttribute("error", "Erro ao editar o bloco.");
            return user.getRole() + "/gerenciarbloco.jsp";
        }
    }

}
