/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro;

import br.edu.ifro.listasDuplamenteEncadeadas.Lista;
import br.edu.ifro.listasDuplamenteEncadeadas.Node;

/**
 *
 * @author igor-bueno
 */
public class listaDuplamenteEncadeadaTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Lista<Integer> lista = new Lista<>();
        
        lista.inserirNoInicio(new Node<Integer>(12));
        lista.inserirNoInicio(new Node<Integer>(8));
        lista.inserirNoFim(new Node<Integer>(5));
        lista.inserir(new Node<Integer>(21), 0);
        System.out.println(lista.toString());
    }

}
