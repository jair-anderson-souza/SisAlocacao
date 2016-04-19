/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.business;

import java.io.Serializable;

/**
 *
 * @author Anderson Souza
 */
public class Floor implements Serializable {

    private Long idFloor;
    private String description;

    public Floor() {
    }

    public Floor(String description) {
        this.description = description;
    }

    public Floor(Long idFloor, String description) {
        this.idFloor = idFloor;
        this.description = description;
    }

    public Long getIdFloor() {
        return idFloor;
    }

    public void setIdFloor(Long idFloor) {
        this.idFloor = idFloor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
