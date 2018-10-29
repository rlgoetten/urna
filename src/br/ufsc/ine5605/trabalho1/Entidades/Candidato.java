/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho1.Entidades;


public class Candidato {
    private String nome;
    private int numero;
    private CARGO cargo;
    private PARTIDO partido;
    private int votosFloripa = 0;
    private int votosSaoJose = 0;

    public Candidato(String nome, int numero, CARGO cargo, PARTIDO partido) {
        this.nome = nome;
        this.numero = numero;
        this.cargo = cargo;
        this.partido = partido;
    }

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public CARGO getCargo() {
        return cargo;
    }

    public PARTIDO getPartido() {
        return partido;
    }

    public int getVotosFloripa() {
        return votosFloripa;
    }
    
    public int getVotosSaoJose() {
        return votosSaoJose;
    }
    
    public int totalVotos() {
        return votosFloripa+votosSaoJose;
    }
    
    public void addVoto(Municipio municipio) {
        if (municipio.getNome() == "Florianopolis") {
            votosFloripa++;
        } else {
            votosSaoJose++;
        }
    }

    public void resetVotos() {
        votosFloripa = 0;
        votosSaoJose = 0;
    }
    
    public void addVotoFloripa(){
        votosFloripa++;
    }
    
    public void addVotoSaoJose(){
        votosSaoJose++;
    }
    
}
