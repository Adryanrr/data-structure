package p1;

class No<T> {
    T valor;
    No<T> prox;

    public No(T valor) {
        this.valor = valor;
        this.prox = null;
    }

}

public class ListaEncadeada<T> {
    private No<T> head;
    private int tamanho;

    public ListaEncadeada() {
        this.head = null;
        this.tamanho = 0;
    }

    public boolean adicionar(T valor, int pos) {
        if (pos < 0 || pos > tamanho) {
            return false;
        }

        No<T> novoValor = new No<T>(valor);
        if (pos == 0) {
            novoValor.prox = this.head;
            this.head = novoValor;
        } else {
            No<T> atual = head;
            for (int i = 0; i < pos - 1; i++) {
                atual = atual.prox;
            }
            novoValor.prox = atual.prox;
            atual.prox = novoValor;
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
            this.head = removido.prox;
            removido.prox = null;
            tamanho--;
            return removido;
        } else {
            No<T> atual = head;
            for (int i = 0; i < pos - 1; i++) {
                atual = atual.prox;
            }
            removido = atual.prox;
            atual.prox = removido.prox;
            removido.prox = null;
            return removido;
        }
    }

    public void imprimi() {
        No<T> atual = head;
        while (atual != null) {
            System.out.print(atual + "->");
        }
        System.out.println("-> NULL");
    }
}
