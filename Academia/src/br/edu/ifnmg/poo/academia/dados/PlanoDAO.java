/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.academia.dados;


import br.edu.ifnmg.poo.academia.modelo.Aluno;
import br.edu.ifnmg.poo.academia.modelo.Plano;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author luana
 */
public class PlanoDAO {
    private static Map<String,Plano> planos = new HashMap<>();
    
    public static void adicionarPlano(Plano plano){
        planos.put(plano.getAluno(),plano);
    } 
   
    public static Plano getPlano(String aluno){
        Plano plano=planos.get(aluno);
        return plano;
    }
}
