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
public class EleitorTrans {
    public String nome;
    public int titulo,zona,secao,municipio;

    public EleitorTrans(String nome, int titulo, int zona, int secao, int municipio) {
        this.nome = nome;
        this.titulo = titulo;
        this.zona = zona;
        this.secao = secao;
        this.municipio = municipio;
    }

    public EleitorTrans(int titulo) {
        this.titulo = titulo;
    }
    
    
    
    
    
}
