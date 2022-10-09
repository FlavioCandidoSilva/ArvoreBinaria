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
        ArvoreP n = new ArvoreP(10);
        No no = new No(30);
        n.insert(5);
        n.insert(4);
        n.insert(15);
        n.insert(5);
        n.insert(2);
        n.insert(4);
      
      System.out.println("busca " + n.buscar(no, 5, 5));
      System.out.println("altura " + n.altura());
      System.out.println(n.imprimir(n.raiz) + "imprimindo valores"  );

      
      
      

    }
}
  
