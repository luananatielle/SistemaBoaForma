/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.academia.controle;
import br.edu.ifnmg.poo.academia.modelo.Usuario;
import br.edu.ifnmg.poo.academia.dados.UsuarioDAO;

        
/**
 *
 * @author luana
 */
public class AutenticacaoControlador {
    
    public Usuario autenticar(String login, String senha){
       Usuario usuarioRecuperado = UsuarioDAO.getUsuario(login);
        if(usuarioRecuperado!=null){
            if(usuarioRecuperado.verificarSenha(senha))
                return usuarioRecuperado;
            else
                return null;
         }
        else
            return null; 
        
       
    }
    
    
}
