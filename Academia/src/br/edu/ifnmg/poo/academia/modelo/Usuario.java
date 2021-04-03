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
public  abstract class Usuario {
    private String nome;
    private String telefone;
    private String endereco;
    private String cpf;
   // private String login;
    private String senha;
    
    public Usuario(String nome,String telefone, String endereco, String cpf,String login, String senha){
        this.nome=nome;
        this.telefone=telefone;
        this.endereco=endereco;
        this.cpf=cpf;
        //this.login=login;
        this.senha=senha;
    }
    
   /* public String getLogin() {
        return login;
    }*/
    
    public String getNome() {
       return nome; 
    }
    public boolean verificarSenha(String senha){
        return this.senha.equals(senha);
    }

    

}
