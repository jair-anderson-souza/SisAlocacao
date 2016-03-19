/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.actions.material;

import io.github.jass2125.sistema.alocacao.core.business.Material;
import io.github.jass2125.sistema.alocacao.core.dao.MaterialDao;
import io.github.jass2125.sistema.alocacao.core.dao.MaterialDaoImpl;
import io.github.jass2125.sistema.alocacao.core.util.Action;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anderson Souza
 */
public class LoadMaterialToEditAction implements Action {

    private MaterialDao dao;

    public LoadMaterialToEditAction() {
        dao = new MaterialDaoImpl();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            
            Integer tombamento = Integer.parseInt(request.getParameter("tombamento"));
            
            Material material = dao.findById(tombamento);

            if (material != null) {
                request.getSession().setAttribute("material", material);
                return "administrador/editarmaterial.jsp";
            }
            return "administrador/home.jsp";

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return "administrador/home.jsp";
        }
    }

}
