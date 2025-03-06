package edu.java.lista.ligada;

public class ListaLigada {
    private No primeiro;
    private No ultimo;
    private int tamanho;

    public ListaLigada(){
        this.tamanho = 0;
    }

    public No getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(No primeiro) {
        this.primeiro = primeiro;
    }

    public No getUltimo() {
        return ultimo;
    }

    public void setUltimo(No ultimo) {
        this.ultimo = ultimo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public void adicionar(String novoElemento){
        No novoNo = new No(novoElemento);
        if (this.primeiro == null && this.ultimo == null){
            this.primeiro = novoNo;
            this.ultimo = novoNo;
        }else {
            this.ultimo.setProx(novoNo);
            this.ultimo = novoNo;
        }
        this.tamanho++;
    }

    public void remover(String valorProcurado){
        No anterior = null;
        No atual = this.primeiro;
        for (int i=0; i < this.getTamanho(); i++){
            if (atual.getElemento().equalsIgnoreCase(valorProcurado)){
                if (this.tamanho == 1){
                    this.primeiro = null;
                    this.ultimo = null;
                } else if (atual == primeiro) {
                    this.primeiro = atual.getProx();
                    atual.setProx(null);
                } else if (atual == ultimo) {
                    this.ultimo = anterior;
                    anterior.setProx(null);
                }else {
                    anterior.setProx(atual.getProx());
                    atual = null;
                }
                this.tamanho--;
                break;
            }
            anterior = atual;
            atual = atual.getProx();
        }
    }

    public No get(int posicao){
        No atual = this.primeiro;
        for (int i=0; i < posicao; i++){
            if (atual.getProx() != null){
                atual = atual.getProx();
            }
        }
        return atual;
    }

}