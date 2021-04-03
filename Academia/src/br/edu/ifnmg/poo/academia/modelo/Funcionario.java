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
public class Funcionario extends Usuario {
    String cargo;
    
    public Funcionario(String nome,String telefone, String endereco, String cpf, String login, String senha, String cargo){
        super(nome,telefone,endereco,cpf,login,senha);
        this.cargo=cargo;
        
    }

    public String getCargo() {
        return cargo;
    }
    
}
