/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.actions.room;

import io.github.jass2125.sistema.alocacao.core.business.Floor;
import io.github.jass2125.sistema.alocacao.core.business.Room;
import io.github.jass2125.sistema.alocacao.core.business.User;
import io.github.jass2125.sistema.alocacao.core.dao.FloorDao;
import io.github.jass2125.sistema.alocacao.core.dao.RoomDao;
import io.github.jass2125.sistema.alocacao.core.factory.Factory;
import io.github.jass2125.sistema.alocacao.core.factory.FactoryDao;
import io.github.jass2125.sistema.alocacao.core.util.Action;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Anderson Souza
 */
public class RegisterRoomAction implements Action {

    private Factory factory;
    private RoomDao dao;
    private FloorDao daoFloor;

    public RegisterRoomAction() {
        factory = new FactoryDao();
        dao = factory.createRoomDao();
        daoFloor = factory.createFloorDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        try {
            String nameRoom = request.getParameter("nameRoom");
            Long floor = Long.parseLong(request.getParameter("floor"));
            Integer capacity = Integer.parseInt(request.getParameter("capacity"));
            String typeRoom = request.getParameter("typeRoom");
            Room room = new Room(nameRoom, floor, capacity, typeRoom);
            dao.add(room);
            List<Room> listRooms = dao.listRooms();
            List<Floor> listFloor = daoFloor.getListFloor();
            request.getSession().setAttribute("rooms", listRooms);
            request.getSession().setAttribute("floors", listFloor);
            return user.getRole() + "/gerenciarsala.jsp";
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return user.getRole() + "/gerenciarsala.jsp";
        }
    }

}
