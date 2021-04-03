/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.academia.dados;

import br.edu.ifnmg.poo.academia.modelo.Aluno;
import br.edu.ifnmg.poo.academia.modelo.Instrutor;
import br.edu.ifnmg.poo.academia.modelo.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author luana
 */
public class UsuarioDAO {
   private static Map<String,Usuario> usuarios= new HashMap<>();
    
   public static void adicionarUsuario(Usuario usuario){
        usuarios.put(usuario.getNome(), usuario);
    }
    public static Usuario getUsuario(String login){
        Usuario usuario=usuarios.get(login);
        return usuario;
    }
    
    public static Instrutor getInstrutor(String nome){
        Usuario instrutor=usuarios.get(nome);
        if(instrutor instanceof Instrutor){
            return (Instrutor) instrutor;
        }else
            return null;
    }
    
    public static Aluno getAluno(String nome){
        Usuario aluno=usuarios.get(nome);
        if(aluno instanceof Aluno){
            return (Aluno) aluno;
        }else
            return null;
        }
    
     public static List<Usuario> buscarTodosUsuarios(){
        return new ArrayList<>(usuarios.values());
        
    }
    
}
