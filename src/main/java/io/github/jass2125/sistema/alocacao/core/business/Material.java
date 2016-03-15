/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.sistema.alocacao.core.business;

/**
 *
 * @author Anderson Souza
 */
public class Material {

    private Long idMaterial;
    private String description;
    private int quantity;
    private int tombamento;
    private String status;
    private String materialRoom;

    public Material() {
    }

    public Material(String description, int quantity, int tombamento, String status, String materialRoom) {
        this.description = description;
        this.quantity = quantity;
        this.tombamento = tombamento;
        this.status = status;
        this.materialRoom = materialRoom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getIdMaterial() {
        return idMaterial;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTombamento() {
        return tombamento;
    }

    public String getStatus() {
        return status;
    }

    public String getMaterialRoom() {
        return materialRoom;
    }

    public void setTombamento(int tombamento) {
        this.tombamento = tombamento;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMaterialRoom(String materialRoom) {
        this.materialRoom = materialRoom;
    }

}
