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
public class MaterialDao implements IMaterialDao {

    private ConnectionFactory connectionFactory;

    public MaterialDao() {
        connectionFactory = new ConnectionFactory();
    }

    @Override
    public List<Material> listMaterial() throws SQLException, ClassNotFoundException {
         Connection con = connectionFactory.getConnection();
        String sql = "select material.descricao, material.tombamento, material.quantidade, material.status, sala.nome_da_sala from material inner join sala where material.local = sala.id_sala;";
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
    public void add(Material material) {

    }

}
