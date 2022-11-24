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
        inserir(raiz,numero);

    }
    public void search(int numero){
        buscar(raiz, numero);
    }
    public void destroy(int numero){
        remover(raiz, numero);
    }
    public void depth(int numero){
        profundidade(this.raiz);
    }
    public No inserir(No NoArvore, int numero) {
        if (NoArvore == null) {
            return new No(numero);
        } else if (NoArvore.numero > numero) {
            NoArvore.noEsquerdo = inserir(NoArvore.noEsquerdo, numero);
        } else if (NoArvore.numero < numero) {
            NoArvore.noDireito = inserir(NoArvore.noDireito, numero);
        } else {
            throw new RuntimeException("Chave duplicada || número duplicado");
        }
        return rebalance(NoArvore);
    }
    public No buscar(No NoArvore, int numero) {
        if (NoArvore != null) {
            if (NoArvore.numero == numero) {
                System.out.println("Valor encontrado");
                return NoArvore;
            } else if (numero < NoArvore.numero) {
                buscar(NoArvore.noEsquerdo, numero);
            } else {
                buscar(NoArvore.noDireito, numero);
            }
        }
        return NoArvore;
    }

    public int altura() {  //altura
        return altura(this.raiz);
    }
    public int profundidade(No NoAltura){
        int p;
        if(NoAltura == this.raiz){
            return 0;
        }
        return 1+ profundidade(NoAltura.pai);

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
    public void atualizarAltura(No NoArvore) {
        NoArvore.altura = 1 + Math.max(altura(NoArvore.noEsquerdo), altura(NoArvore.noDireito));
    }
    public No rebalance(No z) {
        atualizarAltura(z);
        int balance = setBalanceamento(z);
        if (balance == -2) {
            if (altura(z.noDireito.noDireito) > altura(z.noDireito.noEsquerdo)) {
                z = rotacaoEsquerda(z);
            }  else {
                z = duplaRotacaoEsquerdaDireita(z);
            }
        } else if (balance  == -2) {
            if (altura(z.noEsquerdo.noEsquerdo) > altura(z.noEsquerdo.noDireito))
                z = rotacaoDireita(z);
            else {
                z = duplaRotacaoDireitaEsquerda(z);
            }
        }
        return z;
    }
    public No rotacaoEsquerda(No inicial) {

        No direita = inicial.getDireita();
        direita.setPai(inicial.getPai());

        inicial.setDireita(direita.getEsquerda());

        if (inicial.getDireita() != null) {
            inicial.getDireita().setPai(inicial);
        }

        direita.setEsquerda(inicial);
        inicial.setPai(direita);

        if (direita.getPai() != null) {

            if (direita.getPai().getDireita() == inicial) {
                direita.getPai().setDireita(direita);

            } else if (direita.getPai().getEsquerda() == inicial) {
                direita.getPai().setEsquerda(direita);
            }
        }

        setBalanceamento(inicial);
        setBalanceamento(direita);

        return direita;
    }
    public No rotacaoDireita(No inicial) {

        No esquerda = inicial.getEsquerda();
        esquerda.setPai(inicial.getPai());

        inicial.setEsquerda(esquerda.getDireita());

        if (inicial.getEsquerda() != null) {
            inicial.getEsquerda().setPai(inicial);
        }

        esquerda.setDireita(inicial);
        inicial.setPai(esquerda);

        if (esquerda.getPai() != null) {

            if (esquerda.getPai().getDireita() == inicial) {
                esquerda.getPai().setDireita(esquerda);

            } else if (esquerda.getPai().getEsquerda() == inicial) {
                esquerda.getPai().setEsquerda(esquerda);
            }
        }

        setBalanceamento(inicial);
        setBalanceamento(esquerda);

        return esquerda;
    }

    public No duplaRotacaoEsquerdaDireita(No inicial) {
        inicial.setEsquerda(rotacaoEsquerda(inicial.getEsquerda()));
        return rotacaoDireita(inicial);
    }
    public No duplaRotacaoDireitaEsquerda(No inicial) {
        inicial.setDireita(rotacaoDireita(inicial.getDireita()));
        return rotacaoEsquerda(inicial);
    }
    public int setBalanceamento(No NoArvore) {
        NoArvore.setBalanceamento(altura(NoArvore.getDireita()) - altura(NoArvore.getEsquerda()));
        return 0;
    }
}





