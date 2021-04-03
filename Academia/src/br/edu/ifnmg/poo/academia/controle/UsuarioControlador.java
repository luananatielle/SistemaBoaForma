/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.academia.controle;

import br.edu.ifnmg.poo.academia.dados.UsuarioDAO;
import br.edu.ifnmg.poo.academia.modelo.Aluno;
import br.edu.ifnmg.poo.academia.modelo.Instrutor;
import br.edu.ifnmg.poo.academia.modelo.Usuario;
import java.util.List;

/**
 *
 * @author luana
 */
public class UsuarioControlador {
    
    public void cadastrarUsuario(Usuario usuario){
        UsuarioDAO.adicionarUsuario(usuario);
    }
    public Instrutor buscarInstrutor(String nome){
        Instrutor instrutorRecuperado = UsuarioDAO.getInstrutor(nome);
        return instrutorRecuperado;   
    }
    
    public Aluno buscarAluno(String nome){
        Aluno alunoRecuperado=UsuarioDAO.getAluno(nome);
        return alunoRecuperado;
    }
    
    public List<Usuario> buscarTodosUsuarios(){
        return UsuarioDAO.buscarTodosUsuarios();
    }
}
