package Stacks;

import LinkedList.ListaLigada;

public class Pilha<TYPE> {
    private ListaLigada<TYPE> lista;

    //* Construtor da pilha
    public Pilha(){
        this.lista = new ListaLigada<>();
    }

    //* PUSH: Adiciona um elemento ao topo da pilha.
    public void adicionarTopo(TYPE novoValor){
        this.lista.addStart(novoValor); 
    }

    //* PEEK  Retorna o elemento do topo da pilha sem removê-lo.
    public TYPE peek(){
        if (this.lista.getTamanho()==0) {
            throw new IllegalStateException("A pilha está vazia");
        }
        return this.lista.getPrimeiro().getValor();
    }

    //*POP: Remove e retorna o elemento que está no topo da pilha.
    public TYPE pop(){
        if(this.lista.getTamanho()==0){
            throw new IllegalStateException("A pilha está vazia");
        }
        TYPE valorTopo = this.peek();
        this.lista.remover(valorTopo);
        return valorTopo;
    }

    //* IS EMPTY: Retorna True se a pilha estiver vazia, senão retorna False.
    public boolean isEmpty(){
        return this.lista.getTamanho() == 0;
    }

    //* Size: Retorna o número de elementos atualmente na pilha. 
    public int  size(){
        return this.lista.getTamanho();
    }

}
