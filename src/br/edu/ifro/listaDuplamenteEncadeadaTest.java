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

        Lista<Integer> lista = new Lista<>();
        ListaNumerica numeros = new ListaNumerica();
        ListaVenda listaVenda = new ListaVenda();

        for (int i = 0; i < 10; i++) {
            lista.inserirNoFim(new Node(i));
            numeros.inserirNoFim(new Node(i));
            listaVenda.inserirNoFim(new Node<ItemVenda>(new ItemVenda(i,"Produto "+i,i,i,i)));
        }

        //Exercício 1
        lista.removerUltimo();
        lista.removerPrimeiro();

        System.out.println(lista.toString());

        //Exercício 2
        System.out.println("Maior elemento: " + numeros.buscarMaiorItem().toString());
        System.out.println("Menor elemento: " + numeros.buscarMenorItem().toString());
        System.out.println("Média: " + numeros.buscarMediaDeItens());

        //Exercício 3
        System.out.println("Quantidade de pares: " + numeros.buscarQuantidadeDePares());

        //Exercício 4
        ListaNumerica listaSubstituida = listaSubstituida = ListaNumerica.substituir(numeros, 0, 9);
        System.out.println(listaSubstituida.toString());
        
        //Exercício 6
        System.out.println(listaVenda.toString());
        System.out.println("Total: "+listaVenda.obterValorTotal());
        
        //Exercicio 7
        Lista<Integer> numerosClonados = numeros.clone();
        System.out.println("Clonando lista para testar se são iguais:" + numeros.comparar(numerosClonados));
        
        //Exercício 8
        //Exercício 9
        //Exercício 10
        System.out.println(numeros.concatenar(numerosClonados));
        
    }

}
