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
public class PagamentoPorCartao extends Pagamento {
    private char tipo;
    private String bandeira;
    private int parcelamento;

    public PagamentoPorCartao(Date dataPagamento, char tipo, String bandeira, int parcelamento) {
        super(dataPagamento);
        this.tipo=tipo;
        this.bandeira=bandeira;
        this.parcelamento=parcelamento;
    }

    

}
