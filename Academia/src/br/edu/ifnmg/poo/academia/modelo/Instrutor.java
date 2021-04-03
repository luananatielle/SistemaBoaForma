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
public class Instrutor extends Usuario {
    private String especializacao;
    
    public Instrutor(String nome,String telefone, String endereco, String cpf,String login, String senha, String especializacao){
        super(nome,telefone,endereco,cpf,login,senha);
        this.especializacao=especializacao;
    }
}
