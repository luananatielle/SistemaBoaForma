/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.academia.modelo;

import java.util.Date;

/**
 *
 * @author luana
 */
public class Avaliacao {
   
    private float peso;
    private float altura;
    private float imc;
    private Date dataAvaliacao;
    private String observacoes;
   
    private Instrutor instrutor; 
    private Aluno aluno;
    
    
    public Avaliacao(float peso, float altura, Date dataAv, Instrutor instrutor, Aluno aluno, String obs){
    
        this.peso=peso;
        this.altura=altura;
        this.dataAvaliacao=dataAv;
        this.instrutor=instrutor;
        this.aluno=aluno;
        this.observacoes=obs;
    }

      
    public String getNomeAluno(){
        return aluno.getNome();
    }

    public float getImc() {
        return imc;
    }
    
    
    public void calcularImc(float peso, float altura){
        this.imc=peso/(altura*altura);
    }

    
}
    
    