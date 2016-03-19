/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.dao;

import io.github.jass2125.sistema.alocacao.core.business.Floor;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Anderson Souza
 */
public interface FloorDao {
    public List<Floor> getListFloor()throws SQLException, ClassNotFoundException;
    public void add(Floor floor) throws SQLException, ClassNotFoundException;
    
    
}
