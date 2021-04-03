/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.academia.controle;

import br.edu.ifnmg.poo.academia.dados.AvaliacaoDAO;
import br.edu.ifnmg.poo.academia.modelo.Avaliacao;

/**
 *
 * @author luana
 */
public class AvaliacaoControlador {
    
    public void cadastrarAvaliacao(Avaliacao avaliacao){
        AvaliacaoDAO.adicionarUsuario(avaliacao);
    }
    
    public float buscarImc(float peso, float altura, Avaliacao avaliacao){
        return AvaliacaoDAO.gerarImc(peso, altura,avaliacao);    
    }
    
}
