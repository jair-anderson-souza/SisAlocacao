/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.sistema.alocacao.core.business;

/**
 * CLasse que representa o Usuario
 * @author Anderson Souza
 * @since 2015
 */
public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String username;
    private String senha;
    private String matricula;
    private String papel;
    private boolean status;

    public Usuario(int id, String nome, String username, String senha, String email, String matricula, String papel, boolean status) {
        this(nome, username, senha, email, matricula, papel, status);
        this.id = id;
    }
    
    public Usuario(String nome, String username, String senha, String email, String matricula, String papel, boolean status) {
        this.email = email;
        this.username = username;
        this.nome = nome;
        this.senha = senha;
        this.matricula = matricula;
        this.papel = papel;
        this.status = status;
    }
    
    public Usuario(){
    }
    /**
     * Metodo que retorna o Id do usuario
     * @return int Int
     */
    public int getId() {
        return id;
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
    public String getSenha() {
        return senha;
    }
    
    /**
     * Metodo que altera o password do usario
     * @param senha String
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    /**
     * Metodo que retorna a matricula do usuario
     * @return matricula String
     */
    public String getMatricula() {
        return matricula;
    }
    /**
     * Metodo que altera a matricula do usario
     * @param matricula String
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Metodo que retorna o papel do usuario
     * @return papel String
     */
    public String getPapel() {
        return papel;
    }
    
    /**
     * Metodo que altera o papel do usario
     * @param papel String
     */
    public void setPapel(String papel) {
        this.papel = papel;
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
    public String getNome() {
        return this.nome;
    }
}
