/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho1.Telas;

import br.ufsc.ine5605.trabalho1.Controladores.ControladorPrincipal;
import java.util.Scanner;
/**
 *
 * @author jlehmkuhl
 */
public class TelaPrincipal {
    private ControladorPrincipal ctrlPrinc;
    private Scanner scanner = new Scanner(System.in);

    public TelaPrincipal(ControladorPrincipal ctrlPrinc) {
        this.ctrlPrinc = ctrlPrinc;
    }
    
    public void exibirMenuPrincipal() {
        int opcao = 0;
        System.out.println("DIGITE O NUMERO DA OPCAO DESEJADA: ");
        System.out.println("1.MENU CANDIDATOS");
        System.out.println("2.MENU ELEITORES");
        System.out.println("3.MENU LOCAIS DE VOTACAO");
        System.out.println("4.MENU VOTACAO");
        System.out.println("5.SAIR");
        
        opcao = retorneInteiro(5);
        System.out.println("");
        switch(opcao){
            case 1:
                ctrlPrinc.irParaCandidatos();
                break;
            case 2:
                ctrlPrinc.irParaEleitores();
                break;
            case 3:
                ctrlPrinc.irParaLocais();    
                break;
            case 4:
                ctrlPrinc.irParaVotacao();
                break;
        }
    }
    
    public int retorneInteiro(int limSup) {
        int opcao = 0;
        while( opcao > limSup || opcao < 1){
            while(!scanner.hasNextInt()) {
                scanner.next();
            }
            opcao = scanner.nextInt();
        }
        return opcao;
    }
    
}
