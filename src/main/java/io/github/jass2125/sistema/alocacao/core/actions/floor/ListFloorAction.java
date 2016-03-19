/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.actions.floor;

import io.github.jass2125.sistema.alocacao.core.business.Floor;
import io.github.jass2125.sistema.alocacao.core.dao.FloorDao;
import io.github.jass2125.sistema.alocacao.core.dao.FloorDaoImpl;
import io.github.jass2125.sistema.alocacao.core.util.Action;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anderson Souza
 */
public class ListFloorAction implements Action {

    private FloorDao dao;

    public ListFloorAction() {
        dao = new FloorDaoImpl();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Floor> listFloors = dao.getListFloor();
            return "gerenciarbloco.jsp";
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return "gerenciarbloco.jsp";
        }
    }

}
