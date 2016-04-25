/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.util;

import io.github.jass2125.sistema.alocacao.core.exceptions.FieldEmptyException;
import io.github.jass2125.sistema.alocacao.core.exceptions.RegexException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Anderson Souza
 */
public class ValidationHoliday {

    private String usernamePattern;
    private String datePattern;

    public ValidationHoliday() {
        this.usernamePattern = "^[a-zA-Zá-úÁ-ÚÀ-Úà-ùâ-ûä-üã-ũç\\s]{0,500}$";
        this.datePattern = "^([1-9]|0[1-9]|[12][0-9]|3[01])\\D([1-9]|0[1-9]|1[012])\\D(19[0-9][0-9]|20[0-9][0-9])$";
    }
    
    public void validationDescription(String description) throws FieldEmptyException, RegexException {
        Pattern regex = Pattern.compile(usernamePattern);
        Matcher matcher = regex.matcher(description);

        if (description.trim().isEmpty()) {
            throw new FieldEmptyException("A descriçao deve ser preenchido!!");
        } else if (!matcher.find()) {
            throw new RegexException("Não pode conter caracteres especiais (%-$_#@.");
        }
    }
    
    public void validationDate(String date) throws FieldEmptyException, RegexException {
        Pattern regex = Pattern.compile(datePattern);
        Matcher matcher = regex.matcher(date);

        if (date.trim().isEmpty()) {
            throw new FieldEmptyException("A data deve ser preenchido!!");
        } else if (!matcher.find()) {
            throw new RegexException("A data deve ser preenchida no seguinte padrão: dd/MM/yyyy");
        }
    }

}
