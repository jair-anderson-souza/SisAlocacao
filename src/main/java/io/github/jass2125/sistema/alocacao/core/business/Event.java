/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.business;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @author Anderson Souza
 */
public class Event implements Serializable {

    private int idEvent;
    private String name;
    private String description;
    private int number;
    private Long responsable;
    private Timestamp begin;
    private Timestamp end;

    public Event() {
    }

    public Event(int idEvent, String name, String description, int number, Long responsable, Timestamp begin, Timestamp end) {
        this.idEvent = idEvent;
        this.name = name;
        this.description = description;
        this.number = number;
        this.responsable = responsable;
        this.begin = begin;
        this.end = end;
    }

    public Event(String name, String description, int number, Long responsable, Timestamp begin, Timestamp end) {
        this.name = name;
        this.description = description;
        this.number = number;
        this.responsable = responsable;
        this.begin = begin;
        this.end = end;
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

    public Long getResponsable() {
        return responsable;
    }

    public void setResponsable(Long responsable) {
        this.responsable = responsable;
    }

    public Timestamp getBegin() {
        return begin;
    }

    public void setBegin(Timestamp begin) {
        this.begin = begin;
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }
}
