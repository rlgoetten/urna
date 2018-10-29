/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho1.Controladores;

import br.ufsc.ine5605.trabalho1.Entidades.Municipio;
import br.ufsc.ine5605.trabalho1.Entidades.Secao;
import br.ufsc.ine5605.trabalho1.Entidades.TURNO;
import br.ufsc.ine5605.trabalho1.Entidades.Zona;
import br.ufsc.ine5605.trabalho1.Telas.TelaPrincipal;
import java.util.ArrayList;

/**
 *
 * @author jlehmkuhl
 */
public class ControladorPrincipal {
    private TelaPrincipal telaPrinc = new TelaPrincipal(this);
    private ControladorCandidatos ctrlCand = new ControladorCandidatos(this);
    private ControladorEleitores ctrlEleit = new ControladorEleitores(this);
    private ControladorLocaisDeVotacao ctrlLocais = new ControladorLocaisDeVotacao(this);
    private ControladorVotacao ctrlVotacao;
    //Depurador de votos
    //municipios
    //

    public ControladorLocaisDeVotacao getCtrlLocais() {
        return ctrlLocais;
    }    

    public ControladorCandidatos getCtrlCand() {
        return ctrlCand;
    }

    public ControladorEleitores getCtrlEleit() {
        return ctrlEleit;
    }
    
    public void exibirMenuPrincipal() {
        telaPrinc.exibirMenuPrincipal();
    }
    
    public void irParaCandidatos() {
        ctrlCand.exibirMenuCandidatos();
    }
    
    public void irParaEleitores() {
        ctrlEleit.exibirMenuEleitores();
    }
    
    public void irParaLocais() {
        ctrlLocais.exibirMenuLocais();
    }
    
    public void irParaVotacao() {
        ArrayList<Municipio> municipios = new ArrayList<>();
        municipios.add(ctrlLocais.getFpolis());
        municipios.add(ctrlLocais.getSaoJose());
        ctrlVotacao = new ControladorVotacao(this, ctrlCand.getCandGov(),ctrlCand.getCandDep(), municipios, TURNO.PRIMEIRO);
        ctrlVotacao.exibirTelaVotacao();       
    }
    
    public int retorneInteiro(int limSup) {
        return telaPrinc.retorneInteiro(limSup);
    }
    
}
