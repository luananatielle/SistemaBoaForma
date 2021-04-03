/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.academia.controle;

import br.edu.ifnmg.poo.academia.dados.AtividadeDAO;
import br.edu.ifnmg.poo.academia.dados.UsuarioDAO;
import br.edu.ifnmg.poo.academia.modelo.Aluno;
import br.edu.ifnmg.poo.academia.modelo.Atividade;
import java.util.List;

/**
 *
 * @author luana
 */
public class AtividadeControlador {
    public void cadastrarAtividade(Atividade atividade){
        AtividadeDAO.adicionarAtividade(atividade);
    }
    
    public List<Atividade> buscarTodasAtividades(){
        return AtividadeDAO.buscarTodasAtividades();
    }

    public List<Atividade> matriculaAtividade(Atividade atividade) {
       List<Atividade> atividades=AtividadeDAO.matricularEmAtividades(atividade);
       return atividades;
    }

    public Atividade buscarAtividade(String atividade) {
        Atividade atividadeRecuperado=AtividadeDAO.getAtividade(atividade);
        return atividadeRecuperado;
    }
    
    public float precoAtividadesMatriculadas(){
        List<Atividade> atividadesMatriculadas=AtividadeDAO.getAtividadesMatriculadas();
        float precoTotal=0;
        for(Atividade atividade: atividadesMatriculadas){
            precoTotal+=atividade.getValor();
        }
        return precoTotal;
    }
}
