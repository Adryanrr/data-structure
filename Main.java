import java.util.LinkedList;

class Main{
    public static void main(String[] args){
        LinkedList<String> nomes = new LinkedList<>();
        nomes.add("Andre");
        nomes.add("Felipe");
        nomes.removeFirst();
        System.out.println(nomes);

    }
}

