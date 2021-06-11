package datastructure;

public class DoublyLinkedListDriver {

    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.print();
        linkedList.print();
        linkedList.remove(3);
        linkedList.print();
    }

}
