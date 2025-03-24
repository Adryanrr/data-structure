package LinkedList.Integer;

public class LinkedListInt {
    public Node head;
    public int size;

    public LinkedListInt() {
        this.size = 0;
    }

    public boolean addInt(int newValue) {
        Node newNode = new Node(newValue);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return true;
    }

    public boolean removeInt(int searchValue) {
        Node removeNode = new Node(searchValue);
        if (head == null) {
            return false;
        }

        Node current = head;
        while (current.next != removeNode) {
            current = current.next;
        }

        Node e = current.next;
        current.next = e.next;
        e.next = null;

        return true;
    }

    public void getAllInt() {
        Node current = head;

        if (head == null) {
            System.out.println("NULL");
            return;
        }
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println("-> NULL");
    }

    public void OrderToPair() {
        if (head == null || head.next == null) {
            System.out.println("Não foi possível ordenar");
            return;
        }

        Node dummyHead = new Node(0); // Nó fictício para facilitar operações
        dummyHead.next = head;

        Node tail = head;
        // Primeiro, encontra o último nó da lista original
        while (tail.next != null) {
            tail = tail.next;
        }

        Node originalTail = tail; // Para saber até onde iterar
        Node prev = dummyHead;
        Node current = head;

        while (current != null && current != originalTail.next) {
            if (current.value % 2 == 0) {
                // Remove current da posição atual
                prev.next = current.next;

                // Move current para o final
                tail.next = current;
                current.next = null;
                tail = current;

                // Avança para o próximo nó (após o anterior current)
                current = prev.next;
            } else {
                prev = current;
                current = current.next;
            }
        }

        head = dummyHead.next;
        getAllInt();
    }
}