/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Anderson Souza
 * @since 2015, Feb 10, 2016
 */
public class ConnectionFactory {

    private Connection connection;
    private String classDriver;
    private Properties info;
    private String url;

    public ConnectionFactory() {
        this.info = new Properties();
        info.setProperty("user", "root");
        this.classDriver = "com.mysql.jdbc.Driver";
        info.setProperty("password", "12345");
        url = "jdbc:mysql://localhost:3306/sisloc";
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName(classDriver);
        return DriverManager.getConnection(url, info);
    }

}
