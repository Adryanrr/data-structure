package edu.java.lista.dinamica;

public class ListaDinamica {
    private No inicio;

    public ListaDinamica(){
        this.inicio = null;
    }

    public boolean add(int elemento, int pos){
        No novoNo = new No(elemento);

        if(pos <0){
            return false;
        }

        if (pos == 0){ // caso para quando é o primeiro elemento a ser adicionado
            novoNo.prox = inicio;
            inicio = novoNo;
            return true;
        }

        No atual = inicio;
        int i = 0;

        while (atual!= null && i <pos -1){
            atual = atual.prox;
            i++;
        }
        if(atual == null){
            return false;
        }

        novoNo.prox = atual.prox;
        atual.prox = novoNo;
        return true;
    }

    public boolean remove(int pos){
        if (inicio == null || pos <0){
            return false;
        }

        if (pos == 0){
            inicio = inicio.prox;
            return true;
        }

        No atual = inicio;
        int i = 0;

        while (atual.prox != null && i < pos-1){
            atual = atual.prox;
            i++;
        }

        if (atual.prox == null){
            return false;
        }

        atual.prox = atual.prox.prox;
        return true;
    }

    public void print(){
        No atual = inicio;
        while (atual != null){
            System.out.println(atual.valor + "");
            atual = atual.prox;
        }
        System.out.println();
    }

    public int search(int valor){
        No atual = inicio;
        while (atual != null){
            if (atual.valor == valor){
                return atual.valor;
            }
            atual = atual.prox;
        }
        return  -1;
    }

    public No search(No atual, int valor, int pos){
    if (atual == null) {
        return null;  // Caso base: nó não encontrado
    }

    if (atual.valor == valor) {
        System.out.println("Valor encontrado na posição: " + pos);  // Exibe a posição
        return atual;  // Retorna o nó encontrado
    }

    return search(atual.prox, valor, pos + 1);  // Chama recursivamente com o próximo nó
    }

    public void toSearch(int valor){
        No resultado = search(inicio,valor,0);
        if (resultado != null){
            System.out.println("Valor " + resultado.valor);
        }else{
           System.out.println("Valor não encontrado");
        }
    }

    public static void main(String[] args){
        ListaDinamica lista = new ListaDinamica();
        lista.add(5,0);
        lista.add(10,1);
        lista.add(15,2);
        lista.add(20,3);

        lista.print();

        lista.toSearch(35);
    }
}
