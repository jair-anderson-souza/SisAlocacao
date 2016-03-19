/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.sistema.alocacao.core.dao;


import io.github.jass2125.sistema.alocacao.core.business.User;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

/**
 * Interface do DAO de user
 * @author Anderson Souza
 * @since 2015
 */
public interface UserDao {
    /**
     * Metodo abstrato que adiciona um usuario
     * @param user User
     * @throws SQLException Erro de conexão com o banco de dados
     */
    public void add(User user) throws SQLException, ClassNotFoundException;
    
    /**
     * Metodo abstrato que edita um usuario
     * @param user User
     * @throws SQLException Erro de conexão com o banco de dados
     */
    public void edit(User user) throws SQLException, ClassNotFoundException;
        
    /**
     * Metodo abstrato que busca um usuario pelo seu login e password
     * @param username Username do usuario
     * @param password Password do usuario
     * @return user User
     * @throws SQLException Erro de conexão com o banco de dados
     * @throws ClassNotFoundException Ocorre quando a classe do Driver JDBC do MYSQL não é encontrada
     */
    public User findByLoginAndPassword(String username, String password) throws SQLException, ClassNotFoundException;
    
    /**
     * Metodo abstrato que retorna um Set de usuarios
     * @param idUser Id de usuario
     * @return list Set
     * @throws SQLException IUsuarioDao
     */
    public List<User> list(int idUser) throws SQLException, ClassNotFoundException;
    
    /**
     * Metodo abstrato que exclui um usuario pelo seu identificador
     * @param idUser Id de usuario
     * @throws SQLException IUsuarioDao
     */
    public void delete(int idUser) throws SQLException, ClassNotFoundException;
    
    /**
     * Metodo abstrato que busca um usuario pelo seu identificador
     * @param idUser Id de Usuario
     * @return User user
     * @throws SQLException Erro de conexão com o banco de dados
     */
    public User findById(int idUser) throws SQLException, ClassNotFoundException;
    
    /**
     * Método abstrato que busca um usuario pelo seu username e pelo seu email
     * @param username String
     * @param email String 
     * @return User Usuário encontrado
     * @throws SQLException Erro de conexão com o banco de dados
     * @throws ClassNotFoundException Ocorre quando a classe do Drive do banco de dados não pode ser encontrada
     */
    public User findByUsernameOrEmail(String username, String email) throws SQLException, ClassNotFoundException;
    
    

}
