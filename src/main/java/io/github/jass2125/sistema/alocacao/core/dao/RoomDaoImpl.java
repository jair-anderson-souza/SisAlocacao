/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.dao;

import io.github.jass2125.sistema.alocacao.core.business.Room;
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
public class RoomDaoImpl implements RoomDao {

    private ConnectionFactory conFactory;

    public RoomDaoImpl() {
        conFactory = new ConnectionFactory();
    }

    @Override
    public List<Room> listRooms() throws SQLException, ClassNotFoundException {
        String sql = "select * from sala left join bloco on sala.bloco = bloco.id_bloco;";
        Connection con = conFactory.getConnection();
        PreparedStatement ps = con.prepareCall(sql);
        ResultSet rs = ps.executeQuery();
        List<Room> listRooms = new ArrayList<>();
        Room room = null;
        while (rs.next()) {
            String nameRoom = rs.getString("nome_da_sala");
            Long floor = rs.getLong("id_bloco");
            Integer capacity = rs.getInt("capacidade_fisica");
            String typeRoom = rs.getString("capacidade_fisica");
            room = new Room(nameRoom, floor, capacity, typeRoom);
            listRooms.add(room);
            floor = null;
        }
        return listRooms;
    }

    @Override
    public void add(Room room) throws SQLException, ClassNotFoundException {
        String sql = "insert into sala(nome_da_sala, bloco, capacidade_fisica, tipo_de_sala) values(?, ?, ?, ?);";
        Connection con = conFactory.getConnection();
        PreparedStatement ps = con.prepareCall(sql);
        ps.setString(1, room.getNameRoom());
        ps.setLong(2, room.getIdFloor());
        ps.setInt(3, room.getCapacity());
        ps.setString(4, room.getTypeRoom());
        ps.execute();
    }

    @Override
    public Room findById(Long idRoom) throws SQLException, ClassNotFoundException {
        return new Room();
    }

    @Override
    public void update(Room room) throws SQLException, ClassNotFoundException {

    }

    @Override
    public void delete(Long idRoom) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
