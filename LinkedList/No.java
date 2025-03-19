package LinkedList;

public class No<TYPE> {
    private TYPE valor;
    private No<TYPE> proximo;

    public No(TYPE valor){
        this.valor = valor;
        this.proximo = null;
    }

    public TYPE getValor(){
        return this.valor;
    }

    public void setValor(TYPE valor){
        valor = this.valor;
    }

    public No<TYPE> getProximo(){
        return proximo;
    }

    public void setProximo(No<TYPE> proximo){
        this.proximo = proximo;
    }
}