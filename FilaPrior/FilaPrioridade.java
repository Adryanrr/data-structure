class No<T> {
    T valor;
    No<T> prox;
    int prioridade;

    public No(T valor, int prioridade) {
        this.valor = valor;
        this.prioridade = prioridade;
        this.prox = null;
    }
}

public class FilaPrioridade<T> {

    No<T> head;
    No<T> tail;
    int tamanho;

    public FilaPrioridade() {
        this.head = null;
        this.tail = null;
        this.tamanho = 0;
    }

    public boolean enqueue(T valor, int prioridade) {
        No<T> novo = new No<>(valor, prioridade);

        if (tamanho == 0) {
            head = novo;
            tail = novo;
        } else {
            No<T> atual = head;
            while (atual.prox != null && novo.prioridade < atual.prox.prioridade) {
                atual = atual.prox;
            }
            if (atual == head && novo.prioridade >= atual.prioridade) {
                novo.prox = head;
                head = novo;
            } else if (atual == tail) {
                atual.prox = novo;
                tail = novo;
            } else {
                novo.prox = atual.prox;
                atual.prox = novo;
            }
        }
        tamanho++;
        return true;
    }

    public boolean hallOfFame(T nome, int score) {
        No<T> novo = new No<>(nome, score);

        if (tamanho == 0) {
            head = novo;
            tail = novo;
        } else {
            No<T> atual = head;
            while (atual.prox != null && novo.prioridade > atual.prox.prioridade) {
                atual = atual.prox;
            }
            if (atual == head && novo.prioridade <= atual.prioridade) {
                novo.prox = head;
                head = novo;
            } else if (atual == tail) {
                atual.prox = novo;
                tail = novo;
            } else {
                novo.prox = atual.prox;
                atual.prox = novo;
            }
        }
        tamanho++;
        return true;
    }

    public T dequeue() {
        if (head == null) {
            System.out.println("NULL");
            return null;
        }
        No<T> elemento;
        if (head == tail) {
            elemento = head;
            head = null;
            tail = null;
        } else {
            No<T> atual = head;
            while (atual.prox != tail) {
                atual = atual.prox;
            }
            elemento = atual.prox;
            tail = atual;
            atual.prox = null;
        }
        tamanho--;
        return elemento.valor;
    }

    public void imprimir() {
        No<T> atual = head;
        if (atual == null) {
            System.out.println("Lista está vazia");
            return;
        }
        while (atual != null) {
            System.out.print("[" + atual.prioridade + "] " + atual.valor + " -> ");
            atual = atual.prox;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        FilaPrioridade<String> queue = new FilaPrioridade<>();

        queue.hallOfFame("Little chico", 1000);
        queue.hallOfFame("Andre", 9890);
        queue.hallOfFame("Luxiane", 9700);
        queue.hallOfFame("Adryan", 9000);
        queue.hallOfFame("Felipe", 9100);
        queue.hallOfFame("Whuanderson", 9300);
        queue.hallOfFame("Pablo", 9600);

        queue.imprimir();

    }
}