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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anderson Souza
 */
public class RegisterMaterial implements Action {

    private IMaterialDao dao;

    public RegisterMaterial() {
        dao = new MaterialDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        //validar, no maximo 50 caracteres 
        String description = request.getParameter("description");
        //validar tamanho
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        //
        int tombamento = Integer.parseInt(request.getParameter("tombamento"));

        String status = request.getParameter("status");

        String materialRoom = request.getParameter("materialRoom");

//        Material material = new Material(description, quantity, tombamento, status, materialRoom);
//
//        dao.add(material);
        
        return null;

    }

}
