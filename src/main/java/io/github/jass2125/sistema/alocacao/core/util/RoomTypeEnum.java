/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.util;

/**
 *
 * @author Anderson Souza
 */
public enum RoomTypeEnum {

    COMUM("Comum"), LABORATÓRIO("Laboratório"), OFICINA("Oficina"), INTELIGENTE("Inteligente");

    private String type;
    private RoomTypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    

}
