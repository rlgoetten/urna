/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho1.Controladores;

import br.ufsc.ine5605.trabalho1.Entidades.Florianopolis;
import br.ufsc.ine5605.trabalho1.Entidades.Municipio;
import br.ufsc.ine5605.trabalho1.Entidades.SaoJose;
import br.ufsc.ine5605.trabalho1.Entidades.Secao;
import br.ufsc.ine5605.trabalho1.Entidades.Zona;
import br.ufsc.ine5605.trabalho1.Entidades.ZonaTrans;
import br.ufsc.ine5605.trabalho1.Telas.TelaLocaisDeVotacao;
import java.util.ArrayList;

/**
 *
 * @author pablothobias
 */
 public class ControladorLocaisDeVotacao {
    
    private ControladorPrincipal ctrlPrincipal;
    private TelaLocaisDeVotacao tela = new TelaLocaisDeVotacao(this);
    private Florianopolis fpolis = new Florianopolis();
    private SaoJose saojose = new SaoJose();

     
     public ControladorLocaisDeVotacao(ControladorPrincipal ctrlPrincipal){
         this.ctrlPrincipal=ctrlPrincipal;
     }

    public Florianopolis getFpolis() {
        return fpolis;
    }

    public SaoJose getSaoJose() {
        return saojose;
    }

    public void voltarMenuPrincipal() {
        ctrlPrincipal.exibirMenuPrincipal();
    }

    public void exibirMenuLocais() {
        tela.exibirMenuLocais();
    }
    
    public String addSecao(ZonaTrans zonaT){
         
        if (zonaT != null) {
            Municipio municipio;
            if (zonaT.municipio == 1) {
                municipio = fpolis;
            } else {
                municipio = saojose;
            }
            if (municipio.getZonaByNum(zonaT.numZon) == null && !zonaT.ExisteZona) {
                Zona zona = new Zona(zonaT.numZon);
                municipio.addZona(zona);
                Secao secao = new Secao(zonaT.numSec);
                zona.addSecao(secao);
                return "ZONA E SECAO CADASTRADAS COM SUCESSO.";
            } else {
                if (municipio.getZonaByNum(zonaT.numZon) != null && zonaT.ExisteZona) {
                    if (municipio.getZonaByNum(zonaT.numZon).getSecaoByNum(zonaT.numSec) == null) {
                        Secao secao = new Secao(zonaT.numSec);
                        municipio.getZonaByNum(zonaT.numZon).addSecao(secao);
                        return "SECAO CADASTRADA COM SUCESSO";
                    }
                    return "SECAO JA HAVIA SIDO CADASTRADA.";
                } else {
                    if (municipio.getZonaByNum(zonaT.numZon) != null && !zonaT.ExisteZona) {
                        return "ZONA JA HAVIA SIDO CADASTRADA.";
                    }
                }
            }
        }
        return "ZONA INFORMADA NAO EXISTE, TENTE NOVAMENTE";
    
    
    }
    
    public String exibirLocais(){
         String retorno;
        retorno = fpolis.exibirSecoes();
        retorno += "\n\n";
        retorno += saojose.exibirSecoes();
        return retorno;     
    }
    
}