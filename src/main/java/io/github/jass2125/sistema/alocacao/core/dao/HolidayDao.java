/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.sistema.alocacao.core.dao;


import io.github.jass2125.sistema.alocacao.core.business.Holiday;
import io.github.jass2125.sistema.alocacao.core.connection.ConnectionBD;
import java.sql.SQLException;
import java.util.Set;

/**
 * Classe que implementa os DAO's de feriado
 * @author Anderson Souza
 * @since 2015
 */
public class HolidayDao implements IHolidayDao{
    private ConnectionBD connection;

    public HolidayDao() {
        connection = new ConnectionBD();
    }
//    /**
//     * Método responsavel por retornar uma lista com todos os feriados
//     * @return list Set de feriado
//     * @throws SQLException FeriadoDao
//     */
//    @Override
//    public Set<Holiday> list() throws SQLException {
//        String sql = "select * from feriado;";
//        Connection con = connection.closeConnection();
//        PreparedStatement ps = con.prepareStatement(sql);
//        Set<Holiday> list = new HashSet<>();
//        ResultSet rs = ps.executeQuery();
//        
//        while(rs.next()){
//            int idFeriado = rs.getInt("id_feriado");
//            String data_feriado = rs.getString("dataFeriado");
//            String descricao = rs.getString("descricao");
//            int id_usuario = rs.getInt("id_usuario");
//            Holiday feriado = new Holiday(idFeriado, descricao, data_feriado);
//            list.add(feriado);
//        }
//        rs.close();
//        ps.clearParameters();
//        ps.close();
//        con.close();
//        return list;
//    }
//    /**
//     * Método responsavel por adicionar um novo feriado
//     * @param feriado Feriado
//     * @throws SQLException FeriadoDao
//     */
//    @Override
//    public void add(Feriado feriado) throws SQLException {
//        String sql = "insert into feriado(dataFeriado, descricao, id_usuario) values(?, ?, ?);";
//        Connection con = connection.getConnection();
//        PreparedStatement ps = con.prepareStatement(sql);
//        ps.setString(1, feriado.getDataDeFeriado());
//        ps.setString(2, feriado.getDescricao());
//        ps.setInt(3, feriado.getIdUsuario());
//        ps.execute();
//        ps.clearParameters();
//        ps.close();
//        con.close();
//    }
//    
//    /**
//     * Método responsável por editar um feriado
//     * @param feriado Feriado
//     * @throws SQLException FeriadoDao
//     */
//    @Override
//    public void edit(Feriado feriado) throws SQLException {
//        String sql = "update feriado set descricao = ?, dataFeriado = ?, id_usuario = ? where id_feriado = ?;";
//        Connection con = connection.getConnection();
//        PreparedStatement ps = con.prepareStatement(sql);
//        ps.setString(1, feriado.getDescricao());
//        ps.setString(2, feriado.getDataDeFeriado());
//        ps.setInt(3, feriado.getIdUsuario());
//        ps.setInt(4, feriado.getIdFeriado());
//        ps.execute();
//        ps.clearParameters();
//        ps.close();
//        con.close();
//    }
//    /**
//     * Método responsável por excluir um feriado
//     * @param idFeriado int
//     * @throws SQLException FeriadoDao
//     */
//    @Override
//    public void delete(int idFeriado) throws SQLException {
//        String sql = "delete from feriado where id_feriado = ?;";
//        Connection con = connection.getConnection();
//        PreparedStatement ps = con.prepareStatement(sql);
//        ps.setInt(1, idFeriado);
//        ps.execute();
//    }
//    
//    /**
//     * Método responsável por buscar um feriado pelo seu identificador
//     * @param idFeriado int
//     * @return Feriado Feriado
//     * @throws SQLException FeriadoDao
//     */
//    @Override
//    public Feriado find(int idFeriado) throws SQLException {
//        String sql = "select * from feriado where id_feriado = ?;";
//        Connection con = connection.getConnection();
//        PreparedStatement ps = con.prepareStatement(sql);
//        ps.setInt(1, idFeriado);
//        ResultSet rs = ps.executeQuery();
//        while(rs.next()){
//            String data_feriado = rs.getString("dataFeriado");
//            String descricao = rs.getString("descricao");
//            int id_usuario = rs.getInt("id_usuario");
//            return  new Feriado(idFeriado, descricao, data_feriado, id_usuario);
//        }
//        rs.close();
//        ps.clearParameters();
//        ps.close();
//        con.close();
//        return null;
//    }

    @Override
    public void add(Holiday holiday) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int idFeriado) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Holiday holiday) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Holiday> list() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Holiday find(int idHoliday) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
