/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.business;

import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author Anderson Souza
 */
public class Event implements Serializable {

    private String name;
    private String description;
    private int number;
    private String responsavel;
    private Calendar Horáriodeinícioefim;

    public Event() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public Calendar getHoráriodeinícioefim() {
        return Horáriodeinícioefim;
    }

    public void setHoráriodeinícioefim(Calendar Horáriodeinícioefim) {
        this.Horáriodeinícioefim = Horáriodeinícioefim;
    }

}
