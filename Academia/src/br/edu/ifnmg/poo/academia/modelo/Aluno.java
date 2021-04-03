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
public class Aluno extends Usuario{
    private int matricula;
    private Date dataNascimento;
    
    public Aluno(String nome,String telefone, String endereco, String cpf,String login, String senha, int matricula,Date dataNascimento ){
        super(nome,telefone,endereco,cpf, login,senha);
        this.matricula=matricula;
        this.dataNascimento=dataNascimento; 
    }

            
}