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

    
    public No (int numero){   //construtor
        this.numero = numero;

    }

    public int getValor() {
        return numero;
    }

    public No getEsquerda() {
        return noEsquerdo;
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
}
    