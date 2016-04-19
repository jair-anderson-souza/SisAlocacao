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
<<<<<<< HEAD

            String nameFloor = request.getParameter("floorName");
            if (! nameFloor.trim().isEmpty()) {
                Floor floor = new Floor(nameFloor);
                dao.add(floor);
                List<Floor> listFloors = dao.getListFloor();
                session.setAttribute("listFloors", listFloors);
                return user.getRole() + "/gerenciarbloco.jsp";
            }
            session.setAttribute("error", "O nome do bloco não pode estar em branco!");
            return user.getRole() + "/gerenciarbloco.jsp";
=======
            String description = request.getParameter("description");
            Floor floor = new Floor();
            floor.setDescription(description);
            dao.add(floor);
            return "gerenciarbloco.jsp";

>>>>>>> parent of 480ff26... Visao de Cadastro de bloco
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return "gerenciarbloco.jsp";
        }
    }

}
