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
public class Node {
    private Object value;
    private Node proximo;

    public Node(){
        
    }
    
    public Node(Object teste) {
        this.setValue(teste);
        this.setProximo(null);
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Node getProximo() {
        return proximo;
    }

    public void setProximo(Node proximo) {
        this.proximo = proximo;
    }   

    @Override
    public String toString() {
        return "Valor: "+ getValue() + "\n";
    }
    
}
