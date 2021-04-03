/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.academia.dados;

import br.edu.ifnmg.poo.academia.modelo.Avaliacao;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author luana
 */
public class AvaliacaoDAO {
    private static Map<String,Avaliacao> avaliacoes= new HashMap<>();
    
   public static void adicionarUsuario(Avaliacao avaliacao){
        avaliacoes.put(avaliacao.getNomeAluno(), avaliacao);
   }
   public static float gerarImc(float peso, float altura,Avaliacao avaliacao){
       avaliacao.calcularImc(peso, altura);
       return avaliacao.getImc();
   }
}
