/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.dao;

import io.github.jass2125.sistema.alocacao.core.business.Floor;
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
public class FloorDaoImpl implements FloorDao {

    private ConnectionFactory conFactory;

    public FloorDaoImpl() {
        conFactory = new ConnectionFactory();
    }

    @Override
    public List<Floor> getListFloor() throws SQLException, ClassNotFoundException {
        String sql = "select * from bloco;";
        Connection con = conFactory.getConnection();
        PreparedStatement ps = con.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        List<Floor> listFloors = new ArrayList<>();
//        Floor floor = null;
        while (rs.next()) {
            Long idFloor = rs.getLong("id_bloco");
            String description = rs.getString("nomeDoBloco");
            Floor floor = new Floor(idFloor, description);
            listFloors.add(floor);
            floor = null;
        }
        return listFloors;
    }

    @Override
    public void add(Floor floor) throws SQLException, ClassNotFoundException {
        String sql = "insert into floor values(?, ?);";
        Connection con = conFactory.getConnection();
        PreparedStatement ps = con.prepareCall(sql);
        ps.setLong(1, floor.getIdFloor());
        ps.setString(2, floor.getDescription());
        ps.execute();
    }

    @Override
    public Floor findById(Long idFloor) throws SQLException, ClassNotFoundException {
        String sql = "select * from bloco where id_bloco = ?;";
        Connection con = conFactory.getConnection();
        PreparedStatement ps = con.prepareCall(sql);
        ps.setLong(1, idFloor);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Long id = rs.getLong("id_bloco");
            String description = rs.getString("nomeDoBloco");
            return new Floor(id, description);
        }
        return null;
    }

    @Override
    public void update(Floor floor) throws SQLException, ClassNotFoundException {
        String sql = "update bloco set nomeDoBloco = ? where id_bloco = ?;";
        Connection con = conFactory.getConnection();
        PreparedStatement ps = con.prepareCall(sql);
        ps.setString(1, floor.getDescription());
        ps.setLong(2, floor.getIdFloor());
        ps.execute();
    }

    @Override
    public void delete(Long idFloor) throws SQLException, ClassNotFoundException{
        String sql = "delete from bloco where id_bloco = ?;";
        Connection con = conFactory.getConnection();
        PreparedStatement ps = con.prepareCall(sql);
        ps.setLong(1, idFloor);
        ps.execute();
    }

}
