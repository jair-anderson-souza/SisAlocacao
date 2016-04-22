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
public class Room implements Serializable {
    private Long idRoom;
    private String nameRoom;
    private Long floor;
    private Integer capacity;
    private String typeRoom;

    public Room(String nameRoom, Long floor, int capacicity, String typeRoom) {
        this.nameRoom = nameRoom;
        this.floor = floor;
        this.capacity = capacicity;
        this.typeRoom = typeRoom;
    }

    public Room() {
    }

    public Long getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Long idRoom) {
        this.idRoom = idRoom;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public Long getIdFloor() {
        return floor;
    }

    public void setIdFloor(Long floor) {
        this.floor = floor;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacicity) {
        this.capacity = capacicity;
    }

    public String getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(String typeRoom) {
        this.typeRoom = typeRoom;
    }

}
