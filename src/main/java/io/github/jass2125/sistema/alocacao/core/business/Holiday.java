/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.sistema.alocacao.core.business;

import java.io.Serializable;

/**
 * Classe que representa o Feriado
 * @author Anderson Souza
 * @since 2015
 */
public class Holiday implements Serializable {
    private int idHoliday;
    private String description;
    private String date;

    public Holiday() {
    }

    public Holiday(int idHoliday, String description, String date) {
        this(description, date);
        this.idHoliday = idHoliday;
    }
    
    public Holiday(String description, String date) {
        this.description = description;
        this.date = date;
    }

    /**Metodo que retorna a descrição do feriado
     * @return description String
     */
    public String getDescription() {
        return this.description;
    }
    /**
     * Metodo que altera a descrição do feriado
     * @param description  String
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Metodo que retorna a data de feriado
     * @return date String
     */
    public String getDate() {
        return this.date;
    }
    
    /**
     * Metodo que altera a descrição do feriado
     * @param date String 
     */
    public void setDate(String date) {
        this.date = date;
    }
    
    /**
     * Metodo que retorna o id do feriado
     * @return idHoliday int
     */
    public int getIdHoliday() {
        return this.idHoliday;
    }
    

}
