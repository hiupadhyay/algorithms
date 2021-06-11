package easy;

public class ReverseLinkedList {


    public static void main(String[] args) {
        LinkedList reverseLinkedList = new LinkedList();
        reverseLinkedList.add(1);
        reverseLinkedList.add(2);
        reverseLinkedList.add(3);
        reverseLinkedList.print();
        reverseLinkedList.reverse();
        reverseLinkedList.print();
    }
}

class LinkedList {

    /**
     * Reverse Logic is quite simple, just like swapping..
     * Steps:
     * 1) Just visualize the current linkedlist 3 -> 2 -> 1 -> null
     * 2) Now, if you see to reverse this NULL <-3<-2 ->1->null this is required as step 1.
     * 3) to do that,
     *      3.1)head.next should point to my current Node that starts with null. i.e NULL <- head [3]
     *      3.2) for next iterations next prev would be current Node i.e prev=3 or prev=head;
     *      3.3)the current head that will carry on iteration would point to tmp i.e tmp=2
     *
     */
    public void reverse() {
        Node prev = null;
        while (head != null) {
            Node tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        head = prev;
    }

    Node head;

    public void add(int val) {
        if (head == null)
            head = new Node(val);
        else {
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
        }
    }

    public void print() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    static class Node {

        Node next;
        int val;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
