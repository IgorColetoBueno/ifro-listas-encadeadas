/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.listasDuplamenteEncadeadas;

import java.util.Iterator;

/**
 *
 * @author igor-bueno
 */
public class Node<T> {
    private T value;
    private Node anterior;
    private Node proximo;

    public Node(T value) {
        this.value = value;
        this.proximo = null;
        this.anterior = null;
    }

    private Node(T value, Node anterior, Node proximo) {
        this.value = value;
        this.anterior = anterior;
        this.proximo = proximo;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node getAnterior() {
        return anterior;
    }

    public void setAnterior(Node anterior) {
        this.anterior = anterior;
    }

    public Node getProximo() {
        return proximo;
    }

    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }   
    

    @Override
    public String toString() {
        return "Node{" + "value=" + value + ", anterior=" + anterior + ", proximo=" + proximo + '}';
    }   

    public Node clone(){
        return new Node(this.value, this.anterior, this.proximo);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    
    
}
