/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.dao;

import io.github.jass2125.sistema.alocacao.core.business.Material;
import io.github.jass2125.sistema.alocacao.core.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anderson Souza
 */
public class MaterialDaoImpl implements MaterialDao {

    private ConnectionFactory connectionFactory;

    public MaterialDaoImpl() {
        connectionFactory = new ConnectionFactory();
    }

    @Override
    public List<Material> listMaterial() throws SQLException, ClassNotFoundException {
        Connection con = connectionFactory.getConnection();
        String sql = "select * from material as m inner join sala as s where m.local = s.id_sala or m.status is null;";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Material> listMaterial = new ArrayList<>();
        Material material = null;
        while (rs.next()) {
            int tombamento = rs.getInt("tombamento");
            String description = rs.getString("descricao");
            int quantity = rs.getInt("quantidade");
            String status = rs.getString("status");
            String materialRoom = rs.getString("nome_da_sala");
            material = new Material(tombamento, description, quantity, status, materialRoom);
            listMaterial.add(material);
        }
        return listMaterial;
    }

    @Override
    public void add(Material material) throws SQLException, ClassNotFoundException {
        Connection con = connectionFactory.getConnection();
        String sql = "insert into material(descricao, quantidade) values(?, ?);";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, material.getDescription());
        ps.setInt(2, material.getQuantity());
        ps.execute();
    }

    @Override
    public Material findById(int tombamento) throws SQLException, ClassNotFoundException {
        String sql = "select * from material inner join sala where material.local = sala.id_sala and material.tombamento = ?;";
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, tombamento);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String description = rs.getString("descricao");
            int quantity = rs.getInt("quantidade");
            String status = rs.getString("status");
            String materialRoom = rs.getString("nome_da_sala");
            return new Material(tombamento, description, quantity, status, materialRoom);
        }
        return null;

    }

    @Override
    public void update(Material material) throws SQLException, ClassNotFoundException {
        String sql = "update material set descricao = ?, quantidade = ? where tombamento = ?;";
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, material.getDescription());
        ps.setInt(2, material.getQuantity());
        ps.setInt(2, material.getTombamento());
        ps.execute();
    }

}
