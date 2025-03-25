package Listas;

class No<T> {
    public T valor;
    public No<T> prox;

    public No(T valor) {
        this.valor = valor;
        this.prox = null;
    }
}

public class ListaCircular<T> {
    public No<T> head;
    public int tamanho;

    public ListaCircular() {
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
            } else {
                No<T> atual = head;
                while (atual.prox != head) {
                    atual = atual.prox;
                }
                novo.prox = head;
                atual.prox = novo;
                head = novo;
            }
        } else {
            No<T> atual = head;
            for (int i = 0; i < pos - 1; i++) {
                atual = atual.prox;
            }
            novo.prox = atual.prox;
            atual.prox = novo;
        }
        tamanho++;
        return true;
    }

    public void imprimir() {
        if (head == null) {
            System.out.println("Lista vazia.");
            return;
        }
        No<T> atual = head;
        do {
            System.out.print(atual.valor + " -> ");
            atual = atual.prox;
        } while (atual != head);
        System.out.println("(volta ao início)");
    }

    public static void main(String[] args) {
        ListaCircular<Integer> lista = new ListaCircular<>();
        lista.adicionar(0, 10);
        lista.adicionar(1, 20);
        lista.adicionar(2, 30);
        lista.imprimir();

        lista.adicionar(1, 15);
        lista.imprimir();
    }
}