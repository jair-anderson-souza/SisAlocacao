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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anderson Souza
 */
public class RegisterMaterialAction implements Action {

    private Factory factory;
    private MaterialDao dao;

    public RegisterMaterialAction() {
        factory = new FactoryDao();
        dao = factory.createMaterialDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        try {//validar, no maximo 50 caracteres 
            String description = request.getParameter("description");
            boolean ver = this.validationDescription(description);

            //validar tamanho
            if (ver) {
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                Material material = new Material(description, quantity);

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

//    public void validateQuantity(String description) {
//        try{
//            String regex = "";
//        }catch(){
//            
//        }
//    }
    public static boolean validationDescription(String description) {
        Pattern pattern = Pattern.compile("^[a-zA-Zá-úÁ-ÚÀ-Úà-ùâ-ûä-üã-ũ$@#-_\\s]{0,50}$"); 
//        Pattern pattern = Pattern.compile("/^[a-z]{1,50}$/"); 
//        Pattern pattern = Pattern.compile("^\\w{0,50}$"); 
        Matcher mat = pattern.matcher(description);
        return mat.find();
    }
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
