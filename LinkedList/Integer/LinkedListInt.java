package LinkedList.Integer;

import LinkedList.No;

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

    public void GetAllInt() {
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

    private int countPair() {
        Node current = head;
        int pair = 0;
        while (current != null) {
            if (current.value % 2 == 0) {
                pair++;
            }
        }
        return pair;
    }

    public void OrderToPair() {
        if (head == null || head.next == null) {
            System.out.println("Não foi possivel ordenar");
            return;
        }

        int pair = countPair();
        Node current = head;

        while (pair != 0) {
            Node end = head;
            if (current.value % 2 == 0) {
                Node toEnd = current;
                while (toEnd.next != null) {
                    toEnd = toEnd.next;
                }
                end.next = current;
                pair--;
            }
            head = current.next;
            end = current;

        }

    }

}