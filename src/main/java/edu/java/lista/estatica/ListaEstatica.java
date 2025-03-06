package edu.java.lista.estatica;

public class ListaEstatica {
    private int[] valor;
    private  int ultimo;
    private int tamanho;

    public ListaEstatica(int pos){
        this.tamanho = pos;
        this.valor = new int[pos];
        this.ultimo = -1;
    }


    public boolean add(int elemento, int pos){
        if (pos < 0 || pos > ultimo + 1 || ultimo + 1 >= tamanho){
            return false;
        }
        for (int i = ultimo; i>= pos; i--){
            valor[i+1] = valor[i];
        }

        valor[pos] = elemento;
        ultimo++;
        return true;
    }

    public boolean remove(int pos){
        if (pos < 0 || pos> ultimo){
            return false;
        }
        for (int i = pos; i<ultimo; i++){
            valor[i] = valor[i+1];
        }
        return true;
    }

    public void print(){
     for (int i = 0; i<=ultimo; i++){
            System.out.print(valor[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica(5);
        lista.add(1,0);
        lista.add(2,1);
        lista.add(3,2);
        lista.add(4,3);
        lista.add(5,4);

        lista.print();

    }
}