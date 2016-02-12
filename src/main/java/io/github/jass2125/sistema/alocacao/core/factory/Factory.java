/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.sistema.alocacao.core.factory;

import io.github.jass2125.sistema.alocacao.core.dao.IFeriadoDao;
import io.github.jass2125.sistema.alocacao.core.dao.IUsuarioDao;



/**
 * Fabrica de DAO's
 * @author Anderson Souza
 * @since 2015
 */
public abstract class Factory {
    /**
     * Metodo abstrato que retorna uma instancia do DAO de usuario
     * @return IUsuarioDao
     */
    public abstract IUsuarioDao createUsuarioDao();
    /**
     * Metodo abstrato que retorna uma instancia do DAO de feriado
     * @return IFeriadoDao
     */
    public abstract IFeriadoDao createFeriadoDao();
}
