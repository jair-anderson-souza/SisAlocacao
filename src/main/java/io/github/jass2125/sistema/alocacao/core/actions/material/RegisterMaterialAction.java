/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.actions.material;

import io.github.jass2125.sistema.alocacao.core.business.Material;
import io.github.jass2125.sistema.alocacao.core.business.User;
import io.github.jass2125.sistema.alocacao.core.dao.MaterialDao;
import io.github.jass2125.sistema.alocacao.core.factory.Factory;
import io.github.jass2125.sistema.alocacao.core.factory.FactoryDao;
import io.github.jass2125.sistema.alocacao.core.util.Action;
import io.github.jass2125.sistema.alocacao.core.util.ValidationMaterial;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anderson Souza
 */
public class RegisterMaterialAction implements Action {

    private final Factory factory;
    private final MaterialDao dao;
    private final ValidationMaterial val;

    public RegisterMaterialAction() {
        factory = new FactoryDao();
        dao = factory.createMaterialDao();
        val = new ValidationMaterial();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        try {//validar, no maximo 50 caracteres 
            String description = request.getParameter("description");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            Material material = new Material(description, quantity);

            boolean result = val.validateMaterial(material);

            if (result) {
                dao.add(material);

                List<Material> listMaterials = dao.listMaterial();
                request.getSession().setAttribute("listMaterial", listMaterials);
                return user.getRole() + "/gerenciarmaterial.jsp";
            }
            request.getSession().setAttribute("error", "Maximo de 50 caracteres no nome do material");
            return user.getRole() + "/gerenciarmaterial.jsp";
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return user.getRole() + "/gerenciarmaterial.jsp";
        }
    }
}
