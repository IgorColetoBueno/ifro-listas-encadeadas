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
public class ItemVenda {
    private int codigo;
    private String nome;
    private double quantidade;
    private double valorUnitario;
    private double valorTotal;

    public ItemVenda() {
    }

    public ItemVenda(int codigo, String nome, double quantidade,double valorUnitario, double valorTotal) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
    }

    public double getValorunitario() {
        return valorUnitario;
    }

    public void setValorunitario(double valorunitario) {
        this.valorUnitario = valorunitario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return this.valorUnitario * quantidade;
    }

    @Override
    public String toString() {
        return "ItemVenda{" + "codigo=" + codigo + ", nome=" + nome + ", quantidade=" + quantidade + ", valorTotal=" + valorTotal + '}';
    }   
    
}
