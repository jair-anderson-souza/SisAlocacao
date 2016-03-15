/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.sistema.alocacao.core.action.material;

import io.github.jass2125.sistema.alocacao.core.business.Material;
import io.github.jass2125.sistema.alocacao.core.dao.IMaterialDao;
import io.github.jass2125.sistema.alocacao.core.dao.MaterialDao;
import io.github.jass2125.sistema.alocacao.core.util.Action;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anderson Souza
 */
public class ListMaterialAction implements Action {
    private IMaterialDao dao;

    public ListMaterialAction() {
        dao = new MaterialDao();
    }
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Material> listMaterials = dao.listMaterial();
        
        return "administrador/gerenciarmaterial.jsp";
    }

}
