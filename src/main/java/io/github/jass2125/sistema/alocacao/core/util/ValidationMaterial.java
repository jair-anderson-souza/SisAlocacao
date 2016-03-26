/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.util;

import io.github.jass2125.sistema.alocacao.core.business.Material;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Anderson Souza
 */
public class ValidationMaterial {

    public boolean validateDescription(String description) {
        if (description.trim().isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[a-zA-Zá-úÁ-ÚÀ-Úà-ùâ-ûä-üã-ũç$@#-_\\s]{0,50}$");
        Matcher mat = pattern.matcher(description);
        return mat.find();
    }

    public boolean validateQuantity(int quantinty) {
        return quantinty > 0;
    }

    public boolean validateMaterial(Material material) {
       return validateDescription(material.getDescription()) && validateQuantity(material.getQuantity());
    }

}
