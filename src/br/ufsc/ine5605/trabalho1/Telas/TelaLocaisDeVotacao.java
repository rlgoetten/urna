/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho1.Telas;

import br.ufsc.ine5605.trabalho1.Controladores.ControladorLocaisDeVotacao;
import br.ufsc.ine5605.trabalho1.Entidades.ZonaTrans;
import java.util.Scanner;

/**
 *
 * @author pablothobias
 */
public class TelaLocaisDeVotacao {
    
    private ControladorLocaisDeVotacao ctrl ;
    Scanner entrada = new Scanner(System.in);
    
    public TelaLocaisDeVotacao(ControladorLocaisDeVotacao ctrl){
        
        this.ctrl=ctrl;
        
    }
    
    public void exibirMenuLocais(){
        int opcao = 0 ;
        System.out.println(" MENU LOCAIS DE VOTACAO");
        System.out.println("1. CADASTRAR SECAO EM FLORIANOPOLIS");
        System.out.println("2. CADASTRAR SECAO EM SAO JOSE");
        System.out.println("3. EXIBIR LOCAIS DE VOTACAO CADASTRADOS");
        System.out.println("4. VOLTAR PARA MENU PRINCIPAL ");
        opcao = entrada.nextInt();
        switch(opcao){
             case 1:
                cadastrarSecao(1);
                break;
            case 2:
                cadastrarSecao(2);
                break;
            case 3:
                exibirLocais();
                break;
            case 4:
                ctrl.voltarMenuPrincipal();
                break;
                
        }
        
    }
    
    public void cadastrarSecao(int municipio){
    
         int secao,zona, opcao;
        ZonaTrans zonaT;
        System.out.println("ADICIONAR A UMA ZONA JA CADASTRADA OU NOVA: ");
        System.out.println("1.NOVA ZONA");
        System.out.println("2.ZONA JA CADASTRADA");
        opcao = entrada.nextInt();
        if (opcao != 1 && opcao != 2) {
            System.out.println("OPCAO INVALIDA ");
            System.out.println("");
            exibirMenuLocais();
        }
        System.out.println("");
        System.out.println("DIGITE O NUMERO DA ZONA: ");
        zona = entrada.nextInt();
        System.out.println("DIGTE O NUMERO DA SECAO: ");
        secao = entrada.nextInt();
        if (opcao == 1) {
            zonaT = new ZonaTrans(municipio, secao, zona, false);
        } else {
                zonaT = new ZonaTrans(municipio, secao, zona, true);
        }
        System.out.println(ctrl.addSecao(zonaT));
        System.out.println("");
        exibirMenuLocais();
    
    }
    
    public void exibirLocais(){
        
        System.out.println(ctrl.exibirLocais());   
        System.out.println("");
        ctrl.exibirMenuLocais();
    
    
    }
        
    
}
