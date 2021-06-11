package datastructure;

public class DoublyLinkedList {

    class Node {
        Node prev;
        Node next;
        int val;

        Node(int val) {
            this.val = val;
        }
    }

    Node head, tail = null;

    //if list is empty add to head, else add to tail...
    public void add(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = tail = node;
            head.prev = null;
            head.next = null;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
            tail.next = null;
        }
    }

    public int remove(int data) {
        Node current = head;
        int removed = -1;
        while (current != null) {
            if (current.val == data) {
                removed = data;
                if (current.next != null && current.prev != null) {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;

                } else if (current.next == null) {
                    tail = current.prev;
                    tail.next = null;
                } else {
                    head = current.next;
                    head.prev = null;
                }
            }
            current = current.next;
        }
        return removed;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.val + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

}

