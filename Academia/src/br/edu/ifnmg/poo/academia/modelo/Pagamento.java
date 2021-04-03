/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.academia.modelo;

import java.util.Date;

/**
 *
 * @author luana
 */
public abstract class Pagamento {
    private Date dataPagamento;
    
    public Pagamento(Date dataPagamento){
        this.dataPagamento=dataPagamento;
    }
}
