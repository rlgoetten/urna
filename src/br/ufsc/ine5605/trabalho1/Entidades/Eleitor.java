/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho1.Entidades;

/**
 *
 * @author jlehmkuhl
 */
public class Eleitor {
    private String nome;
    private int titulo;
    Zona zona;
    Secao secao;
    Municipio municipio;

    public Eleitor(String nome, int titulo, Zona zona, Secao secao, Municipio municipio) {
        this.nome = nome;
        this.titulo = titulo;
        this.zona = zona;
        this.secao = secao;
        this.municipio = municipio;
    }

    public int getTitulo() {
        return titulo;
    }

    public String getNome() {
        return nome;
    }

    public Zona getZona() {
        return zona;
    }

    public Secao getSecao() {
        return secao;
    }

    public Municipio getMunicipio() {
        return municipio;
    }
    
    
    
    
    
    
    }
