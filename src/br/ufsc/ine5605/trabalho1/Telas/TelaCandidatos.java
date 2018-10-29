/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho1.Telas;

import br.ufsc.ine5605.trabalho1.Controladores.ControladorCandidatos;
import br.ufsc.ine5605.trabalho1.Entidades.CARGO;
import br.ufsc.ine5605.trabalho1.Entidades.CandTrans;
import br.ufsc.ine5605.trabalho1.Entidades.PARTIDO;
import java.util.ArrayList;
import java.util.Scanner;


public class TelaCandidatos {
    private ControladorCandidatos ctrl;
    private Scanner scanner = new Scanner(System.in);
    
    public TelaCandidatos(ControladorCandidatos ctrl) {
        this.ctrl = ctrl;
    }
    
    public void exibirMenuCandidatos(){
        int opcao = 0;
        System.out.println(" MENU CANDIDATOS");
        System.out.println("1. CADASTRAR CANDIDATO");
        System.out.println("2. EXIBIR DEPUTADO PELO NUMERO ");
        System.out.println("3. EXIBIR GOVERNADOR PELO NUMERO ");
        System.out.println("4. EXIBIR DEPUTADOS CADASTRADOS ");
        System.out.println("5. EXIBIR GOVERNADORES CADASTRADOS ");
        System.out.println("6. REMOVER CANDIDATO ");
        System.out.println("7. VOLTAR PARA MENU PRINCIPAL ");
        opcao = ctrl.getCtrlPrincipal().retorneInteiro(7);
        System.out.println("");
        switch(opcao) {
            case 1:
                cadastrarCandidato();
                break;
            case 2:
                exibirDeputadoByNum();
                break;
            case 3:
                exibirGovernadorByNum();
                break;
            case 4:
                exibirDeputados();
                break;
            case 5:
                exibirGovernadores();
                break;
            case 6:
                removerCandidato();
                break;
            case 7:
                ctrl.voltarMenuPrincipal();
                break;
        }
    }
    
    private void cadastrarCandidato() {
        String nome;
        int opcao,num;
        PARTIDO partido = PARTIDO.PSOL;
        CARGO cargo = CARGO.DEPUTADO_ESTADUAL;
        
        System.out.println("DIGITE O NOME DO CANDIDATO: ");
        nome = scanner.nextLine();
        System.out.println();
        System.out.println("QUAL O NUMERO DO CANDIDATO: ");
        num = ctrl.getCtrlPrincipal().retorneInteiro(98);
        System.out.println();
        System.out.println("DIGITE O NUMERO CORRESPONDENTE AO PARTIDO DO CANDIDATO: ");
        System.out.println("1. PSOL ");
        System.out.println("2. PSTU");
        System.out.println("3.VOLTAR");
        opcao = ctrl.getCtrlPrincipal().retorneInteiro(3);
        
        if (opcao == 1) {
            partido = PARTIDO.PSOL;
        } else {
            if (opcao == 2) {
                partido = PARTIDO.PSTU;
            } else {
                exibirMenuCandidatos();
            }
        }     
        System.out.println();
        System.out.println("DIGITE O NUMERO CORRESPONDENTE AO CARGO DO CANDIDATO: ");
        System.out.println("1. GOVERNADOR ");
        System.out.println("2. DEPUTADO FEDERAL");
        System.out.println("3.VOLTAR");
        opcao = ctrl.getCtrlPrincipal().retorneInteiro(3);
        
        if (opcao == 1) {
            cargo = CARGO.GOVERNADOR;
        } else {
            if (opcao == 2) {
                cargo = CARGO.DEPUTADO_ESTADUAL;
            } else {
                exibirMenuCandidatos();
            }
        }
        
        System.out.println();
        CandTrans candidato = new CandTrans(nome, num, partido, cargo);
        System.out.println(ctrl.TratarNovoCandidato(candidato));
        System.out.println("");
        exibirMenuCandidatos();
    }
    
   private void exibirDeputadoByNum() {
        int num;
        System.out.println("INFORME O NUMERO DO DEPUTADO: ");
        num = ctrl.getCtrlPrincipal().retorneInteiro(98);
        System.out.println("");
        CandTrans deputado = ctrl.retornarDeputadoParaTela(num);
        if (deputado != null) {
            System.out.println("NOME : " + deputado.nome );
            System.out.println("NUMERO: " + deputado.num );
            System.out.println("PARTIDO:" + deputado.partido);
            System.out.println("CARGO: " + deputado.cargo );
            System.out.println("");
            exibirMenuCandidatos();
        } else {
            System.out.println("NUMERO NAO CADASTRADO: ");
            System.out.println("");
            exibirMenuCandidatos();
        }
   }
   
   private void exibirGovernadorByNum() {
        int num;
        System.out.println("INFORME O NUMERO DO OVERNADOR: ");
        num = ctrl.getCtrlPrincipal().retorneInteiro(98);
        System.out.println("");
        CandTrans governador = ctrl.retornarGovernadorParaTela(num);
        if (governador != null) {
            System.out.println("Nome : " + governador.nome );
            System.out.println("Numero: " + governador.num );
            System.out.println("Partido:" + governador.partido);
            System.out.println("Cargo: " + governador.cargo );
            System.out.println("");
            exibirMenuCandidatos();
        } else {
            System.out.println("NUMERO NAO CADASTRADO: ");
            System.out.println("");
            exibirMenuCandidatos();
        }
   }
   
    private void exibirDeputados() {
        ArrayList<CandTrans> deputados = ctrl.retornarDeputadosParaTela();
        if(deputados.size() > 0) {
            for (CandTrans deputado : deputados) {
                System.out.println("NOME : " + deputado.nome );
                System.out.println("NUMERO: " + deputado.num );
                System.out.println("PARTIDO:" + deputado.partido);
                System.out.println("CARGO: " + deputado.cargo );
                System.out.println("");
                }

            } else {
                System.out.println("NENHUM DEPUTADO CADASTRADO ");
                System.out.println("");
            }
        exibirMenuCandidatos();
        }
    
    private void exibirGovernadores() {
       ArrayList<CandTrans> governadores = ctrl.retornarGovernadoresParaTela();
        if(governadores.size() > 0) {
            for (CandTrans governador : governadores) {
                System.out.println("Nome : " + governador.nome );
                System.out.println("Numero: " + governador.num );
                System.out.println("Partido:" + governador.partido);
                System.out.println("Cargo: " + governador.cargo );
                System.out.println("");
                }

            } else {
                System.out.println("NENHUM GOVERNADOR CADASTRADO ");
                System.out.println("");
            }
        exibirMenuCandidatos();
        }
    
    private void removerCandidato() {
        int num, opcao;
        CARGO cargo = null;
        boolean candidatoExiste = false;
        System.out.println("INSIRA O NUMERO DO CANDIDATO");
        num =  ctrl.getCtrlPrincipal().retorneInteiro(98);
        System.out.println("1. GOVERNADOR ");
        System.out.println("2. DEPUTADO FEDERAL");
        System.out.println("3.VOLTAR");
        opcao = ctrl.getCtrlPrincipal().retorneInteiro(3);
        System.out.println("");
        
        if (opcao == 1) {
            cargo = CARGO.GOVERNADOR;
            if(ctrl.retornarGovernadorParaTela(num)== null) {
                System.out.println("NAO EXISTE GOVERNADOR COM ESSE NUMERO");
                System.out.println("");
                exibirMenuCandidatos();
            } else {
                System.out.println(ctrl.retornarGovernadorParaTela(num).nome);
            }
        } else {
            if (opcao == 2) {
                cargo = CARGO.DEPUTADO_ESTADUAL;
                if(ctrl.retornarDeputadoParaTela(num)== null) {
                    System.out.println("NAO EXISTE DEPUTADO COM ESSE NUMERO");
                    System.out.println("");
                    exibirMenuCandidatos();
                } else {
                System.out.println(ctrl.retornarDeputadoParaTela(num).nome);
                }
            } else {
                exibirMenuCandidatos();
            }
        }
        System.out.println("DESEJA MESMO REMOVER ESTE CANDIDATO? ");
        System.out.println("1.SIM");
        System.out.println("2.NAO");
        opcao = ctrl.getCtrlPrincipal().retorneInteiro(2);
        System.out.println("");
        if (opcao == 1) {            
            CandTrans candT = new CandTrans(num,cargo);
            ctrl.removerCandidato(candT);
            System.out.println("CANDIDATO REMOVIDO");
            System.out.println("");
        } 
        exibirMenuCandidatos();
    }
        
   
}
