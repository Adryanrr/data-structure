public class No<T> {
    T valor;
    No<T> prox;
    No<T> ant;

    public No(T valor) {
        this.valor = valor;
        this.prox = null;
        this.ant = null;
    }
}