/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arvorebinaria;



/**
 *
 * @author User
 */
public class Arvore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArvoreP n = new ArvoreP(30);
        n.insert(5);
        n.insert(1);
        n.insert(15);
        n.insert(25);
        n.insert(2);
        n.insert(1);
        n.insert(4);
        n.insert(8);

        n.verificarBalanceamento(n.raiz);

        n.search(5); //Buscando o valor
        n.destroy(5); // destruindo ("removendo valor");

System.out.println("Calculando a altura... " + n.altura());
  System.out.println(n.organizar(n.raiz) + "imprimindo valores ordenado"  );
  System.out.println(n.antes(n.raiz) + "imprimindo valores pre-ordenado"  );
  System.out.println(n.depois(n.raiz) + "imprimindo valores pos-ordenado"  );
  System.out.println(n.imprimir(n.raiz) + "imprimindo valores"  );

    }
}
  
