package medium;

//
public class DetectCycleLinkedList {


    public static void main(String[] args) {
        DetectCycleLinkedList detectCycleLinkedList = new DetectCycleLinkedList();
        Node node = new Node(3);
        node.next = new Node(2);
        node.next.next = new Node(0);
        node.next.next.next = new Node(-4);
        node.next.next.next = node.next;
        Node n = detectCycleLinkedList.detectCycleNode(node);
        System.out.println(n.val);
    }

    private Node detectCycleNode(Node node) {
        Node slow = node;
        Node fast = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = node;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}

class Node {
    Node next;
    int val;

    Node(int val) {
        this.val = val;
    }
}
