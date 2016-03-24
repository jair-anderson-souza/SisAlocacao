/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.util;

import io.github.jass2125.sistema.alocacao.core.business.User;
import io.github.jass2125.sistema.alocacao.core.exceptions.FieldEmptyException;
import io.github.jass2125.sistema.alocacao.core.exceptions.RegexException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe que executa a validação de dados do usuario
 *
 * @author Anderson Souza
 * @since 2015
 */
public class ValidationUser extends ValidationUserTemplate {

    private String usernamePattern;
    private String passwordPattern;
    private String emailPattern;
    private String matriculaPattern;

    public ValidationUser() {
        //this.usernamePattern = "[a-zA-Z\\.]+";
        this.usernamePattern = "^[a-zA-Z0-9.]$";
        this.passwordPattern = "((?=.*[A-Z])(?=.*[@#$!%!]).{8,30})";
//        this.emailPattern = "^\\S+@\\S+\\.\\S+$";
//        Victor Hugo
        this.emailPattern = "[a-zA-Z0-9_.-]+@{1}[a-zA-Z0-9_.-]+.{1}[a-z]+";

//            this.emailPattern = "^.+\\@.+\\..+$";
        this.matriculaPattern = "^\\d{6}$";
    }

    /**
     * Método que valida o username do usuario
     *
     * @param username Username do usuario
     * @throws RegexException Padrao de entrada invalido
     * @throws FieldEmptyException
     */
    @Override
    public void validatorUsername(String username) throws RegexException, FieldEmptyException {
        Pattern regex = Pattern.compile(usernamePattern);
        Matcher matcher = regex.matcher(username);
        
        if (username.trim().isEmpty()) {
            throw new FieldEmptyException("O username deve ser preenchido!!");
        } 
        else if (!matcher.find()) {
            throw new RegexException("Não pode conter caracteres especiais (%-$_#@, números ou espaços, com exceção de ponto final.");
        }
    }

    /**
     * Método que valida a matricula do usuario
     *
     * @param password Senha do usuario
     * @throws RegexException Padrao de entrada invalido
     */
    @Override
    public void validatorPassword(String password) throws RegexException {
        Pattern regexPassword = Pattern.compile(passwordPattern);
        Matcher matcher = regexPassword.matcher(password);

        if (!matcher.find()) {
            throw new RegexException("A senha deve ter pelo menos 8 dígitos, pelo menos 1 caractere maiúsculo e pelo menos 1 caracteres não-alfabéticos (por exemplo, !, $, #, %)");
        }
    }

    /**
     * Método que valida o email do usuario
     *
     * @param email Email do usuario
     * @throws RegexException Padrao de entrada invalido
     */
    @Override
    public void validatorEmail(String email) throws RegexException {
        Pattern regexEmail = Pattern.compile(emailPattern);
        Matcher matcher = regexEmail.matcher(email);

        if (!matcher.find()) {
            throw new RegexException("Email invalido, retorne e tente novamente.");
        }
    }

    /**
     * Método que valida a matricula do usuario
     *
     * @param registry Matricula do usuario
     * @throws RegexException Padrao de entrada invalido
     */
    @Override
    public void validatorRegistry(String registry) throws RegexException {
        Pattern regexMatricula = Pattern.compile(matriculaPattern);
        Matcher matcher = regexMatricula.matcher(registry);

        if (!matcher.find()) {
            throw new RegexException("6 dígitos numéricos");
        }
    }

    /**
     * Método que invoca a validação completa do usuario
     *
     * @param user User
     * @throws RegexException Padrao de entrada invalido
     */
    @Override
    public void validatorDataUser(User user) throws RegexException, FieldEmptyException {
        this.validatorEmail(user.getEmail());
        this.validatorRegistry(user.getRegistry());
        this.validatorPassword(user.getPassword());
        this.validatorUsername(user.getUsername());
    }

}
