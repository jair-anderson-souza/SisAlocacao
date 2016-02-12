/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.sistema.alocacao.core.business;

/**
 * Classe que representa o Feriado
 * @author Anderson Souza
 * @since 2015
 */
public class Feriado {
    private int idFeriado;
    private String descricao;
    private String dataDeFeriado;
    private int idUsuario;

    public Feriado() {
    }

    public Feriado(int idFeriado, String descricao, String dataDeFeriado, int idUsuario) {
        this(dataDeFeriado, descricao, idUsuario);
        this.idFeriado = idFeriado;
    }

    public Feriado(String dataDeFeriado, String descricao, int idUsuario) {
        this.dataDeFeriado = dataDeFeriado;
        this.descricao = descricao;
        this.idUsuario = idUsuario;
    }
    /**Metodo que retorna a descrição do feriado
     * @return descricao String
     */
    public String getDescricao() {
        return descricao;
    }
    /**
     * Metodo que altera a descrição do feriado
     * @param descricao Sring
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    /**
     * Metodo que retorna a data de feriado
     * @return dataDeFeriado String
     */
    public String getDataDeFeriado() {
        return dataDeFeriado;
    }
    
    /**
     * Metodo que altera a descrição do feriado
     * @param dataDeFeriado String 
     */
    public void setDataDeFeriado(String dataDeFeriado) {
        this.dataDeFeriado = dataDeFeriado;
    }
    
    /**
     * Metodo que retorna o id de feriado
     * @return idUsuario int
     */
    public int getIdUsuario() {
        return idUsuario;
    }
    /**
     * Metodo que retorna o id do feriado
     * @return idFeriado int
     */
    public int getIdFeriado() {
        return idFeriado;
    }
    

}
