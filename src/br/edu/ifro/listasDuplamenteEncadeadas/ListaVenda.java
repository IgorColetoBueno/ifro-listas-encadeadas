/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.listasDuplamenteEncadeadas;

/**
 *
 * @author igor-bueno
 */
public class ListaVenda extends Lista<ItemVenda>{
    public double obterValorTotal(){
        Node<ItemVenda> aux = this.getInicio();
        double total = 0;
        
        while(aux != null){
            total += aux.getValue().getValorTotal();
            aux = aux.getProximo();
        }
        
        return total;
    }
}
