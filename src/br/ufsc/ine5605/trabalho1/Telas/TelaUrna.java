/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho1.Telas;

import br.ufsc.ine5605.trabalho1.Controladores.ControladorUrna;
import br.ufsc.ine5605.trabalho1.Entidades.CARGO;
import br.ufsc.ine5605.trabalho1.Entidades.EleitorTrans;
import java.util.Scanner;

/**
 *
 * @author pablothobias
 */
public class TelaUrna {
    private Scanner scanner = new Scanner(System.in);
    private ControladorUrna ctrl;

    public TelaUrna(ControladorUrna ctrl) {
        this.ctrl = ctrl;
    }
    
    public EleitorTrans pedirTitulo() {
        int titulo;
        System.out.println("DIGITE O NUMERO DO TITULO DE ELEITOR");
        System.out.println("OU DIGITE 9999 PARA ENCERRAR A URNA, O RESTANTE DOS VOTOS SERAO CONSIDERADOS BRANCOS");
        titulo = ctrl.getCtrlVotacao().getCtrlPrinc().retorneInteiro(9999);
        System.out.println("");
        if (titulo == 9999) {
            ctrl.finalizarUrna();
        }
        EleitorTrans eleitorT = new EleitorTrans(titulo);
        return eleitorT;
    }
    
    public void pedirVoto(CARGO cargo) {
        int num = -1;
        int opcao;
        System.out.println("INFORME O NUMERO DO CANDIDATO A " + cargo+ " DESEJADO");
        while( num > 9999 || num < 0){
            while(!scanner.hasNextInt()) {
                scanner.next();
            }
            num = scanner.nextInt();
        }
        System.out.println(ctrl.retorneCandidato(num,cargo));
        System.out.println("CONFIRMA VOTO:");
        System.out.println("1.SIM");
        System.out.println("2.NAO");
        opcao = ctrl.getCtrlVotacao().getCtrlPrinc().retorneInteiro(2);
        if (opcao == 1) {
            ctrl.fazerVoto(num,cargo);
            System.out.println("");
        } else {
            pedirVoto(cargo);
            System.out.println("");
        }
    }
    
    public void erroEleitor() {
        System.out.println("ELEITOR JA VOTOU OU NAO PERTENCE A ESSA URNA");
        System.out.println("");
    }
    
}
