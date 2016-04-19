/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.actions.floor;

import io.github.jass2125.sistema.alocacao.core.actions.holiday.DeleteHolidayAction;
import io.github.jass2125.sistema.alocacao.core.business.User;
import io.github.jass2125.sistema.alocacao.core.dao.FloorDao;
import io.github.jass2125.sistema.alocacao.core.factory.Factory;
import io.github.jass2125.sistema.alocacao.core.factory.FactoryDao;
import io.github.jass2125.sistema.alocacao.core.util.Action;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Anderson Souza
 */
public class DeleteFloorAction implements Action {

    private Factory factory;
    private FloorDao dao;

    public DeleteFloorAction() {
        factory = new FactoryDao();
        dao = factory.createFloorDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        try {
            String id = request.getParameter("idFloor");
            Long idHoliday = Long.parseLong(id);
            /* Drop cascade */
            dao.delete(idHoliday);
            request.getSession().setAttribute("listHolidays", dao.getListFloor());
            return user.getRole() + "/gerenciarferiado.jsp";
        } catch (SQLException | NumberFormatException | ClassNotFoundException e) {
            session.setAttribute("error", "Ocorreu um erro ao exlcuir o registro.");
            e.printStackTrace();
            return user.getRole() + "/gerenciarbloco.jsp";
            
        }
    }
}
