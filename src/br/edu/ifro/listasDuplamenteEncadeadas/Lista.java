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

    public Lista(Node<T> inicio, Node<T> fim, int length) {
        this.inicio = inicio;
        this.fim = fim;
        this.length = length;
    }

    public boolean isEmpty() {
        return inicio == null && fim == null;
    }

    public Node<T> getInicio() {
        return inicio;
    }

    public void setInicio(Node<T> inicio) {
        this.inicio = inicio;
    }

    public Node<T> getFim() {
        return fim;
    }

    public void setFim(Node<T> fim) {
        this.fim = fim;
    }

    public int getLength() {
        return length;
    }

    public void inserirNoInicio(Node<T> item) {
        if (isEmpty()) {
            this.inicio = item;
            this.fim = item;
        } else {
            item.setProximo(this.inicio);
            this.inicio.setAnterior(item);
            this.inicio = item;
        }

        this.length++;
    }

    public void inserirNoFim(Node<T> item) {
        if (this.isEmpty()) {
            this.inicio = item;
            this.fim = item;
        } else {
            item.setAnterior(fim);
            this.fim.setProximo(item);
            this.fim = item;
        }

        this.length++;
    }

    public void inserir(Node<T> item, int index) {
        if (isEmpty() || index == 0) {
            this.inserirNoInicio(item);
        } else if (this.length <= index) {
            this.inserirNoFim(item);
        } else {
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

    public Node<T> remover(int index) {
        Node<T> aux = this.inicio;

        if (this.isEmpty() || (index + 1) > this.length || index < 0) {
            return null;
        } else if (index == 0) {
            this.inicio = aux.getProximo();
            if (this.inicio != null) {
                this.inicio.setAnterior(null);
            }
            aux.setAnterior(null);
            aux.setProximo(null);
            this.length--;
            return aux;
        }

        for (int i = 0; i < index; i++) {
            aux = aux.getProximo();
        }

        if ((index + 1) == length) {
            this.fim = aux.getAnterior();
            this.fim.setProximo(null);

            aux.getAnterior().setProximo(null);
            aux.setAnterior(null);
            aux.setProximo(null);
            this.length--;
            return aux;
        }

        aux.getProximo().setAnterior(aux.getAnterior());
        aux.getAnterior().setProximo(aux.getProximo());
        aux.setAnterior(null);
        aux.setProximo(null);

        this.length--;
        return aux;

    }

    public Node<T> removerPrimeiro() {
        return this.remover(0);
    }

    public Node<T> removerUltimo() {
        return this.remover(length - 1);
    }

    public Node<T> obterUm(int index) {
        if (this.isEmpty() || index < 0 || index >= this.length) {
            return null;
        } else {
            Node aux = this.inicio;

            for (int i = 0; i < index; i++) {
                aux = aux.getProximo();
            }

            Node<T> retorno = aux.clone();
            retorno.setProximo(null);
            retorno.setAnterior(null);

            return retorno;
        }
    }

    public Node<T> obterUm(Node<T> item) {
        if (this.isEmpty()) {
            return null;
        } else {
            Node aux = this.inicio;

            for (int i = 0; i < this.length; i++) {
                if (item.getValue() == aux.getValue()) {
                    Node valor = aux.clone();
                    valor.setProximo(null);
                    valor.setAnterior(null);
                    return valor;
                }
                aux = aux.getProximo();
            }
            return aux;
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Lista vazia!";
        } else {
            Node<T> aux = this.inicio;
            StringBuilder builder = new StringBuilder();
            int i = 0;

            while (aux != null) {
                builder.append("\n");
                builder.append("Valor " + i + ": " + aux.getValue());
                aux = aux.getProximo();
                i++;
            }
            return builder.toString();
        }
    }

    public Lista<T> clone() {
        return new Lista(this.inicio, this.fim, this.length);
    }

    public Lista<T> concatenar(Lista<T> lista2) {
        Node<T> aux = this.getInicio().clone();
        Lista<T> novaLista2 = lista2.clone();
        
        while(aux != null){
            novaLista2.inserirNoFim(new Node<T>(aux.getValue()));
            aux = aux.getProximo();
        }       
                
        return novaLista2;
    }
}
