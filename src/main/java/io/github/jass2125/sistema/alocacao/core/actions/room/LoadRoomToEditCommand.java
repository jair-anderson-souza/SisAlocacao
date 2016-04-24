/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.actions.room;

import io.github.jass2125.sistema.alocacao.core.business.Room;
import io.github.jass2125.sistema.alocacao.core.business.User;
import io.github.jass2125.sistema.alocacao.core.dao.FloorDao;
import io.github.jass2125.sistema.alocacao.core.dao.RoomDao;
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
public class LoadRoomToEditCommand implements Command  {

    private Factory factory;
    private RoomDao dao;
    private FloorDao daoFloor;

    public LoadRoomToEditCommand() {
        factory = new FactoryDao();
        dao = factory.createRoomDao();
        daoFloor = factory.createFloorDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        try {
            String id = request.getParameter("id");
            Long idRoom = Long.parseLong(id);
            Room room = dao.findById(idRoom);
            request.getSession().setAttribute("room", room);
            request.getSession().setAttribute("floors", daoFloor.getListFloor());
            return user.getRole() + "/editarsala.jsp";
        } catch (SQLException | ClassNotFoundException e) {
            request.getSession().setAttribute("error", "Erro, retorne e tente novamente!!");
            e.printStackTrace();
            return user.getRole() + "/editarsala.jsp";
        }
    }

}
