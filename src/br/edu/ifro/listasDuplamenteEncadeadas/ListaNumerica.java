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
 
    @Override
    public ListaNumerica clone(){
        ListaNumerica retorno = new ListaNumerica();
        Node<Integer> aux = this.getInicio();
        
        while(aux != null){
            retorno.inserirNoFim(new Node<Integer>(aux.getValue()));
            aux = aux.getProximo();
        }
        
        return retorno;
    }

    public boolean verificarOrdenacao() {
        boolean ordenadoAsc = true;
        boolean ordenadoDesc = true;
        
        if(this.isEmpty()){
            return false;
        }
        
        Node<Integer> aux = this.getInicio();
        
        Integer ascAux = aux.getValue();
        Integer descAux = aux.getValue();
        
        while(aux != null){
            if(aux.getValue() > descAux){
                ordenadoDesc = false;
            }
            if(aux.getValue() < ascAux){
                ordenadoAsc = false;
            }
            
            if(!ordenadoAsc && !ordenadoDesc){
                return false;
            }
            
            ascAux = aux.getValue();            
            descAux = aux.getValue();
            
            aux = aux.getProximo();            
            
        }
        
        return true;        
    }
    
    public boolean comparar(ListaNumerica lista) {
        boolean comparador = true;
        Node<Integer> aux = lista.clone().getInicio();
        
        while (aux != null) {
            if (this.obterUm(aux) == null) {
                comparador = false;
            }
            
            aux = aux.getProximo();
        }

        return comparador;
    }
    
    public static ListaNumerica fatiarLista(ListaNumerica lista, int valor){
        Node<Integer> aux = lista.getInicio();
        ListaNumerica listaRetorno = new ListaNumerica();
        
        while(aux.getValue() != valor && aux != null){
            aux = aux.getProximo();
        }
        while(aux != null){
            listaRetorno.inserirNoFim(new Node<Integer>(aux.getValue()));
            aux = aux.getProximo();
        }
        
        return listaRetorno;
    }
}
