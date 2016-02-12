/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.sistema.alocacao.core.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Anderson Souza
 * @email jair_anderson_bs@hotmail.com
 * @since 2015, Feb 10, 2016
 */
public class ConnectionBD {
    private Connection connection;
    private Properties property;
    private String url;

    public ConnectionBD() {
        url = "jdbc:mysql://localhost/pp";
        property = new Properties();
        property.setProperty("user", "root");
        property.setProperty("password", "12345");
    }
    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, property);
    }
    
    public Connection closeConnection(){
        return null;
        
    }
    
    
    
    

}
