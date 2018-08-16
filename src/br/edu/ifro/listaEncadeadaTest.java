/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro;

import br.edu.ifro.listasEncadeadas.NumberList;
import br.edu.ifro.listasEncadeadas.Node;

/**
 *
 * @author igor-bueno
 */
public class listaEncadeadaTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NumberList lista = new NumberList();

        for (int i = 0; i < 10; i++) {
            lista.inserir(new Node(i), i);
        }

        //Exercicio 1
        System.out.println("Exercicio 1");
        System.out.println(lista.contarItensPares());

        //Exercício 2
        System.out.println("Exercicio 2");
        System.out.println(lista.listarItensPares().toString());

        //Exercício 3
        System.out.println("Exercicio 3");
        System.out.println(lista.calcularMedia());

        //Exercício 4
        System.out.println("Exercicio 4");
        System.out.println(lista.inserirDuploValorEncadeado(new Node(1), new Node(2), new NumberList()).toString());

        //Exercício 5
        System.out.println("Exercicio 5");
        System.out.println(lista.toStringInverso());

        //Exercício 6
        System.out.println("Exercicio 6");
        System.out.println(lista.removerPrimeiros(3));
        System.out.println(lista.toString());

        //Exercício 7
        System.out.println("Exercicio 7");
        Node node = new Node();
        System.out.println(lista.obterMaiorDaLista(node));
        System.out.println(node);

        //Exercício 8
        System.out.println("Exercicio 8");
        lista.inserirOrdenadoAsc(new Node(5));
        System.out.println(lista.toString());

        // Exercício 9
        System.out.println("Exercício 9");
        System.out.println(lista.trocarElementos(0, 1));
        System.out.println(lista.toString());

        // Exercício 10
        System.out.println("Exercício 10");

        // Exercício 11
        System.out.println("Exercício 11");
        NumberList novaLista = lista.clonarLista();
        System.out.println(novaLista.toString());

        //Exercício 12
        System.out.println("Exercício 12");
        NumberList novaListaLimpa = lista.clonarListaLimpa();
        System.out.println(novaListaLimpa);

        //Exercício 13
        System.out.println("Exercício 13");
        NumberList novaListaInversa = lista.clonarListaInversa();
        System.out.println(novaListaInversa);

        //Exercício 14
        System.out.println("Exercício 14");
        System.out.println(lista.mesclarEmOrdem(novaListaInversa));

        //Exercício 15
        System.out.println("Exercício 15");
        System.out.println(lista.listarItensTotalizados());

    }

}
