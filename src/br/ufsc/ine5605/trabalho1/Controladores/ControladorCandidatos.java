/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho1.Controladores;

import br.ufsc.ine5605.trabalho1.Entidades.PARTIDO;
import br.ufsc.ine5605.trabalho1.Entidades.CARGO;
import br.ufsc.ine5605.trabalho1.Entidades.CandTrans;
import br.ufsc.ine5605.trabalho1.Entidades.Candidato;
import br.ufsc.ine5605.trabalho1.Telas.TelaCandidatos;
import java.util.ArrayList;


public class ControladorCandidatos {
    private ControladorPrincipal ctrlPrincipal;
    private TelaCandidatos tela = new TelaCandidatos(this);
    private ArrayList<Candidato> candGov = new ArrayList<>();
    private ArrayList<Candidato> candDep = new ArrayList<>();
    
    public ControladorCandidatos(ControladorPrincipal ctrlPrincipal) {
        this.ctrlPrincipal = ctrlPrincipal;
        Candidato branco = new Candidato("branco",00,CARGO.DEPUTADO_ESTADUAL,PARTIDO.BRANCO);
        candDep.add(branco);
        Candidato brancoG = new Candidato("branco",00,CARGO.GOVERNADOR,PARTIDO.BRANCO);
        candGov.add(brancoG);
        Candidato brancoN = new Candidato("nulo",99,CARGO.DEPUTADO_ESTADUAL,PARTIDO.BRANCO);
        candDep.add(brancoN);
        Candidato brancoGN = new Candidato("nulo",99,CARGO.GOVERNADOR,PARTIDO.BRANCO);
        candGov.add(brancoGN);
    }

    public ControladorPrincipal getCtrlPrincipal() {
        return ctrlPrincipal;
    }
    
    public void voltarMenuPrincipal() {
        ctrlPrincipal.exibirMenuPrincipal();
    }
    
    public void exibirMenuCandidatos() {
        tela.exibirMenuCandidatos();
    }

    public ArrayList<Candidato> getCandGov() {
        return candGov;
    }

    public ArrayList<Candidato> getCandDep() {
        return candDep;
    }
    
    public Candidato getGovernadorByNum(int numero) {
        for (Candidato c : candGov) {
            if (c.getNumero() == numero) {
                return c;
            }
        }
        return null;
    }
    
    public Candidato getDeputadoByNum(int numero) {
        for (Candidato c : candDep) {
            if (c.getNumero() == numero) {
                return c;
            }
        }
        return null;
    }
    
    public void removerCandidato(CandTrans candT) {
        if (candT.cargo == CARGO.DEPUTADO_ESTADUAL) {
            candDep.remove(getDeputadoByNum(candT.num));
        } else {
            candGov.remove(getGovernadorByNum(candT.num));
        }
    }
       
    
    
    /***************** enviar dados para a tela*****************/
    
    public CandTrans retornarDeputadoParaTela(int num) {
        Candidato deputado = getDeputadoByNum(num);
        if (deputado != null){
            CandTrans deptTrans = new CandTrans(deputado.getNome(),deputado.getNumero(),deputado.getPartido(),deputado.getCargo());
            return deptTrans;
        }
        return null;
    }
    
    public CandTrans retornarGovernadorParaTela(int num) {
        Candidato governador = getGovernadorByNum(num);
        if (governador != null){
            CandTrans govTrans = new CandTrans(governador.getNome(),governador.getNumero(),governador.getPartido(),governador.getCargo());
            return govTrans;
        }
        return null;
    }
    
    public ArrayList<CandTrans> retornarDeputadosParaTela() {
        ArrayList<CandTrans> deputados = new ArrayList<>();
        for(Candidato candidato : candDep) {
            if(candidato != null) {
                CandTrans deputado = new CandTrans(candidato.getNome(),candidato.getNumero(),candidato.getPartido(),candidato.getCargo());
                deputados.add(deputado);
            }
        }
        return deputados;
    }
    
    public ArrayList<CandTrans> retornarGovernadoresParaTela() {
        ArrayList<CandTrans> governadores = new ArrayList<>();
        for(Candidato candidato : candGov) {
            if(candidato != null) {
                CandTrans governador = new CandTrans(candidato.getNome(),candidato.getNumero(),candidato.getPartido(),candidato.getCargo());
                governadores.add(governador);
            }
        }
        return governadores;
    }
    
    
    
       
    /* **************** Cadastro de Candidatos **************** */
    public String TratarNovoCandidato(CandTrans candidato) {
        if (candidato.num <= 98 && candidato.num >= 1) {
            if (candidato.cargo == CARGO.GOVERNADOR) {
                if (getGovernadorByNum(candidato.num) == null) {
                    addGovernador(candidato);
                    return "GOVERNADOR REGISTRADO COM SUCESSO";
                } else {
                    return "NUMERO JA REGISTRADO PARA GOVERNADOR";
                }              
            } else {
                if (candidato.cargo == CARGO.DEPUTADO_ESTADUAL) {
                    if(getDeputadoByNum(candidato.num) == null) {
                        addDeputado(candidato);
                        return "DEPUTADO REGISTRADO COM SUCESSO";
                    } else {
                        return "NUMERO JA REGISTRADO PARA DEPUTADO";
                    }           
                } else {
                        return "NUMERO DO CARGO INVALIDO";
                }
            }
        }
        return "NUMERO NAO PODE SER MENOR QUE 1 E MAIOR QUE 98";
    }
    
    private void addGovernador(CandTrans candidato) {
        Candidato governador = new Candidato(candidato.nome , candidato.num, candidato.cargo, candidato.partido);
        candGov.add(governador);
    }
    
    private void addDeputado(CandTrans candidato) {
        Candidato deputado = new Candidato(candidato.nome , candidato.num, candidato.cargo, candidato.partido);
        candDep.add(deputado);
    }
    
}
