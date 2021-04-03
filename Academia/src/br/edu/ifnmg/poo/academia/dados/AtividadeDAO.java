/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.academia.dados;

import br.edu.ifnmg.poo.academia.modelo.Atividade;
import br.edu.ifnmg.poo.academia.modelo.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author luana
 */
public class AtividadeDAO {
    private static Map<String,Atividade> atividades = new HashMap<>();
    private static List<Atividade> atividadesMatriculadas =new ArrayList();
    
    public static void adicionarAtividade(Atividade atividade){
        atividades.put(atividade.getNome(),atividade);
    } 
    
    public static List<Atividade> buscarTodasAtividades(){
        return new ArrayList<>(atividades.values());
        
    }
    
    public static Atividade getAtividade(String nome){
        Atividade atividade=atividades.get(nome);
        return atividade;
    }

    public static List<Atividade> matricularEmAtividades(Atividade atividade){ 
        atividadesMatriculadas.add(atividade);
        return atividadesMatriculadas;
    }
    
    public static List<Atividade> getAtividadesMatriculadas(){
        return AtividadeDAO.atividadesMatriculadas;
    }
}
