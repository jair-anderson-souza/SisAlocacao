/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.dao;

import io.github.jass2125.sistema.alocacao.core.business.Material;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Anderson Souza
 */
public interface IMaterialDao {

    public List<Material> listMaterial() throws SQLException, ClassNotFoundException;

    public void add(Material material) throws SQLException, ClassNotFoundException;

    public Material findById(int tombamento) throws SQLException, ClassNotFoundException;

    public void update(Material material) throws SQLException, ClassNotFoundException;

}
