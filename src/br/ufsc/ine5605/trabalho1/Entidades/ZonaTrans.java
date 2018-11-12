/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho1.Entidades;

/**
 *
 * @author pablothobias
 */
public class ZonaTrans {

    public int municipio;
    public int numSec;
    public int numZon;
    public boolean ExisteZona;

    
    public ZonaTrans(int municipio, int numSecao, int numZona, boolean ExisteZona) {
        this.municipio = municipio;
        this.numSec = numSecao;
        this.numZon = numZona;
        this.ExisteZona = ExisteZona;
    }
    
}
