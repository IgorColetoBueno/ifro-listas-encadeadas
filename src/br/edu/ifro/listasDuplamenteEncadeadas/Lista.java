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
public class Lista<T> {
    private Node<T> inicio;
    private Node<T> fim;
    private int length;
    
    public Lista() {
        this.inicio = null;
        this.fim = null;
    }
    
    public boolean isEmpty(){
        return inicio == null && fim == null;
    }
    
    public void inserirNoInicio(Node<T> item){
        if(isEmpty()){
            this.inicio = item;
            this.fim = item;
        }
        else{
            item.setProximo(this.inicio);
            this.inicio.setAnterior(item);
            this.inicio = item;
        }
        
        this.length++;
    }
    
    public void inserirNoFim(Node<T> item){
        if (this.isEmpty()) {
            this.inicio = item;
            this.fim = item;
        }
        else{
            item.setAnterior(fim);
            this.fim.setProximo(item);
            this.fim = item;
        }
        
        this.length++;
    }
    
    public void inserir(Node<T> item, int index){
        if (isEmpty() || index == 0) {
            this.inserirNoInicio(item);
        }
        else if(this.length <= index){
            this.inserirNoFim(item);
        }
        else{
            Node<T> aux = this.inicio;
            for (int i = 0; i < index; i++) {
                aux = aux.getProximo();
            }
            
            item.setProximo(aux);
            item.setAnterior(aux.getAnterior());
            item.getAnterior().setProximo(item);
            aux.setAnterior(item);
        }
    }

    @Override
    public String toString() {
        if(isEmpty()){
            return "Lista vazia!";
        }
        else{
            Node<T> aux = this.inicio;
            StringBuilder builder = new StringBuilder();
            int i = 0;
            
            while(aux != null){
                builder.append("\n");
                builder.append("Valor "+ i + ": "+ aux.getValue());
                aux = aux.getProximo();
                i++;
            }
            return builder.toString();
        }
    }      
}
