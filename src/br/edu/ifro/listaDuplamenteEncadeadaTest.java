/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro;

import br.edu.ifro.listasDuplamenteEncadeadas.ItemVenda;
import br.edu.ifro.listasDuplamenteEncadeadas.Lista;
import br.edu.ifro.listasDuplamenteEncadeadas.ListaNumerica;
import br.edu.ifro.listasDuplamenteEncadeadas.ListaVenda;
import br.edu.ifro.listasDuplamenteEncadeadas.Node;

/**
 *
 * @author igor-bueno
 */
public class listaDuplamenteEncadeadaTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws CloneNotSupportedException {

        //Listas para utilizar nos testes
        ListaNumerica primeiraListaNumerica = new ListaNumerica();
        ListaNumerica segundaListaNumerica = new ListaNumerica();
        ListaVenda listaVenda = new ListaVenda();

        for (int i = 0; i < 10; i++) {
            primeiraListaNumerica.inserirNoFim(new Node(i));
            segundaListaNumerica.inserirNoFim(new Node(i));
            listaVenda.inserirNoFim(new Node<ItemVenda>(new ItemVenda(i, "Produto " + i, i, i, i)));
        }

        //Exercício 1
        System.out.println("\n *Exercício 1");
        primeiraListaNumerica.removerUltimo();
        primeiraListaNumerica.removerPrimeiro();

        System.out.println(primeiraListaNumerica.toString());

        //Exercício 2
        System.out.println("\n *Exercício 2");
        System.out.println("Maior elemento: " + segundaListaNumerica.buscarMaiorItem().toString());
        System.out.println("Menor elemento: " + segundaListaNumerica.buscarMenorItem().toString());
        System.out.println("Média: " + segundaListaNumerica.buscarMediaDeItens());

        //Exercício 3
        System.out.println("\n *Exercício 3");
        System.out.println("Quantidade de pares: " + segundaListaNumerica.buscarQuantidadeDePares());

        //Exercício 4
        System.out.println("\n *Exercício 4");
        ListaNumerica listaSubstituida = listaSubstituida = ListaNumerica.substituir(segundaListaNumerica, 0, 9);
        System.out.println(listaSubstituida.toString());

        //Exercício 5
        //Exercício 6
        System.out.println("\n *Exercício 6");
        System.out.println(listaVenda.toString());
        System.out.println("Total: " + listaVenda.obterValorTotal());

        //Exercicio 7
        System.out.println("\n *Exercício 7");
        ListaNumerica numerosClonados = segundaListaNumerica.clone();
        System.out.println("Clonando lista para testar se são iguais:" + segundaListaNumerica.comparar(numerosClonados));

        //Exercício 8
        System.out.println("\n *Exercício 8");
        System.out.println("Verificando a ordenação das listas: " + segundaListaNumerica.verificarOrdenacao());

        //Exercício 9
        System.out.println("\n *Exercício 9");
        System.out.println("Lista fatiada:" + ListaNumerica.fatiarLista(segundaListaNumerica, 3));
        
        //Exercício 10
        System.out.println("\n *Exercício 10");
        System.out.println(segundaListaNumerica.concatenar(numerosClonados));

    }

}
