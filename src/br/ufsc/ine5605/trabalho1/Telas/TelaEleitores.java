/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.trabalho1.Telas;

import br.ufsc.ine5605.trabalho1.Controladores.ControladorEleitores;
import br.ufsc.ine5605.trabalho1.Entidades.EleitorTrans;
import java.util.Scanner;

/**
 *
 * @author pablothobias
 */
public class TelaEleitores {
    private ControladorEleitores ctrl;
    private Scanner scanner = new Scanner(System.in);

    public TelaEleitores(ControladorEleitores ctrl) {
        this.ctrl = ctrl;
    }
    
    public void exibirMenuEleitores(){
        int opcao = 0;
        System.out.println(" MENU ELEITORES");
        System.out.println("1. CADASTRAR ELEITOR");
        System.out.println("2. EXIBIR ELEITOR PELO TITULO ");
        System.out.println("3. VOLTAR PARA MENU PRINCIPAL ");
        opcao = scanner.nextInt();
        System.out.println("");
        switch(opcao) {
            case 1:
                cadastrarEleitor();
                break;
            case 2:
                exibirEleitorByTitulo();
                break;
            case 3:
                ctrl.voltarMenuPrincipal();
                break;
        }
    }
    
    private void cadastrarEleitor() {
        int titulo,zona,secao,municipio;
        String nome;
        
        System.out.println("INFORME O NOME DO ELEITOR: ");
        nome = scanner.next();
        System.out.println("");
        System.out.println("INFORME O TITULO DO ELEITOR: ");
        titulo = scanner.nextInt();
        System.out.println("");
        System.out.println("EM QUAL CIDADE ELE VOTARA: ");
        System.out.println("1.FLORIANOPOLIS.");
        System.out.println("2.SAO JOSE");
        municipio = scanner.nextInt();
        System.out.println("");
        if (municipio != 1 && municipio != 2) {
            System.out.println("NUMERO DO MUNICIPIO INVALIDO");
            System.out.println("");
            exibirMenuEleitores();
        }
        System.out.println("INFORME A ZONA EM QUE ELE VOTARA: ");
        zona = scanner.nextInt();
        System.out.println("");
        System.out.println("INFORME A SECAO EM QUE ELE VOTARA: ");
        secao = scanner.nextInt();
        System.out.println("");
        
        EleitorTrans eleitorTrans = new EleitorTrans(nome,titulo,zona,secao,municipio);
        System.out.println(ctrl.tratarNovoEleitor(eleitorTrans));
        System.out.println("");
        exibirMenuEleitores();
    }
    
    private void exibirEleitorByTitulo() {
        int titulo;
        System.out.println("INFORME O TITULO DO ELEITOR: ");
        titulo = scanner.nextInt();
        System.out.println("");
        
        EleitorTrans eleitorTrans = new EleitorTrans(titulo);
        eleitorTrans = ctrl.exibirEleitorbyTitulo(eleitorTrans);
        
        if (eleitorTrans != null) {
            String municipio;
            if (eleitorTrans.municipio == 1) {
                 municipio = "FLORIANOPOLIS";
            } else {
                municipio = "SAO JOSE";
            }
            System.out.println("NOME: " + eleitorTrans.nome);
            System.out.println("TITULO: " + eleitorTrans.titulo);
            System.out.println("MUNICIPIO: " + municipio);
            System.out.println("ZONA: " + eleitorTrans.zona);
            System.out.println("SECAO: " + eleitorTrans.secao);
            System.out.println("");
        } else {
            System.out.println("NENHUM ELEITOR CADASTRADO COM ESSE TITULO.");
            System.out.println("");
        }
        exibirMenuEleitores();
    }
    
}
