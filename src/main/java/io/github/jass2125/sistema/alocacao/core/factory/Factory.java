/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.factory;

import io.github.jass2125.sistema.alocacao.core.dao.FloorDao;
import io.github.jass2125.sistema.alocacao.core.dao.HolidayDao;
import io.github.jass2125.sistema.alocacao.core.dao.MaterialDao;
import io.github.jass2125.sistema.alocacao.core.dao.UserDao;

/**
 * Fabrica abstrata de DAO's
 *
 * @author Anderson Souza
 * @since 2015
 */
public abstract class Factory {

    /**
     * Metodo abstrato que retorna uma instancia do DAO de usuario
     *
     * @return IUsuarioDao
     */
    public abstract UserDao createUserDao();

    /**
     * Metodo abstrato que retorna uma instancia do DAO de feriado
     *
     * @return IFeriadoDao
     */
    public abstract HolidayDao createHolidayDao();

    public abstract FloorDao createFloorDao();
    public abstract MaterialDao createMaterialDao();
}
