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
public class ListFloorAction implements Action {

    private Factory factory;
    private FloorDao dao;
    
    public ListFloorAction() {
        factory = new FactoryDao();
        dao = factory.createFloorDao();
    }
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        try {
            List<Floor> listFloors = dao.getListFloor();
            session.setAttribute("listFloors", listFloors);
            return user.getRole() + "/gerenciarbloco.jsp";
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return user.getRole() + "/gerenciarbloco.jsp";
        }
    }
    
}
