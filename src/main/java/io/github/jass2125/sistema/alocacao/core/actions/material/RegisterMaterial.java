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
public class RegisterMaterial implements Action{

    private MaterialDao dao;

    public RegisterMaterial() {
        dao = new MaterialDaoImpl();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {//validar, no maximo 50 caracteres 
            String description = request.getParameter("description");
            //validar tamanho
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            Material material = new Material(description, quantity);

            dao.add(material);
            return "administrador/gerenciarmaterial.jsp";
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return "error.jsp";
        }
    }

//    public void validateQuantity(String description) {
//        try{
//            String regex = "";
//        }catch(){
//            
//        }
//    }
//    public static boolean validateCaracters(String login) {
//        boolean valid = true;
//        String nopodi = "ƒŠŒŽšœžŸÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞßàáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ/|.!?@#$%¨&*(){}][^~'";
//        nopodi += '"';
//        for (int j = 0; j < login.length(); j++) {
//            System.out.print("esse pode ?:" + login.charAt(j));
//            System.out.println();
//            for (int i = 0; i < nopodi.length(); i++) {
//                if (login.charAt(j) == nopodi.charAt(i)) {
//                    System.out.print("Não pode:" + nopodi.charAt(i));
//                    System.out.println();
//                    valid = false;
//                    if (!valid) {
//                        break;
//                    }
//                }
//            }
//        }
//        return valid;
//    }
//
//    public static void main(String[] args) {
//        // digite a string a ser testada na variavel login
//        String login = "marc/elo";
//
//        boolean testeLogin = false;
//        testeLogin = RegisterMaterial.validateCaracters(login);
//        if (testeLogin) {
//            System.out.println("passou");
//        } else {
//            System.out.println("falhou - nao sao permitidos caracteres especiais");
//        }
//    }
}
