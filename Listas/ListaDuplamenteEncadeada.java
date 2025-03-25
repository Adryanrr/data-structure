package Listas;

class No<T> {
    T valor;
    No<T> prox, prev;

    public No(T valor) {
        this.valor = valor;
        this.prox = null;
        this.prev = null;
    }
}

public class ListaDuplamenteEncadeada<T> {
    public No<T> head, tail;
    public int tamanho;

    public ListaDuplamenteEncadeada() {
        this.head = null;
        this.tail = null;
        this.tamanho = 0;
    }

    public boolean adicionar(int pos, T valor) {
        if (pos < 0 || pos > tamanho) {
            return false;
        }
        No<T> novo = new No<T>(valor);
        if (pos == 0) {
            if (head == null) {
                head = novo;
                tail = novo;
            } else {
                head.prev = novo;
                novo.prox = head;
                head = novo;
            }
        } else if (pos == tamanho) {
            tail.prox = novo;
            novo.prev = tail;
            tail = novo;
        } else {
            No<T> atual = head;
            for (int i = 0; i < pos - 1; i++) {
                atual = atual.prox;
            }
            novo.prox = atual.prox;
            atual.prox = novo;
            novo.prox.prev = novo;
            novo.prev = atual;
        }
        tamanho++;
        return true;
    }

    public void imprimir() {
        No<T> atual = head;
        while (atual.prox != null) {
            System.out.print(atual + " ");
            atual = atual.prox;
        }
        System.out.println("-> NULL");
    }

}