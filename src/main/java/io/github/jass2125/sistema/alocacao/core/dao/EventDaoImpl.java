/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.dao;

import io.github.jass2125.sistema.alocacao.core.business.Event;
import io.github.jass2125.sistema.alocacao.core.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anderson Souza
 */
public class EventDaoImpl implements EventDao {

    private ConnectionFactory connectionFactory;

    public EventDaoImpl() {
        connectionFactory = new ConnectionFactory();
    }

    @Override
    public void add(Event event) throws SQLException, ClassNotFoundException {
        Connection con = connectionFactory.getConnection();
        String sql = "insert into evento(nome, descricao, numero_participantes, responsavel, inicio, fim) values(?, ?, ?, ?, ?, ?);";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, event.getName());
        ps.setString(2, event.getDescription());
        ps.setInt(3, event.getNumber());
        ps.setLong(4, event.getResponsable());
        ps.setTimestamp(5, event.getBegin());
        ps.setTimestamp(6, event.getEnd());
        ps.execute();
    }

    @Override
    public List<Event> listEvents() throws SQLException, ClassNotFoundException {
        Connection con = connectionFactory.getConnection();
        String sql = "select * from evento;";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Event> listEvent = new ArrayList<>();
        Event event = null;
        while (rs.next()) {
            int id_event = rs.getInt("id_evento");
            String name = rs.getString("nome");
            String description = rs.getString("descricao");
            int number = rs.getInt("numero_participantes");
            Long responsable = rs.getLong("responsavel");
            Timestamp begin = rs.getTimestamp("inicio");
            Timestamp end = rs.getTimestamp("fim");
            event = new Event(id_event, name, description, number, responsable, begin, end);
            listEvent.add(event);
        }
        return listEvent;

    }

}
