/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.academia.controle;

import br.edu.ifnmg.poo.academia.dados.PlanoDAO;
import br.edu.ifnmg.poo.academia.modelo.Plano;

/**
 *
 * @author luana
 */
public class PlanoControlador {
    public void adicionarPlano(Plano plano){
        PlanoDAO.adicionarPlano(plano);
    }
    
    public Plano buscarPlano(String aluno){
        return PlanoDAO.getPlano(aluno);
        
    }
}
