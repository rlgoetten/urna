/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho1.Entidades;

import br.ufsc.ine5605.trabalho1.Controladores.ControladorUrna;
import java.util.ArrayList;

/**
 *
 * @author pablothobias
 */
public class Urna {
    private ControladorUrna ctrl;
    private Secao secao;
    private Zona zona;
    private Municipio municipio;
    private ArrayList<Eleitor> eleitoresVotaram = new ArrayList<>();    
    
    public Urna(Secao secao, Zona zona, Municipio municipio) {
        this.secao = secao;
        this.zona = zona;
        this.municipio = municipio;
        
    }

    public ArrayList<Eleitor> getEleitoresVotaram() {
        return eleitoresVotaram;
    }

    public void setEleitoresVotaram(ArrayList<Eleitor> eleitoresVotaram) {
        this.eleitoresVotaram = eleitoresVotaram;
    }
  
    public Secao getSecao() {
        return secao;
    }

    public Zona getZona() {
        return zona;
    }

    public Municipio getMunicipio() {
        return municipio;
    }
    
    
    
    
    
}
