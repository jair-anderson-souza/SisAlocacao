/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.sistema.alocacao.core.dao;

import io.github.jass2125.sistema.alocacao.core.business.Feriado;
import java.sql.SQLException;
import java.util.Set;

/**
 * Interface do DAO de feriado
 * @author Anderson Souza
 * @since 2015
 */
public interface IFeriadoDao {
    
    /**
     * Metodo abstrato que adiciona um feriado
     * @param feriado Feriado
     * @throws SQLException IFeriadoDao
     */
    public void add(Feriado feriado) throws SQLException;
    
    /**
     * Metodo abstrato que exclui um feriado pelo seu identificador
     * @param idFeriado Id de feriado
     * @throws SQLException IFeriadoDao
     */
    public void delete(int idFeriado) throws SQLException;
    
    /**
     * Metodo abstrato que edita um feriado
     * @param feriado Feriado
     * @throws SQLException IFeriadoDao
     */
    public void edit(Feriado feriado) throws SQLException;
    
    /**
     * Metodo abstrato que retorna um Set de feriados
     * @return list Set de feriado
     * @throws SQLException IFeriadoDao
     */
    public Set<Feriado> list() throws SQLException;

    /**
     * Metodo abstrato que busca um feriado pelo seu identificador
     * @param idFeriado Id de feriado
     * @return Feriado feriado
     * @throws SQLException IFeriadoDao
     */
    public Feriado find(int idFeriado) throws SQLException ;

}
