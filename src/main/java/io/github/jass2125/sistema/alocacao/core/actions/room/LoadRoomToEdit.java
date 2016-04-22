/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.actions.room;

import io.github.jass2125.sistema.alocacao.core.business.Room;
import io.github.jass2125.sistema.alocacao.core.business.User;
import io.github.jass2125.sistema.alocacao.core.dao.RoomDao;
import io.github.jass2125.sistema.alocacao.core.factory.Factory;
import io.github.jass2125.sistema.alocacao.core.util.Action;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Anderson Souza
 */
public class LoadRoomToEdit implements Action {

    private Factory factory;
    private RoomDao dao;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        try {
            Long id = Long.parseLong(request.getParameter("id"));
            Room room = dao.findById(id);
            request.getSession().setAttribute("room", room);
            return user.getRole() + "/editarsala.jsp";
        } catch (SQLException | ClassNotFoundException e) {
            request.getSession().setAttribute("error", "Erro, retorne e tente novamente!!");
            return user.getRole() + "/editarsala.jsp";
        }
    }

}
