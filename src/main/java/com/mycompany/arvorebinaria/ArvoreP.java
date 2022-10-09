/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arvorebinaria;

/**
 *
 * @Flávio cândido user
 */

public class ArvoreP {
    
    public No raiz;

    public ArvoreP(int numero) {
        this.raiz = new No(numero);
    }

    public void insert(int numero) {
        inserir(raiz, numero);

    }

    public void inserir(No NoArvore, int numero) {  //inserindo
        if (NoArvore == null) {
            System.out.println("Raiz " + numero);
            raiz = new No(numero);
        } else {
            if (numero < NoArvore.numero) {
                if (NoArvore.noEsquerdo != null) {
                    inserir(NoArvore.noEsquerdo, numero);
                } else {
                    System.out.println("Inserindo " + numero + " a esquerda de " + NoArvore.numero);
                    NoArvore.noEsquerdo = new No(numero);
                }

            } else {
                if (NoArvore.noDireito != null) {
                    inserir(NoArvore.noDireito, numero);
                } else {
                    System.out.println("Inserindo " + numero + " a direita de " + NoArvore.numero);
                    NoArvore.noDireito = new No(numero);
                }
            }
        }
    }
   
    public int buscar(No NoArvore, int numero, int key) {
        if (NoArvore != null) {
            if (NoArvore.numero == numero) {
            } else if (numero < NoArvore.numero) {
               key = buscar(NoArvore.noEsquerdo, numero, key);
            } else {
               key = buscar(NoArvore.noDireito, numero, key);
            }
        }
        return key;
    }
    
    public int altura() {  //altura
        return altura(this.raiz);
    }

    private int altura(No NoAltura) {
        if (NoAltura != null) {
            int e, d;
            e = altura(NoAltura.noEsquerdo);
            d = altura(NoAltura.noDireito);
            if (e > d) {
                return e + 1;
            } else {
                return d + 1;
            }
        }
        return 0;
    }

    public void antes(No NoArvore) {  //antes
        if (NoArvore != null) {
            System.out.print(NoArvore.numero + ", ");
            antes(NoArvore.noEsquerdo);
            antes(NoArvore.noDireito);

        }
    }

    public void depois(No NoArvore) { //pos
        if (NoArvore != null) {

            depois(NoArvore.noEsquerdo);
            depois(NoArvore.noDireito);
            System.out.print(NoArvore.numero + ", ");

        }

    }

    public void organizar(No NoArvore) { //endireitar
        if (NoArvore != null) {
            organizar(NoArvore.noEsquerdo);
            System.out.print(NoArvore.numero + ", ");
            organizar(NoArvore.noDireito);

        }

    }

    public String imprimir(No NoArvore) {   //print
        String retorno;
        retorno = "(";
        if (NoArvore != null) {
            imprimir(NoArvore.noEsquerdo);
            System.out.print(NoArvore.numero + " ");
            imprimir(NoArvore.noDireito);
            
        }
        retorno += ")";
        return retorno;
    }

}
