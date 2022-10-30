/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arvorebinaria;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @Flávio cândido User 
 */
public class No{
    public int numero;
    No noEsquerdo;
    No noDireito;
    No pai;
    public int balanceamento;


    public No (int numero){   //construtor
        this.numero = numero;
    }

    public int getValor() {
        return numero;
    }

    public No getEsquerda() {
        return noEsquerdo;
    }
    public No getPai(){
        return pai;
    }

    public No setPai(No pai) {
        this.pai = pai;
        return pai;
    }
    public void setEsquerda(No esquerda) {
        this.noEsquerdo = esquerda;
    }

    public No getDireita() {
        return noDireito;
    }

    public void setDireita(No direita) {
        this.noDireito = direita;
    }

    public void setValor(int numero) {
        this.numero = numero;
    }

    public int getBalanceamento() {
        return balanceamento;
    }
    public void setBalanceamento(int balanceamento) {
        this.balanceamento = balanceamento;
    }
}
    