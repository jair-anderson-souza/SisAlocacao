/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.actions.room;

import io.github.jass2125.sistema.alocacao.core.business.Room;
import io.github.jass2125.sistema.alocacao.core.dao.RoomDao;
import io.github.jass2125.sistema.alocacao.core.factory.Factory;
import io.github.jass2125.sistema.alocacao.core.factory.FactoryDao;
import io.github.jass2125.sistema.alocacao.core.util.Action;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anderson Souza
 */
public class EditRoomAction implements Action {

    private Factory factory;
    private RoomDao dao;

    public EditRoomAction() {
        factory = new FactoryDao();
        dao = factory.createRoomDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            Long idRoom = Long.parseLong(request.getParameter("idRoom"));
            String nameRoom = request.getParameter("nameRoom");
            Long idFloor = Long.parseLong(request.getParameter("idFloor"));
            Integer capacicity = Integer.parseInt(request.getParameter("capacity"));

            String typeRoom = String.valueOf(request.getParameter("typeRoom"));
            Room room = new Room();
            dao.update(room);
            return "gerenciarsala.jsp";
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return "gerenciarsala.jsp";
        }
    }

}
