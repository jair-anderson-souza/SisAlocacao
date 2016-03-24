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
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Anderson Souza
 */
public class ListMaterialAction implements Action {

    private Factory factory;
    private MaterialDao dao;

    public ListMaterialAction() {
        factory = new FactoryDao();
        dao = factory.createMaterialDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        try {
            List<Material> listMaterials = dao.listMaterial();
            request.getSession().setAttribute("listMaterial", listMaterials);
            return user.getRole() + "/gerenciarmaterial.jsp";
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            request.getSession().setAttribute("error", "Erro, retorne e tente novamente!");
            return user.getRole() + "/home.jsp";
        }
    }

}
