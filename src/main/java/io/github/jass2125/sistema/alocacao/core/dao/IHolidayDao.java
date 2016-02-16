/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.sistema.alocacao.core.dao;

import io.github.jass2125.sistema.alocacao.core.business.Holiday;
import java.sql.SQLException;
import java.util.List;

/**
 * Interface do DAO de feriado
 * @author Anderson Souza
 * @since 2015
 */
public interface IHolidayDao {
    
    /**
     * Metodo abstrato que adiciona um feriado
     * @param holiday Holiday
     * @throws SQLException Erro de conexão com o banco de dados
     */
    public void add(Holiday holiday) throws SQLException, ClassNotFoundException;
    
    /**
     * Metodo abstrato que exclui um feriado pelo seu identificador
     * @param idFeriado Id de feriado
     * @throws SQLException IFeriadoDao
     */
    public void delete(int idFeriado) throws SQLException;
    
    /**
     * Metodo abstrato que edita um feriado
     * @param holiday Feriado
     * @throws SQLException IFeriadoDao
     */
    public void edit(Holiday holiday) throws SQLException, ClassNotFoundException;
    
    /**
     * Metodo abstrato que retorna um Set de feriados
     * @return list Set de feriado
     * @throws SQLException IFeriadoDao
     */
    public List<Holiday> list() throws SQLException;

    /**
     * Metodo abstrato que busca um feriado pelo seu identificador
     * @param idHoliday Id de feriado
     * @return Feriado feriado
     * @throws SQLException IFeriadoDao
     */
    public Holiday findById(int idHoliday) throws SQLException;
    
    /**
     * 
     */
    public Holiday findByDate(String date) throws SQLException, ClassNotFoundException;
}
