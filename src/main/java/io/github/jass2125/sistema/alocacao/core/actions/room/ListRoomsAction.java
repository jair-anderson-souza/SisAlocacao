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
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anderson Souza
 */
public class ListRoomsAction implements Action {

    private Factory factoy;
    private RoomDao dao;

    public ListRoomsAction() {
        factoy = new FactoryDao();
        dao = factoy.createRoomDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Room> listRooms = dao.listRooms();
            request.getSession().setAttribute("rooms", listRooms);
            return "gerenciarsala.jsp";
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return "gerenciarsala.jsp";
        }

    }

}
