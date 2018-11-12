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
public class Secao {
    private ArrayList<Eleitor> eleitores = new ArrayList();
    private int numSec;
    
    public Secao(int numSec) {
        this.numSec = numSec;
    }

    public ArrayList<Eleitor> getEleitores() {
        return eleitores;
    }

    public int getNumSec() {
        return numSec;
    }
    
    public void addEleitor(Eleitor eleitor) {
        if (eleitor != null && !eleitores.contains(eleitor)) {
            eleitores.add(eleitor);
        }
    }
    
    
}
