/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.actions.floor;

import io.github.jass2125.sistema.alocacao.core.business.Floor;
import io.github.jass2125.sistema.alocacao.core.dao.FloorDao;
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
public class RegisterFloorAction implements Action {

    private Factory factory;
    private FloorDao dao;

    public RegisterFloorAction() {
        factory = new FactoryDao();
        dao = factory.createFloorDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            String description = request.getParameter("description");
            Floor floor = new Floor();
            floor.setDescription(description);
            dao.add(floor);
            return "gerenciarbloco.jsp";

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return "gerenciarbloco.jsp";
        }
    }

}
