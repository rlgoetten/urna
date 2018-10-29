/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho1.Entidades;


public class CandTrans {
    
    public String nome;
    public int num;
    public PARTIDO partido;
    public CARGO cargo;

    public CandTrans(String nome, int num, PARTIDO partido, CARGO cargo) {
        this.nome = nome;
        this.num = num;
        this.partido = partido;
        this.cargo = cargo;
    }
    
    public CandTrans(int num, CARGO cargo) {
        this.cargo = cargo;
        this.num = num;
    }
    
    
    
    
    
    
    
    
    
}

