/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.sistema.alocacao.core.factory;

import io.github.jass2125.sistema.alocacao.core.dao.FeriadoDao;
import io.github.jass2125.sistema.alocacao.core.dao.IFeriadoDao;
import io.github.jass2125.sistema.alocacao.core.dao.IUsuarioDao;
import io.github.jass2125.sistema.alocacao.core.dao.UsuarioDao;



/**
 * Classe que implementa as fabricas de DAO
 * @author Anderson Souza
 * @since 2015
 */
public class FactoryImpl extends Factory {
    
    /** 
     * Método que que instancia DAO de usuario
     * @return IUsuarioDao Dao de usuario
     */
    @Override
    public IUsuarioDao createUsuarioDao() {
        return new UsuarioDao();
    }
    /**
     * Método que que instancia DAO de feriado
     * @return IFeriadoDao Dao de feriado
     */
    @Override
    public IFeriadoDao createFeriadoDao() {
        return new FeriadoDao();
    }
    
    

}
