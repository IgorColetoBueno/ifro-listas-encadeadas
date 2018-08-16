/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro.listasEncadeadas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author igor-bueno
 */
public class NumberList {

    private Node inicio;
    private int length;

    public NumberList() {
        this.inicio = null;
        this.length = 0;
    }

    private NumberList(Node inicio, int length) {
        this.inicio = inicio;
        this.length = length;
    }

    public boolean isEmpty() {
        return this.inicio == null;
    }

    public void inserirNoInicio(Node item) {
        if (isEmpty()) {
            this.inicio = item;
        } else {
            item.setProximo(this.inicio);
            this.inicio = item;
        }

        this.length++;
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
        this.length++;
    }

    public void inserir(Node item, int index) {
        if (index == 0 || isEmpty()) {
            inserirNoInicio(item);
        } else if (index > length) {
            inserirNoFim(item);
        } else {
            Node aux = this.inicio;
            Node anterior = null;
            for (int i = 0; i < index; i++) {
                anterior = aux;
                aux = aux.getProximo();
            }
            item.setProximo(anterior.getProximo());
            anterior.setProximo(item);
            this.length++;
        }
    }

    public Node remover(int index) {
        Node aux = null;

        if (!isEmpty() || !(index > this.length || index < 0)) {
            aux = this.inicio;
            Node anterior = null;

            if (index == 0) {
                Node deletado = aux;
                this.inicio = aux.getProximo();
            } else {
                int i = 0;
                do {
                    anterior = aux;
                    aux = aux.getProximo();
                    i++;
                } while (i < index);

                anterior.setProximo(aux.getProximo());
                aux.setProximo(null);
            }
            this.length--;
        }

        return aux;
    }

    public boolean removerPrimeiros(int quantidade) {

        if (!isEmpty() || !(quantidade > this.length || quantidade < 0)) {
            for (int i = 0; i < quantidade; i++) {
                this.remover(i);
            }
            return true;
        }

        return false;
    }

    public int contarItensPares() {
        int itensParesLength = 0;
        Node aux = this.inicio;

        while (aux != null) {
            if (aux.getValue() % 2 == 0) {
                itensParesLength++;
            }
            aux = aux.getProximo();
        }
        return itensParesLength;
    }

    public double calcularMedia() {
        int montante = 0;
        Node aux = this.inicio;

        while (aux != null) {
            montante += aux.getValue();
            aux = aux.getProximo();
        }

        return montante / (this.length - 1);
    }

    public NumberList listarItensPares() {
        NumberList listaPares = new NumberList();
        Node aux = this.inicio;

        while (aux != null) {
            if (aux.getValue() % 2 == 0) {
                listaPares.inserirNoFim(new Node(aux.getValue()));
            }
            aux = aux.getProximo();
        }
        return listaPares;
    }

    public NumberList inserirDuploValorEncadeado(Node n1, Node n2, NumberList lista) {
        lista.inserirNoFim(n1);
        lista.inserirNoFim(n2);

        return lista;
    }

    public boolean obterMaiorDaLista(Node value) {
        if (this.isEmpty()) {
            return false;
        } else {
            Node aux = this.inicio;
            int maiorValor = 0;
            int posicao = 0;

            while (aux != null) {
                if (aux.getValue() > maiorValor) {
                    maiorValor = aux.getValue();
                }
                posicao++;
                aux = aux.getProximo();
            }

            value.setValue(maiorValor);
            return true;
        }
    }

    public boolean trocarElementos(int n1, int n2) {
//        Node node1 = this.obterUm(n1);
//        int valor1 = node1.getValue();
//        
//        Node node2 = this.obterUm(n2);
//        int valor2 = node2.getValue();
//
//        if (isEmpty() || (n1 > this.length || n1 < 0)|| (n2 > this.length || n2 < 0)) {
//            return false;
//        } else {
//            Node aux = this.inicio;
//            int i = 0;
//            
//            while (aux != null) {
//                if (i == n1) {
//                    node1 = aux;
//                }
//                if(i == n2){
//                    node2 = aux;
//                }
//                aux = aux.getProximo();
//                i++;
//            }
//           
//            node1.setValue(valor1);
//            node2.setValue(valor2);
//            
//            return true;

        if (isEmpty() || (n1 > this.length || n1 < 0) || (n2 > this.length || n2 < 0)) {
            return false;
        } else {
            Node node1 = this.obterUm(n1);
            Node node2 = this.obterUm(n2);

            int valor1 = node2.getValue();
            int valor2 = node1.getValue();

            node1.setValue(valor1);
            node2.setValue(valor2);

            return true;
        }
    }

    public Node obterUm(int index) {
        if (this.isEmpty()) {
            return null;
        } else {
            Node aux = this.inicio;

            for (int i = 0; i < index; i++) {
                aux = aux.getProximo();
            }

            return aux;
        }
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

    public String toStringInverso() {
        StringBuilder builder = new StringBuilder();

        if (this.isEmpty()) {
            System.out.println("Lista Vazia!");
        } else {
            Node aux = this.inicio;

            while (aux != null) {
                builder.insert(0, aux.toString());
                aux = aux.getProximo();
            }
        }
        return builder.toString();
    }

    public NumberList clonarLista() {
        return new NumberList(inicio, this.length);
    }

    public NumberList clonarListaLimpa() {
        List<Integer> valores = new ArrayList<Integer>();
        NumberList lista = new NumberList();
        Node aux = this.inicio;

        while (aux != null) {
            if (valores.indexOf(aux.getValue()) == -1) {
                valores.add(aux.getValue());
                lista.inserirNoFim(new Node(aux.getValue()));
            }
            aux = aux.getProximo();
        }

        return lista;
    }

    public NumberList clonarListaInversa() {
        NumberList lista = new NumberList();
        Node aux = this.inicio;

        while (aux != null) {
            lista.inserirNoInicio(new Node(aux.getValue()));
            aux = aux.getProximo();
        }

        return lista;
    }

    public int listarItensTotalizados() {
        Node aux = this.inicio;
        int total = 0;

        while (aux != null) {
            total += aux.getValue();
            aux = aux.getProximo();
        }

        return total;
    }

    public void inserirOrdenadoAsc(Node item) {
        if(isEmpty()){
            inserirNoInicio(item);
        }
        Node aux = this.inicio;
        int maiorValor = item.getValue();
        int valorAtual = aux.getValue();
        int indice = 0;

        while (maiorValor > valorAtual && aux != null) {
            indice ++;
            valorAtual = aux.getValue();
            aux = aux.getProximo();
        }
        
        this.inserir(item, indice);        
    }

    public NumberList mesclarEmOrdem(NumberList novaListaInversa) {
        Node aux = novaListaInversa.inicio;
        
        while(aux != null){
            this.inserirOrdenadoAsc(aux);
            aux = aux.getProximo();
        }
        
        return this;
    }
}
