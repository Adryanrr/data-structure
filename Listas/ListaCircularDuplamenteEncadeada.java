package Listas;

class No<T> {
    public T valor;
    public No<T> prox, prev;

    public No(T valor) {
        this.valor = valor;
        this.prox = null;
        this.prev = null;
    }
}

public class ListaCircularDuplamenteEncadeada<T> {
    public No<T> head;
    public int tamanho;

    public ListaCircularDuplamenteEncadeada() {
        this.head = null;
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
                head.prox = novo;
                head.prev = novo;
            } else {
                novo.prox = head;
                novo.prev = head.prev;
                head.prev.prox = novo;
                head.prev = novo;
                head = novo;
            }
        } else if (pos == tamanho) {
            novo.prox = head;
            novo.prev = head.prev;
            novo.prev.prox = novo;
            head.prev = novo;
        } else {
            No<T> atual = head;
            int i = 0;
            while (atual.prox != head && i < pos - 1) {
                atual = atual.prox;
            }
            novo.prox = atual.prox;
            novo.prev = atual;
            novo.prox.prev = novo;
            atual.prox = novo;
        }
        tamanho++;
        return true;
    }

    public boolean remover(int pos) {
        if (pos < 0 || pos >= tamanho) {
            return false;
        }

        if (head == null) {
            return false;
        }

        if (pos == 0) {
            if (tamanho == 1) {
                head = null;
            } else {
                head = head.prox;
                head.prev = head.prev.prev;
                head.prev.prox.prox = null;
                head.prev.prox.prev = null;
                head.prev.prox = head;
            }
        } else if (pos == tamanho) {
            head.prev = head.prev.prev;
            head.prev.prox.prev = null;
            head.prev.prox.prox = null;
            head.prev.prox = head;
        } else {
            No<T> atual = head;
            int i = 0;
            while (atual != head && i < pos) {
                atual = atual.prox;
                i++;
            }
            atual.prox.prev = atual.prev;
            atual.prev.prox = atual.prox;
            atual.prox = null;
            atual.prev = null;
        }
        tamanho--;
        return true;
    }
}
