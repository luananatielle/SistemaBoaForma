/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.academia.modelo;

import java.util.List;

/**
 *
 * @author luana
 */
public class Plano {
   
    private List<Atividade> atividades;
    private float valorTotal;
     
    private Aluno   aluno;
    
    public Plano(Aluno aluno, List<Atividade> atividades, float total) {
        this.atividades=atividades;
        this.valorTotal=total;
        this.aluno=aluno;
    }

    public String getAluno() {
        return aluno.getNome();
    }

    public float getValorTotal() {
        return valorTotal;
    }
        
              
}
