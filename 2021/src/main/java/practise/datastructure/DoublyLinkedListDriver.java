package practise.datastructure;

public class DoublyLinkedListDriver {

    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
       linkedList.print();
       System.out.println(linkedList.removeLRU());
       linkedList.bringAhead(2);
       linkedList.print();
    }

}
