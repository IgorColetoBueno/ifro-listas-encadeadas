/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro;

/**
 *
 * @author igor-bueno
 */
public class BrEduIfro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lista lista = new Lista();
        
        for (int i = 0; i < 10; i++) {
            lista.inserir(new Node(i), i);
        }
        
        System.out.println(lista.toString());
        
        System.out.println(lista.remover(0));
        
        System.out.println(lista.toString());
    }
    
}
