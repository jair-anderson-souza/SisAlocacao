/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.dao;

import io.github.jass2125.sistema.alocacao.core.business.Holiday;
import io.github.jass2125.sistema.alocacao.core.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa os DAO's de feriado
 *
 * @author Anderson Souza
 * @since 2015
 */
public class HolidayDaoImpl implements HolidayDao {
    private ConnectionFactory connectionFactory;
    
    public HolidayDaoImpl() {
        connectionFactory = new ConnectionFactory();
    }

    /**
     * Método responsavel por retornar uma lista com todos os feriados
     *
     * @return list Set de feriado
     * @throws SQLException FeriadoDao
     * @throws ClassNotFoundException
     */
    @Override
    public List<Holiday> list() throws SQLException, ClassNotFoundException {
        String sql = "select * from feriado order by dataFeriado asc;";
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        List<Holiday> list = new ArrayList<>();
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int idHoliday = rs.getInt("id_feriado");
            String data_feriado = rs.getString("dataFeriado");
            String descricao = rs.getString("descricao");
            Holiday feriado = new Holiday(idHoliday, descricao, data_feriado);
            list.add(feriado);
        }
        rs.close();
        ps.clearParameters();
        ps.close();
        con.close();
        return list;
    }

    /**
     * Método responsavel por adicionar um novo feriado
     *
     * @param feriado Feriado
     * @throws SQLException FeriadoDao
     */
    @Override
    public void add(Holiday holiday) throws SQLException, ClassNotFoundException {
        String sql = "insert into feriado(dataFeriado, descricao) values(?, ?);";
        Connection con = connectionFactory.getConnection();
        Class.forName("com.mysql.jdbc.Driver");
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, holiday.getDate());
        ps.setString(2, holiday.getDescription());
        ps.execute();
        ps.close();
        con.close();
    }

    /**
     * Método responsável por editar um feriado
     *
     * @param feriado Feriado
     * @throws SQLException FeriadoDao
     */
    @Override
    public void edit(Holiday holiday) throws SQLException, ClassNotFoundException {
        String sql = "update feriado set descricao = ?, dataFeriado = ? where id_feriado = ?;";
        Connection con = connectionFactory.getConnection();
        Class.forName("com.mysql.jdbc.Driver");
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, holiday.getDescription());
        ps.setString(2, holiday.getDate());
        ps.setInt(3, holiday.getIdHoliday());
        ps.execute();
        ps.clearParameters();
        ps.close();
        con.close();
    }

    /**
     * Método responsável por excluir um feriado
     *
     * @param idFeriado int
     * @throws SQLException FeriadoDao
     */
    @Override
    public void delete(int idHoliday) throws SQLException, ClassNotFoundException {
        String sql = "delete from feriado where id_feriado = ?;";
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idHoliday);
        ps.execute();
    }

    /**
     * Método responsável por buscar um feriado pelo seu identificador
     *
     * @param idFeriado int
     * @return Feriado Feriado
     * @throws SQLException FeriadoDao
     * @throws ClassNotFoundException
     */
    @Override
    public Holiday findById(int idHoliday) throws SQLException, ClassNotFoundException {
        String sql = "select * from feriado where id_feriado = ?;";
        Connection con = connectionFactory.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idHoliday);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String date = rs.getString("dataFeriado");
            String description = rs.getString("descricao");
            return new Holiday(idHoliday, description, date);
        }
        rs.close();
        ps.close();
        con.close();
        return null;
    }

    @Override
    public Holiday findByDate(String date) throws SQLException, ClassNotFoundException {
        return null;
    }
}
