/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.business;

import io.github.jass2125.sistema.alocacao.core.util.RoomTypeEnum;
import java.io.Serializable;

/**
 *
 * @author Anderson Souza
 */
public class Room implements Serializable {
    private Long idRoom;
    private String nameRoom;
    private Long idFloor;
    private Integer capacicity;
    private RoomTypeEnum typeRoom;

    public Room(String nameRoom, Long idFloor, int capacicity, RoomTypeEnum typeRoom) {
        this.nameRoom = nameRoom;
        this.idFloor = idFloor;
        this.capacicity = capacicity;
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
        return idFloor;
    }

    public void setIdFloor(Long idFloor) {
        this.idFloor = idFloor;
    }

    public int getCapacicity() {
        return capacicity;
    }

    public void setCapacicity(int capacicity) {
        this.capacicity = capacicity;
    }

    public RoomTypeEnum getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(RoomTypeEnum typeRoom) {
        this.typeRoom = typeRoom;
    }

}
