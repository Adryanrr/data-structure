package edu.java.lista.ligada;

public class No {
    private String elemento;
    private No prox;

    public No(String novoElemento){
        this.elemento = novoElemento;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }
}
