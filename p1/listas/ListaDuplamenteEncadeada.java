package p1.listas;

class No<T> {
    T valor;
    No<T> prox;
    No<T> ant;

    public No(T valor) {
        this.valor = valor;
        this.prox = null;
        this.ant = null;
    }
}

public class ListaDuplamenteEncadeada<T> {
    No<T> head;
    No<T> tail;
    int tamanho;

    public ListaDuplamenteEncadeada() {
        this.head = null;
        this.tail = null;
        tamanho = 0;
    }

    public boolean adicionar(T valor, int pos) {
        if (pos < 0 || pos > tamanho) {
            return false;
        }
        No<T> novoNo = new No<T>(valor);

        if (pos == 0) {
            novoNo.prox = this.head;
            if (this.head != null) {
                this.head.ant = novoNo;
            }
            this.head = novoNo;
            if (this.tail == null) {
                this.tail = novoNo;
            }
            this.tail = novoNo;
        } else if (pos == tamanho) {
            novoNo.ant = this.tail;
            this.tail.prox = novoNo;
            this.tail = novoNo;
        } else {
            No<T> atual = head;
            for (int i = 0; i < pos - 1; i++) {
                atual = atual.prox;
            }
            novoNo.prox = atual.prox;
            novoNo.ant = atual;
            if (atual.prox != null) {
                atual.prox.ant = novoNo;
            }
            atual.prox = novoNo;
        }
        tamanho++;
        return true;
    }

    public No<T> remover(int pos) {
        if (pos < 0 || pos > tamanho) {
            return null;
        }
        No<T> removido;
        if (pos == 0) {
            removido = this.head;
            removido.prox = this.head;
            if (this.head != null) {
                this.head.ant = null;
            } else {
                this.tail = null;
            }
        } else {
            No<T> atual = this.head;
            for (int i = 0; i < pos; i++) {
                atual = atual.prox;
            }
            removido = atual.prox;
            atual.prox = removido.prox;
            if (removido.prox == null) {
                this.tail = removido.ant;
            }
            if (removido != null) {
                removido.prox.ant = atual;
            }
        }
        removido.prox = null;
        removido.ant = null;
        tamanho--;
        return removido;
    }
}
