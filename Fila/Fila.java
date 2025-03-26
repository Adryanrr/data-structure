class No<T> {
    T valor;
    No<T> prox;

    public No(T valor) {
        this.valor = valor;
        this.prox = null;
    }
}

public class Fila<T> {
    No<T> head, tail;
    int tamanho;

    public Fila() {
        this.head = null;
        this.tail = null;
        tamanho = 0;
    }

    public boolean enqueue(T valor) {
        No<T> novo = new No<>(valor);

        if (head == null) {
            head = novo;
            tail = head;
        } else {
            novo.prox = head;
            head = novo;
        }
        tamanho++;
        return true;
    }

    public T dequeue() {
        No<T> elemento = tail;
        if (head == null) {
            System.out.println("Lista vazia");
            return null;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            No<T> atual = head;
            while (atual.prox != tail) {
                atual = atual.prox;
            }
            atual.prox = null;
            tail = atual;
        }
        tamanho--;
        return elemento.valor;
    }

    public void printQueue() {
        if (head == null) {
            System.out.println("Lista Vazia");
            return;
        }
        No<T> atual = head;
        do {
            System.out.print(atual.valor + " -> ");
            atual = atual.prox;
        } while (atual != null);
        System.out.println(" [EXIT] ");
    }

    public static void main(String[] args) {
        Fila<String> fila = new Fila<>();
        System.out.println(fila.enqueue("Adryan"));
        fila.enqueue("Andre");
        fila.enqueue("Whuanderson");
        fila.enqueue("Felipe");

        fila.printQueue(); // Saída esperada: Adryan Andre Whuanderson Felipe

        for (int i = 0; i < 4; i++) { // Corrigido para evitar erro de indexação
            fila.dequeue();
            fila.printQueue();
        }
    }
}