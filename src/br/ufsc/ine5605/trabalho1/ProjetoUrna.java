package br.ufsc.ine5605.trabalho1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.ufsc.ine5605.trabalho1.Controladores.ControladorCandidatos;
import br.ufsc.ine5605.trabalho1.Controladores.ControladorPrincipal;
import br.ufsc.ine5605.trabalho1.Entidades.CARGO;
import br.ufsc.ine5605.trabalho1.Entidades.CandTrans;
import br.ufsc.ine5605.trabalho1.Entidades.EleitorTrans;
import br.ufsc.ine5605.trabalho1.Entidades.PARTIDO;
import br.ufsc.ine5605.trabalho1.Entidades.ZonaTrans;
import java.util.ArrayList;

/**
 *
 * @author pablothobias
 */
public class ProjetoUrna {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ControladorPrincipal c = new ControladorPrincipal();
        //registro de candidatos e eleitores etc
        CandTrans deputadoA = new CandTrans("Jair",11,PARTIDO.PSOL,CARGO.DEPUTADO_ESTADUAL);
        CandTrans deputadoB = new CandTrans("Julio",31,PARTIDO.PSOL,CARGO.DEPUTADO_ESTADUAL);
        CandTrans deputadoC = new CandTrans("Carlos",41,PARTIDO.PSOL,CARGO.DEPUTADO_ESTADUAL);
        CandTrans deputadoD = new CandTrans("Ronaldo",27,PARTIDO.PSTU,CARGO.DEPUTADO_ESTADUAL);
        CandTrans deputadoE = new CandTrans("Severino",67,PARTIDO.PSTU,CARGO.DEPUTADO_ESTADUAL);
        
        c.getCtrlCand().TratarNovoCandidato(deputadoA);
        c.getCtrlCand().TratarNovoCandidato(deputadoB);
        c.getCtrlCand().TratarNovoCandidato(deputadoC);
        c.getCtrlCand().TratarNovoCandidato(deputadoD);
        c.getCtrlCand().TratarNovoCandidato(deputadoE);
        
        CandTrans governadorA = new CandTrans("Ruan",98,PARTIDO.PSOL,CARGO.GOVERNADOR);
        CandTrans governadorB = new CandTrans("Cesar",44,PARTIDO.PSOL,CARGO.GOVERNADOR);
        CandTrans governadorC = new CandTrans("Juca",81,PARTIDO.PSOL,CARGO.GOVERNADOR);
        CandTrans governadorD = new CandTrans("Soares",37,PARTIDO.PSTU,CARGO.GOVERNADOR);
        CandTrans governadorE = new CandTrans("Anderson",63,PARTIDO.PSTU,CARGO.GOVERNADOR);
        CandTrans governadorBranco = new CandTrans("Branco",0,null,CARGO.GOVERNADOR);
        CandTrans govarnadorNulo = new CandTrans("Nulo",99,null,CARGO.GOVERNADOR);
        
        c.getCtrlCand().TratarNovoCandidato(governadorA);
        c.getCtrlCand().TratarNovoCandidato(governadorB);
        c.getCtrlCand().TratarNovoCandidato(governadorC);
        c.getCtrlCand().TratarNovoCandidato(governadorD);
        c.getCtrlCand().TratarNovoCandidato(governadorE);
        
        ZonaTrans zonaA = new ZonaTrans(1,27,127,false);
        ZonaTrans zonaB = new ZonaTrans(1,2,27,false);
        ZonaTrans zonaC = new ZonaTrans(2,4,12,false);
        ZonaTrans zonaD = new ZonaTrans(2,7,7,false);
        
        c.getCtrlLocais().addSecao(zonaA);
        c.getCtrlLocais().addSecao(zonaB);
        c.getCtrlLocais().addSecao(zonaC);
        c.getCtrlLocais().addSecao(zonaD);
        
        EleitorTrans eleitorA = new EleitorTrans("Joao",1,127,27,1);
        EleitorTrans eleitorB = new EleitorTrans("Jose",2,127,27,1);
        EleitorTrans eleitorC = new EleitorTrans("Julio",3,127,27,1);
        EleitorTrans eleitorD = new EleitorTrans("Jorge",4,127,27,1);
        EleitorTrans eleitorE = new EleitorTrans("milton",5,127,27,1);
        
        EleitorTrans eleitorF = new EleitorTrans("Lucas",6,27,2,1);
        EleitorTrans eleitorG = new EleitorTrans("Frederico",7,27,2,1);
        EleitorTrans eleitorH = new EleitorTrans("Roger",8,27,2,1);
        EleitorTrans eleitorI = new EleitorTrans("Igor",9,27,2,1);
        EleitorTrans eleitorJ = new EleitorTrans("Carmen",10,27,2,1);
        
        EleitorTrans eleitorK = new EleitorTrans("Anna",11,7,7,2);
        EleitorTrans eleitorL = new EleitorTrans("Maria",12,7,7,2);
        EleitorTrans eleitorM = new EleitorTrans("Maiko",13,7,7,2);
        EleitorTrans eleitorN = new EleitorTrans("Olga",14,7,7,2);
        EleitorTrans eleitorO = new EleitorTrans("Yuri",15,7,7,2);
        
        EleitorTrans eleitorP = new EleitorTrans("Sueli",16,12,4,2);
        EleitorTrans eleitorQ = new EleitorTrans("Hanna",17,12,4,2);
        EleitorTrans eleitorR = new EleitorTrans("Leticia",18,12,4,2);
        EleitorTrans eleitorS = new EleitorTrans("Gregorio",19,12,4,2);
        EleitorTrans eleitorT = new EleitorTrans("Douglas",20,12,4,2);
        
        c.getCtrlEleit().tratarNovoEleitor(eleitorA);
        c.getCtrlEleit().tratarNovoEleitor(eleitorB);
        c.getCtrlEleit().tratarNovoEleitor(eleitorC);
        c.getCtrlEleit().tratarNovoEleitor(eleitorD);
        c.getCtrlEleit().tratarNovoEleitor(eleitorE);
        c.getCtrlEleit().tratarNovoEleitor(eleitorF);
        c.getCtrlEleit().tratarNovoEleitor(eleitorG);
        c.getCtrlEleit().tratarNovoEleitor(eleitorH);
        c.getCtrlEleit().tratarNovoEleitor(eleitorI);
        c.getCtrlEleit().tratarNovoEleitor(eleitorJ);
        c.getCtrlEleit().tratarNovoEleitor(eleitorK);
        c.getCtrlEleit().tratarNovoEleitor(eleitorL);
        c.getCtrlEleit().tratarNovoEleitor(eleitorM);
        c.getCtrlEleit().tratarNovoEleitor(eleitorN);
        c.getCtrlEleit().tratarNovoEleitor(eleitorO);
        c.getCtrlEleit().tratarNovoEleitor(eleitorP);
        c.getCtrlEleit().tratarNovoEleitor(eleitorQ);
        c.getCtrlEleit().tratarNovoEleitor(eleitorR);
        c.getCtrlEleit().tratarNovoEleitor(eleitorS);
        c.getCtrlEleit().tratarNovoEleitor(eleitorT);
        
        
        /////
        c.exibirMenuPrincipal();
    }
    
}
