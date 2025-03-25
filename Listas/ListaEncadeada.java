package Listas;

class No<T> {
    public T valor;
    public No<T> prox;

    public No(T valor) {
        this.valor = valor;
        this.prox = null;
    }
}

public class ListaEncadeada<T> {
    public No<T> head;
    public int tamanho;

    public ListaEncadeada() {
        head = null;
        tamanho = 0;
    }

    public boolean adicionar(int pos, T valor) {
        if (pos < 0 || pos > tamanho) {
            return false;
        }
        No<T> novo = new No<T>(valor);

        if (pos == 0) {
            if (head == null) {
                this.head = novo;
            } else {
                novo.prox = head;
                head = novo;
            }
        } else {
            No<T> atual = head;
            int i = 0;
            while (atual != null && i < pos - 1) {
                atual = atual.prox;
                i++;
            }
            novo.prox = atual.prox;
            atual.prox = novo;
        }
        tamanho++;
        return true;
    }

    public boolean remover(int pos) {
        if (pos < 0 || pos >= tamanho) {
            return false;
        }
        if (pos == 0) {
            if (head == null) {
                return false;
            } else {
                head = head.prox;
            }
        }
        No<T> atual = head;
        for (int i = 0; i < pos - 1; i++) {
            atual = atual.prox;
        }
        atual.prox = atual.prox.prox;
        tamanho--;
        return true;
    }

    public void imprimir() {
        No<T> atual = head;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.prox;
        }
        System.out.println("-> NULL");
    }

    public static void main(String[] args) {
        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
        lista.adicionar(0, 10);
        lista.adicionar(1, 20);
        lista.adicionar(2, 30);
        lista.imprimir();
        lista.remover(1);
        lista.imprimir();
    }
}
