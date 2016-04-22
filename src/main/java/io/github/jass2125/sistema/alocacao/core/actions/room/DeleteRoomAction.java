/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.actions.room;

import io.github.jass2125.sistema.alocacao.core.business.User;
import io.github.jass2125.sistema.alocacao.core.dao.RoomDao;
import io.github.jass2125.sistema.alocacao.core.factory.Factory;
import io.github.jass2125.sistema.alocacao.core.factory.FactoryDao;
import io.github.jass2125.sistema.alocacao.core.util.Action;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Anderson Souza
 */
public class DeleteRoomAction implements Action {

    private Factory factory;
    private RoomDao dao;

    public DeleteRoomAction() {
        factory = new FactoryDao();
        dao = factory.createRoomDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        try {
            Long idRoom = Long.parseLong(request.getParameter("idRoom"));
            dao.delete(idRoom);
            request.getSession().setAttribute("rooms", dao.listRooms());
            return user.getRole() + "/gerenciarsala.jsp";
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return user.getRole() + "/gerenciarsala.jsp";
        }
    }

}
