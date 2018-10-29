/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho1.Controladores;

import br.ufsc.ine5605.trabalho1.Entidades.CARGO;
import br.ufsc.ine5605.trabalho1.Entidades.Candidato;
import br.ufsc.ine5605.trabalho1.Entidades.Eleitor;
import br.ufsc.ine5605.trabalho1.Entidades.EleitorTrans;
import br.ufsc.ine5605.trabalho1.Entidades.TURNO;
import br.ufsc.ine5605.trabalho1.Entidades.Urna;
import br.ufsc.ine5605.trabalho1.Telas.TelaUrna;
import java.util.ArrayList;

/**
 *
 * @author jlehmkuhl
 */
public class ControladorUrna {
    private TelaUrna tela = new TelaUrna(this);
    private ControladorVotacao ctrlVotacao;
    private Urna urna;
    private ArrayList<Eleitor> eleitoresVotaram = new ArrayList<>();
    private TURNO turno;

    public ControladorUrna(ControladorVotacao ctrlVotacao, Urna urna) {
        this.ctrlVotacao = ctrlVotacao;
        this.urna = urna;
    }

    public ControladorVotacao getCtrlVotacao() {
        return ctrlVotacao;
    }
    
    public void modoVotacao(TURNO turno) {
        this.turno = turno;
        while(urna.getSecao().getEleitores().size() > eleitoresVotaram.size()) {
            if(checarTitulo(tela.pedirTitulo())) {
                tela.pedirVoto(CARGO.DEPUTADO_ESTADUAL);
                tela.pedirVoto(CARGO.GOVERNADOR);
            }                        
        }    
        urna.setEleitoresVotaram(this.eleitoresVotaram);
    }
    
    private boolean checarTitulo(EleitorTrans eleitorT) {
        boolean eleitorAprovado = false;
        for (Eleitor eleitor : urna.getSecao().getEleitores()) {
            if(eleitor.getTitulo() == eleitorT.titulo && !eleitoresVotaram.contains(eleitor)) {
                eleitorAprovado = true;
                eleitoresVotaram.add(eleitor);
                break;
            }
        }
        return eleitorAprovado;
    }
    
    public String retorneCandidato(int num, CARGO cargo) {
        ArrayList<Candidato> arr = null;
        String retorne = "VOTO NULO";
        if (num == 0) {
            retorne = "VOTO BRANCO";
        } else {
            if (cargo == CARGO.DEPUTADO_ESTADUAL) {
                arr = ctrlVotacao.getCandDep();
            } else {
                if (cargo == CARGO.GOVERNADOR) {
                    arr = ctrlVotacao.getCandGov();
                }
            }
            for (Candidato candidato : arr) {
                if (candidato.getNumero() == num) {   
                    retorne = "NOME : " + candidato.getNome().toUpperCase() + "\nPARTIDO: " + candidato.getPartido() + "\nCARGO:" + candidato.getCargo();
                }
            }
        }
        return retorne;
    }
    
    public void finalizarUrna() {
        while(urna.getSecao().getEleitores().size() > eleitoresVotaram.size()) {
            fazerVoto(0,CARGO.DEPUTADO_ESTADUAL);
            fazerVoto(0, CARGO.GOVERNADOR);
            eleitoresVotaram.add(null);
        }
    }
    
   public boolean ehNulo(int num,CARGO cargo) {
       ArrayList<Candidato> arr;
        if (cargo == CARGO.DEPUTADO_ESTADUAL) {
            arr = ctrlVotacao.getCandDep();
        } else {
            arr = ctrlVotacao.getCandGov();
        }
        for (Candidato candidato : arr) {
            if (candidato.getNumero() == num) {
                return false;
            }
        }
        return true;
   }
    
    public void fazerVoto(int num,CARGO cargo) {
        
        if (cargo == CARGO.DEPUTADO_ESTADUAL) {
            for(Candidato c :ctrlVotacao.getCandDep()) {
                if (c.getNumero() == num) {
                    c.addVoto(urna.getMunicipio());
                }
            }            
        } else {
            for(Candidato c :ctrlVotacao.getCandGov()) {
                if (c.getNumero() == num) {
                    c.addVoto(urna.getMunicipio());
                }
            }  

        }
    }
        
    
}
