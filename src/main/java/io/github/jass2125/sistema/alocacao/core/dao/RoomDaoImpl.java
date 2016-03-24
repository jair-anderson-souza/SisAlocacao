/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.dao;

import io.github.jass2125.sistema.alocacao.core.business.Room;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anderson Souza
 */
public class RoomDaoImpl implements RoomDao {

    @Override
    public List<Room> listRooms() throws SQLException, ClassNotFoundException {
        return new ArrayList<>();
    }

    @Override
    public void add(Room room) throws SQLException, ClassNotFoundException {

    }

    @Override
    public Room findById(Long idRoom) throws SQLException, ClassNotFoundException {
        return new Room();
    }

    @Override
    public void update(Room room) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long idRoom) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
