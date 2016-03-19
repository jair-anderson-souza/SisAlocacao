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
        while(rs.next()){
            Long idFloor = rs.getLong("id_bloco");
            String description = rs.getString("nomeDoBloco");
            Floor floor = new Floor(idFloor, description);
            listFloors.add(floor);
            floor = null;
        }
        
        
        
        return listFloors;
    }

}
