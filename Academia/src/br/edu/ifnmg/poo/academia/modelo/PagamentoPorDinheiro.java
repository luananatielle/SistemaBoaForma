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
public class PagamentoPorDinheiro extends Pagamento {
    private float troco;
    private float desconto; 

    public PagamentoPorDinheiro(Date dataPagamento,  float desconto) {
        super(dataPagamento);
        this.desconto=desconto;
    }
    
    public PagamentoPorDinheiro(Date dataPagamento, float troco, float desconto) {
        super(dataPagamento);
        this.troco=troco;
        this.desconto=desconto;
    }
    public float calcularTroco(float total, float valorRecebido){
        return valorRecebido-total-desconto;
    }
    
}
