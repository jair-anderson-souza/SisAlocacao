/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.dao;

import io.github.jass2125.sistema.alocacao.core.business.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 * Classe que implementa os DAO's de usuario
 *
 * @author Anderson Souza
 * @since 2015
 */
public class UsuarioDao implements IUsuarioDao {
    private Properties info = new Properties();
    private String url;

    public UsuarioDao() {
        info.setProperty("user", "root");
        info.setProperty("password", "12345");
        url = "jdbc:mysql://localhost:3306/pp";
    }

    /**
     * Método responsável por buscar um usuario pelo seu identificador
     *
     * @param username Username do usuario
     * @param password Senha do usuario
     * @return usuario Usuario
     * @throws SQLException UsuarioDao
     */
    @Override
    public Usuario find(String username, String password) throws SQLException, ClassNotFoundException {
        String sql = "select * from usuario where binary username = ? and binary senha = ? or binary email = ? and binary senha = ?;";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, "root", "12345");
        PreparedStatement ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ps.setString(1, username);
        ps.setString(2, password);
        ps.setString(3, username);
        ps.setString(4, password);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            int idUsuario = rs.getInt("id_usuario");
            String nome = rs.getString("nome");
            String senha = rs.getString("senha");
            String user = rs.getString("username");
            String email = rs.getString("email");
            String matricula = rs.getString("matricula");
            String papel = rs.getString("papel");
            boolean status = rs.getBoolean("status");
            return new Usuario(idUsuario, nome, user, senha, email, matricula, papel, status);
        }

        rs.close();
        ps.clearParameters();
        ps.close();
        return null;
    }

    /**
     * Método responsável por adicionar um usuario
     *
     * @param usuario Usuario
     * @throws SQLException UsuarioDao
     */
    @Override
    public void add(Usuario usuario) throws SQLException {
        String sql = "insert into usuario(nome, username, senha, email, matricula, papel, status) values(?, ?, ?, ?, ?, ?, ?);";
        Connection con = DriverManager.getConnection(url, info);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getUsername());
        ps.setString(3, usuario.getSenha());
        ps.setString(4, usuario.getEmail());
        ps.setString(5, usuario.getMatricula());
        ps.setString(6, usuario.getPapel());
        ps.setBoolean(7, usuario.isStatus());
        ps.execute();
        ps.close();
        //ver como usar o rollback pra evitar perder inserção

    }

    /**
     * Método responsável por buscar todos os usuarios
     *
     * @param idUsuario Id do usuario
     * @return list Set
     * @throws SQLException UsuarioDao
     */
    @Override
    public Set<Usuario> list(int idUsuario) throws SQLException {
        String sql = "select * from usuario where id_usuario <> ? and status = true;";
        Connection con = DriverManager.getConnection(url, info);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idUsuario);
        Set<Usuario> list = new HashSet<>();
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id_usuario");
            String nome = rs.getString("nome");
            String email = rs.getString("email");
            String username = rs.getString("username");
            String senha = rs.getString("senha");
            String matricula = rs.getString("matricula");
            String papel = rs.getString("papel");
            boolean status = rs.getBoolean("status");
            Usuario u = new Usuario(id, nome, username, senha, email, matricula, papel, status);
            list.add(u);
        }
        rs.close();
        ps.clearParameters();
        ps.close();
        con.close();
        return list;
    }

    /**
     * Método responsável por editar um usuario
     *
     * @param usuario Usuario
     * @throws SQLException UsuarioDao
     */
    @Override
    public void edit(Usuario usuario) throws SQLException {
        String sql = "update usuario set nome = ?, username = ?, senha = ?, email = ?, matricula = ?, papel = ?, status = ? where id_usuario = ?;";
        Connection con = DriverManager.getConnection(url, info);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getUsername());
        ps.setString(3, usuario.getSenha());
        ps.setString(4, usuario.getEmail());
        ps.setString(5, usuario.getMatricula());
        ps.setString(6, usuario.getPapel());
        ps.setBoolean(7, usuario.isStatus());
        ps.setInt(8, usuario.getId());
        ps.execute();
        ps.close();
    }

    /**
     * Método responsável por excluir um usuario pelo seu identificador
     *
     * @param idUsuario Id do usuario
     * @throws SQLException UsuarioDao
     */
    @Override
    public void delete(int idUsuario) throws SQLException {
        String sql = "delete from usuario where id_usuario = ?;";
        Connection con = DriverManager.getConnection(url, info);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idUsuario);
        ps.execute();
    }

    /**
     * Método responsável por buscar um usuario pelo seu identificador
     *
     * @param idUsuario Id do usuario
     * @return usuario Usuario
     * @throws SQLException UsuarioDao
     */
    @Override
    public Usuario find(int idUsuario) throws SQLException {
        String sql = "select * from usuario where id_usuario = ?";
        Connection con = DriverManager.getConnection(url, info);
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idUsuario);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String nome = rs.getString("nome");
            String email = rs.getString("email");
            String username = rs.getString("username");
            String senha = rs.getString("senha");
            String matricula = rs.getString("matricula");
            String papel = rs.getString("papel");
            boolean status = rs.getBoolean("status");
            return new Usuario(idUsuario, nome, username, senha, email, matricula, papel, status);
        }
        rs.close();
        ps.clearParameters();
        ps.close();
        con.close();
        return null;

    }

}
