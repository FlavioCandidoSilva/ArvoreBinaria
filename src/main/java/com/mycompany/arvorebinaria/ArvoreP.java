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
    public void search(int numero){
        buscar(raiz, numero);
    }
    public void destroy(int numero){
        remover(raiz, numero);
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
   
    public static void buscar(No NoArvore, int numero) {
        if (NoArvore != null) {
            if (NoArvore.numero == numero) {
                System.out.println("Valor encontrado");
            } else if (numero < NoArvore.numero) {
               buscar(NoArvore.noEsquerdo, numero);
            } else {
               buscar(NoArvore.noDireito, numero);
            }
        }
    }
    
    public int altura() {  //altura
        return altura(this.raiz);
    }

    //Calculo da altura
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

    public String antes(No NoArvore) {  //antes
        String retorno;
        retorno = "(";
        if (NoArvore != null) {
            System.out.print(NoArvore.numero + ", ");
            antes(NoArvore.noEsquerdo);
            antes(NoArvore.noDireito);

        }
        retorno += ")";
        return retorno;
    }

    public String depois(No NoArvore) { //pos
        String retorno;
        retorno = "(";
        if (NoArvore != null) {

            depois(NoArvore.noEsquerdo);
            depois(NoArvore.noDireito);
            System.out.print(NoArvore.numero + ", ");

        }
        retorno += ")";
        return retorno;

    }

    public String organizar(No NoArvore) { //endireitar
        String retorno;
        retorno = "(";
        if (NoArvore != null) {
            organizar(NoArvore.noEsquerdo);
            System.out.print(NoArvore.numero + ", ");
            organizar(NoArvore.noDireito);

        }
        retorno += ")";
        return retorno;

    }

    //imprimindo a arvore completa
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

    //metodo para descobrir o maior valor e ser auxiliar da função remover
    private No maiorValor(No NoArvore) {
        while (NoArvore.getDireita() != null) {
            NoArvore = NoArvore.getDireita();
        }

        return NoArvore;
    }

    public No remover(No NoArvore, int numero) {
        // chave não encontrada na árvore
        if (NoArvore == null) {
            return NoArvore;
        }

        // valor menor, procurar na sub-árvore esquerda
        if (numero < NoArvore.getValor()) {
            NoArvore.setEsquerda(remover(NoArvore.getEsquerda(), numero));
        } else if (numero > NoArvore.getValor()) {
            // valor maior, procurar na sub-árvore direita
            NoArvore.setDireita(remover(NoArvore.getDireita(), numero));
        } else { // valor encontrado
            // caso 1: nó é uma folha (não tem filhos)
            if (NoArvore.getEsquerda() == null && NoArvore.getDireita() == null) {
                // remove-o (seta a "raiz" deste nó para null)
                return null;
            } else if (NoArvore.getEsquerda() != null && NoArvore.getDireita() != null) {
                // caso 3: nó tem 2 filhos
                // encontrar o maior dos filhos que antecede o nó
                No maiorAntecessor = maiorValor(NoArvore.getEsquerda());

                // copia o valor do antecessor para este nó
                NoArvore.setValor(maiorAntecessor.getValor());

                // remove o antecessor recursivamente
                NoArvore.setEsquerda(remover(NoArvore.getEsquerda(), maiorAntecessor.getValor()));
            } else {
                // caso 2: nó só tem um filho
                No child = (NoArvore.getEsquerda() != null) ? NoArvore.getEsquerda() : NoArvore.getDireita();
                NoArvore = child;
            }
        }

        return NoArvore;
    }

    }



