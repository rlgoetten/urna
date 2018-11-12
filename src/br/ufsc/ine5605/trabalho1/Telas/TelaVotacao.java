/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho1.Telas;

import br.ufsc.ine5605.trabalho1.Controladores.ControladorLocaisDeVotacao;
import br.ufsc.ine5605.trabalho1.Controladores.ControladorVotacao;
import br.ufsc.ine5605.trabalho1.Entidades.Candidato;
import br.ufsc.ine5605.trabalho1.Entidades.PARTIDO;
import br.ufsc.ine5605.trabalho1.Entidades.ZonaTrans;
import java.util.Scanner;

/**
 *
 * @author pablothobias
 */
public class TelaVotacao {
    private Scanner scanner = new Scanner(System.in);
    private ControladorVotacao ctrl;

    public TelaVotacao(ControladorVotacao ctrl) {
        this.ctrl = ctrl;
    }
    
    public void exibirMenuVotacao() {
        int opcao;
        System.out.println("MENU VOTACAO");
        System.out.println("1.INICIAR TURNO");
        System.out.println("2.FINALIZAR TURNO");
        System.out.println("3.RELATORIO DE VOTOS");
        System.out.println("4.SAIR");
        opcao = ctrl.getCtrlPrinc().retorneInteiro(4);
        System.out.println("");
        
        switch(opcao) {
            case 1:
                selecionarUrna();
                break;
            case 2:
                ctrl.finalizarTurno();
                break;
            case 3:
                imprimirRelatorio();
                break;
        }
    }
    
    private void selecionarUrna() {
        int opcao;
        System.out.println("SELECIONE A URNA PARA VOTACAO");
        System.out.println(ctrl.listarUrnas());
        opcao = ctrl.getCtrlPrinc().retorneInteiro(9999)-1;
        ctrl.irParaUrna(opcao);
    }
    
    private void imprimirRelatorio() {
        int vagasPSTU, vagasPSOL, totalVotosValidos;
        System.out.println(ctrl.votosPorCandidato());
        
        
        totalVotosValidos = ctrl.calcularTotalValidos();
        vagasPSTU = ctrl.calcularVagas(PARTIDO.PSTU,totalVotosValidos);
        vagasPSOL = ctrl.calcularVagas(PARTIDO.PSOL,totalVotosValidos);
        System.out.println("");
        System.out.println("O TOTAL DE VOTOS VALIDOS FOI DE : " + totalVotosValidos + "."); 
        System.out.println("VAGAS PARA DEPUTADOS DO PSTU : " + vagasPSTU + ". VAGAS PARA DEPUTADOS DO PSOL " + vagasPSOL + ".");
        
        
        
        String[] eleitosPSTU = ctrl.deputadosEleitos(vagasPSTU,PARTIDO.PSTU);
        String[] eleitosPSOL = ctrl.deputadosEleitos(vagasPSOL,PARTIDO.PSOL);
        
        if(eleitosPSTU != null){
            System.out.println("DEPUTADOS ELEITOS DO PSTU: " );
            for(int i = 0; i<eleitosPSTU.length; i++){
                System.out.println(eleitosPSTU[i]);
            }
        }
        System.out.println("");
      
        if(eleitosPSOL != null){
            System.out.println("DEPUTADOS ELEITOS DO PSOL: " );
            for(int i = 0; i<eleitosPSOL.length; i++){
                System.out.println(eleitosPSOL[i]);
            }
        }
        System.out.println("");
        
        System.out.println(ctrl.resultadoGovernadores());
        
        exibirMenuVotacao();
    }
  
}