/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.sistema.alocacao.core.util;

import io.github.jass2125.sistema.alocacao.core.business.User;
import io.github.jass2125.sistema.alocacao.exceptions.RegexException;


/**Classe abstrata responsavel por definir o tipo de validação do usuario
 *
 * @author Anderson Souza
 * @since 2015
 */
public abstract class ValidationUserTemplate {
    
    /**
     * Método responsavel por validar o username do usuario 
     * @param username Username do usuario
     * @throws RegexException Padrao de entrada invalido
     */
    public abstract void validatorUsername(String username) throws RegexException;
    
    /**Método responsavel por validar a senha do usuario 
     * @param password Senha do usuario
     * @throws RegexException Padrao de entrada invalido
     */
    public abstract void validatorPassword(String password) throws RegexException;
    /**
     * Metpdp responsavel por validar o email do usuario
     * @param email Email do usuario
     * @throws RegexException Padrao de entrada invalido
     */
    public abstract void validatorEmail(String email) throws RegexException;
    
    /**Metodo responsavel por validar a matricula do usuario
     * @param registry Matricula do usuario
     * @throws RegexException Padrao de entrada invalido
     */
    public abstract void validatorRegistry(String registry) throws RegexException;
    
    /**
     * Metodo responsavel por invocar a validaçao completa do usuario
     * @param user User
     * @throws RegexException Padrao de entrada invalido
     */
    public void validatorDataUser(User user) throws RegexException {
        this.validatorEmail(user.getEmail());
        this.validatorUsername(user.getUsername());
        this.validatorPassword(user.getPassword());
        this.validatorRegistry(user.getRegistry());
    }
    
}
