public class Deque<T> {
    No<T> head;
    No<T> tail;
    int tamanho;

    public Deque() {
        this.head = null;
        this.tail = null;
        tamanho = 0;
    }

    public boolean isEmpty() {
        if (head == null) {
            System.out.println("Lista vazia");
            return false;
        }
        return true;
    }

    public boolean addLeft(T valor) {
        No<T> novo = new No<>(valor);
        if (head == null) {
            head = novo;
            tail = novo;
        } else {
            novo.prox = head;
            head.ant = novo;
            head = novo;
        }
        tamanho++;
        return true;
    }

    public No<T> firstLeft() {
        return head;
    }

    public No<T> removeLeft() {
        No<T> elemento = head;
        if (head == null) {
            return null;
        } else if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.prox;
        }
        tamanho--;
        return elemento;
    }

    public boolean addRight(T valor) {
        No<T> novo = new No<>(valor);
        if (tail == null) {
            tail = novo;
            head = novo;
        } else {
            tail.prox = novo;
            novo.ant = tail;
            tail = novo;
        }
        tamanho++;
        return true;
    }

    public No<T> firstRight() {
        return tail;
    }

    public No<T> removeRight() {
        if (this.tamanho == 0) {
            throw new NullPointerException("erro, deque está vazio");
        }

        No<T> elemento = tail;

        if (tail == head) {
            head = null;
            tail = null;
        } else {
            tail = tail.ant;
            tail.prox = null;
            elemento.ant = null;
        }
        tamanho--;
        return elemento;
    }

    public void pecaNaMesa() {
        if (head == null) {
            System.out.println("Sem peças na mesa");
            return;
        }
        No<T> atual = head;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.prox;
        }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        Deque<String> domino = new Deque<>();
        domino.addLeft("[6|3]");
        domino.addRight("[3|3]");
        domino.addLeft("[5|6]");
        domino.addRight("[3|4]");

        domino.pecaNaMesa();

        // domino.removeLeft();
        domino.removeRight();
        domino.removeRight();
        domino.removeRight();
        domino.removeRight();

        domino.pecaNaMesa();

    }
}