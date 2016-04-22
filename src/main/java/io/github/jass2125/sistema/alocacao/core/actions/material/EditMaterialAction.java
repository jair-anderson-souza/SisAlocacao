/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.actions.material;

import io.github.jass2125.sistema.alocacao.core.business.Material;
import io.github.jass2125.sistema.alocacao.core.dao.MaterialDao;
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
public class EditMaterialAction implements Action {

    private Factory factory;
    private MaterialDao dao;

    public EditMaterialAction() {
        factory = new FactoryDao();
        dao = factory.createMaterialDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            String description = request.getParameter("description");
            Integer quantity = Integer.parseInt(request.getParameter("quantity"));
            Integer tombamento = Integer.parseInt(request.getParameter("tombamento"));
            Material material = dao.findById(tombamento);
            material.setDescription(description);
            material.setQuantity(quantity);
            dao.update(material);
            request.getSession().setAttribute("listMaterial", dao.listMaterial());
            return "administrador/gerenciarmaterial.jsp";
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return "error.jsp";
        }
    }

}
