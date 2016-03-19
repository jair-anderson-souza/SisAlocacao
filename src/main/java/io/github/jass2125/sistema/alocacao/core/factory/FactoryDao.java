/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.sistema.alocacao.core.factory;

import io.github.jass2125.sistema.alocacao.core.dao.HolidayDao;
import io.github.jass2125.sistema.alocacao.core.dao.HolidayDaoImpl;
import io.github.jass2125.sistema.alocacao.core.dao.UserDao;
import io.github.jass2125.sistema.alocacao.core.dao.UserDaoImpl;




/**
 * Classe que implementa as fábricas de DAO
 * @author Anderson Souza
 * @since 2015
 */
public class FactoryDao extends Factory {
    
    /** 
     * Método que que instancia DAO de usuario
     * @return IUsuarioDao Dao de usuario
     */
    @Override
    public UserDao createUserDao() {
        return new UserDaoImpl();
    }
    /**
     * Método que que instancia DAO de feriado
     * @return IFeriadoDao Dao de feriado
     */
    public HolidayDao createHolidayDao() {
        return new HolidayDaoImpl();
    }
    
    

}
