/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.factory;

import io.github.jass2125.sistema.alocacao.core.dao.EventDao;
import io.github.jass2125.sistema.alocacao.core.dao.EventDaoImpl;
import io.github.jass2125.sistema.alocacao.core.dao.FloorDao;
import io.github.jass2125.sistema.alocacao.core.dao.FloorDaoImpl;
import io.github.jass2125.sistema.alocacao.core.dao.HolidayDao;
import io.github.jass2125.sistema.alocacao.core.dao.HolidayDaoImpl;
import io.github.jass2125.sistema.alocacao.core.dao.LocationDao;
import io.github.jass2125.sistema.alocacao.core.dao.LocationDaoImpl;
import io.github.jass2125.sistema.alocacao.core.dao.MaterialDao;
import io.github.jass2125.sistema.alocacao.core.dao.MaterialDaoImpl;
import io.github.jass2125.sistema.alocacao.core.dao.RoomDao;
import io.github.jass2125.sistema.alocacao.core.dao.RoomDaoImpl;
import io.github.jass2125.sistema.alocacao.core.dao.UserDao;
import io.github.jass2125.sistema.alocacao.core.dao.UserDaoImpl;

/**
 * Classe que implementa as fábricas de DAO
 *
 * @author Anderson Souza
 * @since 2015
 */
public class FactoryDao extends Factory {

    /**
     * Método que que instancia DAO de usuario
     *
     * @return IUsuarioDao Dao de usuario
     */
    @Override
    public UserDao createUserDao() {
        return new UserDaoImpl();
    }

    /**
     * Método que que instancia DAO de feriado
     *
     * @return IFeriadoDao Dao de feriado
     */
    @Override
    public HolidayDao createHolidayDao() {
        return new HolidayDaoImpl();
    }

    @Override
    public FloorDao createFloorDao() {
        return new FloorDaoImpl();
    }

    @Override
    public MaterialDao createMaterialDao() {
        return new MaterialDaoImpl();
    }

    @Override
    public RoomDao createRoomDao() {
        return new RoomDaoImpl();
    }

    @Override
    public LocationDao createLocationDao() {
        return new LocationDaoImpl();
    }

    @Override
    public EventDao createEventDao() {
        return new EventDaoImpl();
    }

}
