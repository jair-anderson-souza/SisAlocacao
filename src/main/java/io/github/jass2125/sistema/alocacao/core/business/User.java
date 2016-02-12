/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.sistema.alocacao.core.business;

import java.io.Serializable;

/**
 * CLasse que representa o Usuario
 * @author Anderson Souza
 * @since 2015
 */
public class User implements Serializable {
    private int idUser;
    private String name;
    private String email;
    private String username;
    private String password;
    private String registry;
    private String role;
    private boolean status;

    public User(int idUser, String name, String username, String password, String email, String registry, String role, boolean status) {
        this(name, username, password, email, registry, role, status);
        this.idUser = idUser;
    }
    
    public User(String name, String username, String password, String email, String registry, String role, boolean status) {
        this.email = email;
        this.username = username;
        this.name = name;
        this.password = password;
        this.registry = registry;
        this.role = role;
        this.status = status;
    }
    
    public User(){
    }
    /**
     * Metodo que retorna o Id do usuario
     * @return int Int
     */
    public int getIdUser() {
        return idUser;
    }
    
    /**
     * Metodo que retorna o email do usuario
     * @return email String
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Metodo que altera o email do usario
     * @param email String
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * Metodo que retorna o username do usuario
     * @return username String
     */
    public String getUsername() {
        return username;
    }
    /**
     * Metodo que altera o username do usario
     * @param username String
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * Metodo que retorna a senha do usuario
     * @return password String
     */
    public String getPassword() {
        return this.password;
    }
    
    /**
     * Metodo que altera o password do usario
     * @param password String
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    /**
     * Metodo que retorna a matricula do usuario
     * @return registry String
     */
    public String getRegistry() {
        return this.registry;
    }
    /**
     * Metodo que altera a matricula do usario
     * @param registry String
     */
    public void setRegistry(String registry) {
        this.registry = registry;
    }

    /**
     * Metodo que retorna o papel do usuario
     * @return papel String
     */
    public String getRole() {
        return this.role;
    }
    
    /**
     * Metodo que altera o papel do usario
     * @param role String
     */
    public void setRole(String role) {
        this.role = role;
    }
    
    /**
     * Metodo que retorna o status do usuario
     * @return status Boolean
     */
    public boolean isStatus() {
        return status;
    }
    
    /**
     * Metodo que altera o status do usario
     * @param status String
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    /**
     * Metodo que retorna o nome do usuario
     * @return nome String
     */
    public String getName() {
        return this.name;
    }
}
