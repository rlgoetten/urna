/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho1.Entidades;

import java.util.ArrayList;

/**
 *
 * @author pablothobias
 */
public abstract class Municipio {
    
    private String nome;
    private ArrayList<Zona>zonas = new ArrayList<>();
  
    
   public Municipio(String nome){
       this.nome=nome;
   
    }
   
   public void addZona(Zona zona){
    if(zona != null && !zonas.contains(zona)) {
            zonas.add(zona);
        }
   
   }
   
   public String getNome(){
       return nome;
   
   }
   
  public ArrayList<Zona> getZona(){
      return zonas;
 
  }
   
    public String exibirSecoes() {
        ArrayList<Secao>secoes;
        String retorno = nome + ": ";
        for(Zona zona : zonas) {
            retorno += "\n ZONA (" + zona.getNumZona()+ ")- SECOES:";
            secoes = zona.getSecoes();
            for (Secao secao : secoes) {
                retorno += " " + secao.getNumSec();
            }
            retorno += ".";
        }
        return retorno;
    }
    
    public Zona getZonaByNum(int num) {
        for (Zona zona : zonas) {
            if (zona.getNumZona()== num) {
                return zona;
            }
        }
        return null;
    }
}
