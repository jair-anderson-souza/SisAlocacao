/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.actions.events;

import io.github.jass2125.sistema.alocacao.core.business.Event;
import io.github.jass2125.sistema.alocacao.core.business.User;
import io.github.jass2125.sistema.alocacao.core.dao.EventDao;
import io.github.jass2125.sistema.alocacao.core.factory.Factory;
import io.github.jass2125.sistema.alocacao.core.factory.FactoryDao;
import io.github.jass2125.sistema.alocacao.core.util.Action;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Anderson Souza
 */
public class RegisterEventAction implements Action {

    private Factory factory;
    private EventDao dao;
    

    public RegisterEventAction() {
        factory = new FactoryDao();
        dao = factory.createEventDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        try {
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            Integer number = Integer.parseInt(request.getParameter("number"));
            Long responsable = Long.parseLong(request.getParameter("responsable"));
            Timestamp begin = Timestamp.valueOf(request.getParameter("begin"));
            Timestamp end = Timestamp.valueOf(request.getParameter("end"));
            Event event = new Event(name, description, number, responsable, begin, end);
            dao.add(event);
            return user.getRole() + "/gerenciarevento.jsp";
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return user.getRole() + "/gerenciarevento.jsp";
        }
    }

}
