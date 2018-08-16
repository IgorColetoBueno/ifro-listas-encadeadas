/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.listasEncadeadas;

/**
 *
 * @author igor-bueno
 */
public class Node {

    private int value;
    private Node proximo;

    public Node() {

    }

    public Node(int value) {
        this.setValue(value);
        this.setProximo(null);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getProximo() {
        return proximo;
    }

    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }

    public Node clone(){
        Node node = new Node(value);
        node.setProximo(this.getProximo());
        return node;
    }
    
    @Override
    public String toString() {
        return "Valor: " + getValue() + "\n";
    }

}
