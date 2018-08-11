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
public class Lista {

    private Node inicio;
    private long lenght;

    public Lista() {
        this.inicio = null;
        this.lenght = 0;
    }

    public boolean isEmpty() {
        Node teste = new Node();
        teste.setValue("Teste");
        return this.inicio == null;
    }

    public void inserirNoInicio(Node item) {
        if (isEmpty()) {
            this.inicio = item;
        } else {
            item.setProximo(this.inicio);
            this.inicio = item;
        }
        
        this.lenght++;
    }

    public void inserirNoFim(Node item) {
        if (isEmpty()) {
            this.inicio = item;
        } else {
            Node aux = this.inicio;
            while (aux.getProximo() != null) {
                aux = aux.getProximo();
            }

            aux.setProximo(item);
        }
        this.lenght++;
    }
    
    public void inserir(Node item, int index){
        if(index == 0 || isEmpty()){
            inserirNoInicio(item);            
        }
        else if(index > lenght){
            inserirNoFim(item);
        }
        else{
            Node aux = this.inicio;
            Node anterior = null;
            for (int i = 0; i < index; i++) {
                anterior = aux;
                aux = aux.getProximo();
            }
            item.setProximo(anterior.getProximo());
            anterior.setProximo(item);
        }
        this.lenght++;
    }

    public Node remover(int index){
        Node aux = null;
        
        if(!isEmpty() || !(index > this.lenght || index < 0)){
            aux = this.inicio;
            Node anterior = null;
            
            for (int i = 0; i < index; i++) {
                anterior = aux;
                aux = aux.getProximo();
            }
            
            anterior.setProximo(aux.getProximo());
            aux.setProximo(null);
            
            this.lenght--;            
        }
        
        return aux;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (this.isEmpty()) {
            System.out.println("Lista Vazia!");
        } else {
            Node aux = this.inicio;

            while (aux != null) {
                builder.append(aux.toString());
                aux = aux.getProximo();
            }
        }
        return builder.toString();
    }

}
