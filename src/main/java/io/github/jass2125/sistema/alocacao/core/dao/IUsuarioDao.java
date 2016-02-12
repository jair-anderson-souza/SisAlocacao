/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.sistema.alocacao.core.dao;


import io.github.jass2125.sistema.alocacao.core.business.Usuario;
import java.sql.SQLException;
import java.util.Set;

/**
 * Interface do DAO de usuario
 * @author Anderson Souza
 * @since 2015
 */
public interface IUsuarioDao {
    /**
     * Metodo abstrato que adiciona um usuario
     * @param usuario Usuario
     * @throws SQLException IUsuarioDao
     */
    public void add(Usuario usuario) throws SQLException;
    
    /**
     * Metodo abstrato que edita um usuario
     * @param usuario IUsuario
     * @throws SQLException UsuarioDao
     */
    public void edit(Usuario usuario) throws SQLException;
        
    /**
     * Metodo abstrato que busca um feriado pelo seu username e password
     * @param username Username do usuario
     * @param password Password do usuario
     * @return usuario IUsuario
     * @throws SQLException UsuarioDao
     */
    public Usuario find(String username, String password) throws SQLException, ClassNotFoundException;
    
    /**
     * Metodo abstrato que retorna um Set de usuarios
     * @param idUsuario Id de usuario
     * @return list Set
     * @throws SQLException IUsuarioDao
     */
    public Set<Usuario> list(int idUsuario) throws SQLException;
    
    /**
     * Metodo abstrato que exclui um usuario pelo seu identificador
     * @param idUsuario Id de usuario
     * @throws SQLException IUsuarioDao
     */
    public void delete(int idUsuario) throws SQLException;
    
    /**
     * Metodo abstrato que busca um usuario pelo seu identificador
     * @param id Id de Usuario
     * @return Usuario usuario
     * @throws SQLException IUsuarioDao
     */
    public Usuario find(int id) throws SQLException;
    
    

}
