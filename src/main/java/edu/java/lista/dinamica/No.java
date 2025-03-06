package edu.java.lista.dinamica;
/*Em uma lista dinâmica, um nó é uma unidade que contém dados
e um ponteiro para o próximo nó. Ele permite que a lista seja
flexível, sem posições fixas como em arrays.*/

public class No {
    int valor;
    No prox;

    public No(int valor){
        this.valor = valor;
        this.prox = null;
    }
}
