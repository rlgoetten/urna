/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho1.Controladores;

import br.ufsc.ine5605.trabalho1.Entidades.CARGO;
import br.ufsc.ine5605.trabalho1.Entidades.Candidato;
import br.ufsc.ine5605.trabalho1.Entidades.Municipio;
import br.ufsc.ine5605.trabalho1.Entidades.PARTIDO;
import br.ufsc.ine5605.trabalho1.Entidades.Secao;
import br.ufsc.ine5605.trabalho1.Entidades.TURNO;
import br.ufsc.ine5605.trabalho1.Entidades.Urna;
import br.ufsc.ine5605.trabalho1.Entidades.Zona;
import br.ufsc.ine5605.trabalho1.Telas.TelaVotacao;
import java.util.ArrayList;

/**
 *
 * @author pablothobias
 */
public class ControladorVotacao {
    private TelaVotacao tela = new TelaVotacao(this);
    private ControladorPrincipal ctrlPrinc;
    private ArrayList<Candidato> candGov;
    private ArrayList<Candidato> candDep;
    private ArrayList<Urna> urnas = new ArrayList();
    private TURNO turno;
    int votosPSTU = 0;
    int votosPSOL = 0;
    
    private ArrayList<Candidato> segundoTurno = new ArrayList<>();
    
    public ControladorVotacao(ControladorPrincipal ctrlPrinc, ArrayList<Candidato> candGov, ArrayList<Candidato> candDep, ArrayList<Municipio> municipios, TURNO turno) {
        this.ctrlPrinc = ctrlPrinc;
        this.candGov = candGov;
        this.candDep = candDep;
        this.turno = turno;
        for (Municipio municipio : municipios) {
            for (Zona zona : municipio.getZona()) {
                for (Secao secao : zona.getSecoes()) {
                    Urna urna = new Urna(secao, zona, municipio);
                    urnas.add(urna);
                }
            }   
        }  
    }   

    public ControladorPrincipal getCtrlPrinc() {
        return ctrlPrinc;
    }
       
    public ArrayList<Candidato> getCandGov() {
        return candGov;
    }

    public ArrayList<Candidato> getCandDep() {
        return candDep;
    }
    
    public void exibirTelaVotacao() {
        tela.exibirMenuVotacao();
    }
    
    public String listarUrnas() {
        int i = 1;
        String lista = "";
        for (Urna urna : urnas) {
            lista += i + ". " + urna.getMunicipio().getNome().toUpperCase() + " - ZONA: " + urna.getZona().getNumZona() + " - SECAO: " + urna.getSecao().getNumSec();
            if (urna.getSecao().getEleitores().size() == urna.getEleitoresVotaram().size()) {
                lista+= " - VOTACAO JA REALIZADA";
            }
            i++;
            lista += "\n";
        }
        lista += urnas.size()+1 + ".VOLTAR";
        return lista;
    }
    
    public void irParaUrna(int opcao) {
        if (opcao >= 0 && opcao < urnas.size()) {
            if (urnas.get(opcao).getEleitoresVotaram().size() != urnas.get(opcao).getSecao().getEleitores().size()) {
                ControladorUrna ctrlUrna = new ControladorUrna(this, urnas.get(opcao));
                ctrlUrna.modoVotacao(turno);
                exibirTelaVotacao();
            } else {              
                exibirTelaVotacao();
            }
        } else {

            exibirTelaVotacao();
        }
    }
   
    
    public void finalizarTurno() {
        this.turno = TURNO.SEGUNDO;
        exibirTelaVotacao();
    }
    
    public int[] calcularTotalFloripa() {
        int[] votosFloripa = new int[6];
        for(Candidato candidato : candDep) {
            if(candidato.getNumero() == 0) {
                votosFloripa[1] += candidato.getVotosFloripa();
            } else {
                if (candidato.getNumero() == 99) {
                    votosFloripa[2] += candidato.getVotosFloripa();
                } else {
                    votosFloripa[0] += candidato.getVotosFloripa();
                }
            }
        }
        
        for(Candidato candidato : candGov) {
            if(candidato.getNumero() == 0) {
                votosFloripa[4] += candidato.getVotosFloripa();
            } else {
                if (candidato.getNumero() == 99) {
                    votosFloripa[5] += candidato.getVotosFloripa();
                } else {
                    votosFloripa[3] += candidato.getVotosFloripa();
                }
            }
        }
        return votosFloripa;
    }
    
    public int[] calcularTotalSaoJose() {
        int[] votosSaoJose = new int[6];
        for(Candidato candidato : candDep) {
            if(candidato.getNumero() == 0) {
                votosSaoJose[1] += candidato.getVotosSaoJose();
            } else {
                if (candidato.getNumero() == 99) {
                    votosSaoJose[2] += candidato.getVotosSaoJose();
                } else {
                    votosSaoJose[0] += candidato.getVotosSaoJose();
                }
            }
        }
        
        for(Candidato candidato : candGov) {
            if(candidato.getNumero() == 0) {
                votosSaoJose[4] += candidato.getVotosSaoJose();
            } else {
                if (candidato.getNumero() == 99) {
                    votosSaoJose[5] += candidato.getVotosSaoJose();
                } else {
                    votosSaoJose[3] += candidato.getVotosSaoJose();
                }
            }
        }
        return votosSaoJose;
    }
    
    public int calcularTotalValidos(){
        int totalValidos = 0;
        for (Candidato c : candDep) {
            if(c.getNumero() != 0 && c.getNumero() != 99){
                totalValidos += c.getVotosFloripa()+c.getVotosSaoJose();
            }
        }
        return totalValidos;
    }
    
    public int calcularVagas(PARTIDO partido, int votos){
        if(votos ==0) {
            votos = 1;
        }
        int votosPartido = 0;
        for (Candidato c : candDep) {
            if(c.getPartido() == partido) {
                votosPartido += c.totalVotos();
            }
        }
        votosPartido *= 3;
        float vagas = votosPartido/votos;
        return Math.round(vagas-0.01f);
    }
    
    public String votosPorCandidato() {
        String retorne = "VOTOS GOVERNADOR EM FLORIANOPOLIS:\n";
        for (Candidato c : candGov) {
            retorne += c.getNome() + ": " + c.getVotosFloripa() + "\n";
        }
        
        retorne += "\nVOTOS EM DEPUTADO EM FLORIANOPOLIS:\n";
        for (Candidato c : candDep) {
            retorne += c.getNome() + ": " + c.getVotosFloripa() + "\n";
        }
        
        retorne += "VOTOS GOVERNADOR EM SAO JOSE:\n";
        for (Candidato c : candGov) {
            retorne += c.getNome() + ": " + c.getVotosSaoJose() + "\n";
        }
        
        retorne += "\nVOTOS EM DEPUTADO EM SAO JOSE:\n";
        for (Candidato c : candDep) {
            retorne += c.getNome() + ": " + c.getVotosSaoJose() + "\n";
        }
            
        
        retorne += "\nGOVERNADOR TOTAL:\n";
        for (Candidato c : candGov) {
            retorne += c.getNome() + ": " + (c.getVotosFloripa()+c.getVotosSaoJose()) + "\n";
        }
        
        retorne += "\nDEPUTADO TOTAL:\n";
        for (Candidato c : candDep) {
            retorne += c.getNome() + ": " + (c.getVotosFloripa()+c.getVotosSaoJose()) + "\n";
        }
        return retorne;
    }
    
    public String[] deputadosEleitos(int vagas, PARTIDO partido) {
        if(vagas>0) {
            ArrayList<Candidato> candPart = new ArrayList<>();
            Candidato aux;
            for(Candidato c : candDep) {
                if (c.getPartido() == partido) {
                    candPart.add(c);
                }
            }
            for(int i = 0; i<candPart.size()-1; i++) {
                if(candPart.get(i).totalVotos()<candPart.get(i+1).totalVotos()){
                    aux = candPart.get(i);
                    candPart.set(i, candPart.get(i+1));
                    candPart.set(i+1, aux);
                }
            }
            for(Candidato c: candPart) {
                System.out.println(c.totalVotos());
            }
            String[] eleitos = new String[vagas];
            for(int i = 0; i<vagas; i++) {
                eleitos[i] = candPart.get(i).getNome();
            }
            return eleitos;
        }
        return null;
    }
    
    public String resultadoGovernadores() {
        ArrayList<Candidato> candPart = new ArrayList<>();
        candPart.addAll(candGov);
        Candidato aux;
        for(int i = 0; i<candPart.size()-1; i++) {
            if(candPart.get(i).totalVotos()<candPart.get(i+1).totalVotos()){
                aux = candPart.get(i);
                candPart.set(i, candPart.get(i+1));
                candPart.set(i+1, aux);
            } 
        }
        int r1=0,r2 = 1;
        while(candPart.get(r1).getNumero() == 0 || candPart.get(r1).getNumero() == 99) {
            r1++;
        }
        while((candPart.get(r2).getNumero() == 0 || candPart.get(r2).getNumero() == 99)  && r2 != r1) {
            r2++;
        }
        
        
        return "Os 2 Governadores com o maior numero de votos foram: \n" + candPart.get(r1).getNome() + " com " + candPart.get(r1).totalVotos() + "votos.\nE " + candPart.get(r2).getNome() + " com " + candPart.get(r2).totalVotos();
    }
}
