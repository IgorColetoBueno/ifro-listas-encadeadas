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
public class ListaNumerica extends Lista<Integer> {

    public Node<Integer> buscarMaiorItem() {
        Node<Integer> aux = this.getInicio();
        Node<Integer> maior = null;
        int valor = 0;

        while (aux != null) {
            if (aux != null && aux.getValue() > valor) {
                valor = aux.getValue();
                maior = aux.clone();
            }
            aux = aux.getProximo();
        }

        maior.setAnterior(null);
        maior.setProximo(null);

        return maior;
    }

    public Node<Integer> buscarMenorItem() {
        Node<Integer> aux = this.getInicio();
        Node<Integer> menor = null;
        Integer valor = null;

        while (aux != null) {
            if (aux != null && (valor == null || aux.getValue() < valor)) {
                valor = aux.getValue();
                menor = aux.clone();
            }
            aux = aux.getProximo();
        }

        menor.setAnterior(null);
        menor.setProximo(null);

        return menor;
    }

    public double buscarMediaDeItens() {
        if (this.isEmpty()) {
            return 0;
        } else {
            double totalizador = 0;
            Node<Integer> aux = this.getInicio();

            while (aux != null) {
                totalizador += aux.getValue();
                aux = aux.getProximo();
            }

            return (totalizador / this.getLength());

        }
    }

    public int buscarQuantidadeDePares() {
        if (this.isEmpty()) {
            return 0;
        } else {
            Node<Integer> aux = this.getInicio();
            int pares = 0;
            while (aux != null) {
                if(aux.getValue() % 2 == 0){
                    pares++;
                }
                aux = aux.getProximo();
            }
            
            return pares;
        }
    }
    
    public static ListaNumerica substituir(ListaNumerica lista, int valorOriginal, int valorNovo){
        Node<Integer> aux = lista.getInicio();
        
        while(aux != null){
            if(aux.getValue() == valorOriginal){
                aux.setValue(valorNovo);
            }
            
            aux = aux.getProximo();
        }
        
        return lista;
    }
    
}
