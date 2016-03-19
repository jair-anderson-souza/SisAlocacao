/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.actions.material;

import io.github.jass2125.sistema.alocacao.core.business.Material;
import io.github.jass2125.sistema.alocacao.core.dao.IMaterialDao;
import io.github.jass2125.sistema.alocacao.core.dao.MaterialDao;
import io.github.jass2125.sistema.alocacao.core.util.Action;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anderson Souza
 */
public class EditMaterialAction implements Action {

    private IMaterialDao dao;

    public EditMaterialAction() {
        dao = new MaterialDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            String description = request.getParameter("description");
            Integer quantity = Integer.parseInt(request.getParameter("description"));
            Integer tombamento = Integer.parseInt(request.getParameter("tombamento"));
            Material material = dao.findById(tombamento);
            material.setDescription(description);
            material.setQuantity(quantity);
            dao.update(material);
            return "administrador/gerenciarmaterial.jsp";
        } catch (SQLException | ClassNotFoundException e) {
            return "error.jsp";
        }
    }

}
