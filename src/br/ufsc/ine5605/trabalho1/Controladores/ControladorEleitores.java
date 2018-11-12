/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho1.Controladores;

import br.ufsc.ine5605.trabalho1.Entidades.Eleitor;
import br.ufsc.ine5605.trabalho1.Entidades.EleitorTrans;
import br.ufsc.ine5605.trabalho1.Entidades.Florianopolis;
import br.ufsc.ine5605.trabalho1.Entidades.Municipio;
import br.ufsc.ine5605.trabalho1.Entidades.SaoJose;
import br.ufsc.ine5605.trabalho1.Entidades.Secao;
import br.ufsc.ine5605.trabalho1.Entidades.Zona;
import br.ufsc.ine5605.trabalho1.Telas.TelaEleitores;
import java.util.ArrayList;

/**
 *
 * @author pablothobias
 */
public class ControladorEleitores {
    private ControladorPrincipal ctrlPrincipal;
    private TelaEleitores tela = new TelaEleitores(this);
    private ArrayList<Eleitor> eleitores = new ArrayList<>();

    public ControladorEleitores(ControladorPrincipal ctrlPrincipal) {
        this.ctrlPrincipal = ctrlPrincipal;
    }
    
    public Eleitor getEleitorByTitulo(int titulo) {
        for (Eleitor eleitor : eleitores) {
            if (eleitor.getTitulo() == titulo) {
                return eleitor;
            }
        }
        return null;
    }
    
    public void voltarMenuPrincipal() {
        ctrlPrincipal.exibirMenuPrincipal();
    }
    
    public void exibirMenuEleitores() {
        tela.exibirMenuEleitores();
    }
    
    public String tratarNovoEleitor(EleitorTrans eleitor){
        Zona zona;
        Secao secao;
        Municipio municipio;
        if(eleitor!= null && getEleitorByTitulo(eleitor.titulo) == null) {
            if(eleitor.municipio == 1) {
                zona = ctrlPrincipal.getCtrlLocais().getFpolis().getZonaByNum(eleitor.zona);
                municipio = (Florianopolis)ctrlPrincipal.getCtrlLocais().getFpolis();
            } else {
                zona = ctrlPrincipal.getCtrlLocais().getSaoJose().getZonaByNum(eleitor.zona);
                municipio = (SaoJose)ctrlPrincipal.getCtrlLocais().getSaoJose();
            }
            if (zona != null) {
                secao = zona.getSecaoByNum(eleitor.secao);
                if (secao != null) {
                    Eleitor e = new Eleitor(eleitor.nome,eleitor.titulo,zona,secao,municipio);
                    secao.addEleitor(e);
                    eleitores.add(e);
                    return "ELEITOR CADASTRADO COM SUCESSO.";
                }
                return "SECAO AINDA NAO CADASTRADA, POR FAVOR INFORME UMA SECAO VALIDA.";
            }
            return "ZONA AINDA NAO CADASTRADA, POR FAVOR INFORME UMA ZONA VALIDA.";
        }
        return "TITULO JA ESTA EM USO.";
    }
    
    public EleitorTrans exibirEleitorbyTitulo(EleitorTrans eleitorTrans) {
        Eleitor eleitor = getEleitorByTitulo(eleitorTrans.titulo);
        if (eleitor != null) {
            int municipio;
            if (eleitor.getMunicipio().equals(ctrlPrincipal.getCtrlLocais().getFpolis())) {
                municipio = 1;
            } else {
                municipio = 2;
            }
            EleitorTrans eTrans = new EleitorTrans(eleitor.getNome(),eleitor.getTitulo(),eleitor.getZona().getNumZona(),eleitor.getSecao().getNumSec(),municipio);
            return eTrans;
        }
        return null;
    }
    
}
