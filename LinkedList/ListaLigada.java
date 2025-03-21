package LinkedList;

public class ListaLigada<TYPE> {
    private No<TYPE> primeiro;
    private No<TYPE> ultimo;
    private int tamanho;

    public ListaLigada() {
        this.tamanho = 0;
    }

    public No<TYPE> getPrimeiro() {
        return this.primeiro;
    }

    public void setPrimeiro(No<TYPE> primeiro) {
        this.primeiro = primeiro;
    }

    public No<TYPE> getUltimo() {
        return this.ultimo;
    }

    public void setUltimo(No<TYPE> ultimo) {
        ultimo = this.ultimo;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    public void setTamanho(int tamanho) {
        tamanho = this.tamanho;
    }

    public void adicionar(TYPE novoValor) {
        No<TYPE> novoNo = new No<TYPE>(novoValor);
        if (this.primeiro == null && this.ultimo == null) {
            this.primeiro = novoNo;
            this.ultimo = novoNo;
        } else {
            this.ultimo.setProximo(novoNo);
            ultimo = novoNo;
        }
        this.tamanho++;
    }

    public void addStart(TYPE novoValor) {
        No<TYPE> novoNo = new No<TYPE>(novoValor);
        if (this.primeiro == null && this.ultimo == null) {
            this.primeiro = novoNo;
            this.ultimo = novoNo;
        } else {
            novoNo.setProximo(this.primeiro);
            this.primeiro = novoNo;
        }
        this.tamanho++;
    }

    public void remover(TYPE valorProcurado) {
        if (this.primeiro == null)
            return;

        No<TYPE> anterior = null;
        No<TYPE> atual = this.primeiro;

        while (atual != null) {
            if (atual.getValor().equals(valorProcurado)) {
                if (atual == primeiro) {
                    primeiro = primeiro.getProximo();
                    if (primeiro == null)
                        ultimo = null;
                } else {
                    anterior.setProximo(atual.getProximo());
                    if (atual == primeiro)
                        primeiro = anterior;
                }
                this.tamanho++;
                return;
            }

            anterior = atual;
            atual = anterior.getProximo();
        }
    }

    public TYPE get(int posicao) {
        No<TYPE> atual = this.primeiro;
        for (int i = 0; i <= posicao; i++) {
            if (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
        }
        return atual.getValor();
    }

    public void getAll() {
        No<TYPE> atual = this.primeiro;

        if (this.primeiro == null) {
            System.out.println("null");
            return;
        }

        while (atual != null) {
            System.out.print(atual.getValor() + " ");
            atual = atual.getProximo();
        }
        System.out.println(" -> NULL");
    }

    private int contarPares() {
        No<TYPE> atual = primeiro;
        int pares = 0;
        while (atual != null) {
            Integer valor = (Integer) atual.getValor();
            if (valor % 2 == 0) {
                pares++;
            }
        }
        return pares;
    }

    public void OrderToEnd() {
        if (primeiro == null || primeiro.getProximo() == null)
            return;
        // Verifica se TYPE é Integer — safe cast
        if (primeiro.getValor() instanceof Integer) {
            int pares = contarPares();
            while (pares != 0) { // numero de vezes que vai executar a ordenaćão
                Integer valor = (Integer) primeiro.getValor();
                No<TYPE> atual = primeiro;
                if (valor % 2 == 0) {
                    No<TYPE> end = atual;
                    while (end.getProximo() != null) {
                        end = end.getProximo();
                    }
                    end.setProximo(atual);
                    primeiro = atual.getProximo();
                    atual.setProximo(null);
                }

            }
            // Atualizar a head.
            // ligar a sequencia.
            pares--;
        }
        getAll();
    }
}
