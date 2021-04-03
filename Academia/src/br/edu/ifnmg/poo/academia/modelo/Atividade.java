/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.academia.modelo;

/**
 *
 * @author luana
 */
public class Atividade {
    private String nome;
    private String descricao;
    private String diasDaSemana;
    private String horarioInicial;
    private String horarioFinal;
    private float valor;
    private int lotacaoAtual;
    private int lotacaoMaxima;
    
    private Instrutor instrutor;
    
    public Atividade(String nome,String desc, String diasSemana, String horarioInicial, String horarioFinal, float valor,int lotacaoAtual,int lotacaoMaxima, Instrutor instrutor){
        this.nome=nome;
        this.descricao=desc;
        this.diasDaSemana=diasSemana;
        this.horarioInicial=horarioInicial;
        this.horarioFinal=horarioFinal;
        this.valor=valor;
        this.lotacaoAtual=lotacaoAtual;
        this.lotacaoMaxima=lotacaoMaxima;
        this.instrutor=instrutor;
    }
    
    public String getNome() {
        return nome;
    }

    public String getDiasDaSemana() {
        return diasDaSemana;
    }

    public String getHorarioInicial() {
        return horarioInicial;
    }

    public String getHorarioFinal() {
        return horarioFinal;
    }

    public float getValor() {
        return valor;
    }

    public int getLotacaoMaxima() {
        return lotacaoMaxima;
    }
    
    public int getLotacaoAtual() {
        return lotacaoAtual;
    }

    public void setLotacaoAtual(int lotacaoAtual) {
        this.lotacaoAtual = lotacaoAtual;
    }

   
          
}
