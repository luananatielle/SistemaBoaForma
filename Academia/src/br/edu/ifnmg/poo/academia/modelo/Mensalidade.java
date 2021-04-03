/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.academia.modelo;

import java.util.Date;
import java.util.List;

/**
 *
 * @author luana
 */
public class Mensalidade {
    
    private Date vencimento;
    private String statusPagamento;
    
    public Mensalidade(Date vencimento){
        this.vencimento=vencimento;
        this.statusPagamento="A vencer";
    }

    public Mensalidade(Date vencimento, String statusPag){
        this.vencimento=vencimento;
        this.statusPagamento=statusPag;
    }
    
    public void alterarStatusPagamento(){
       this.statusPagamento="Pago"; 
    }
}
