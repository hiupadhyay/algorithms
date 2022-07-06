package practise.linkedlists;

public class DetectCycle {

    public boolean isCyclePresent(LinkedList head) {
        LinkedList slow = head;
        LinkedList fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    public LinkedList nodeWhereCycleBegins(LinkedList head) {
        LinkedList slow = head;
        LinkedList fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                    if (slow == fast)
                        return fast;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedList head = new LinkedList(3);
        head.next = new LinkedList(2);
        head.next.next = new LinkedList(0);
        head.next.next.next = new LinkedList(-4);
        head.next.next.next.next = head.next;
        DetectCycle detectCycle = new DetectCycle();
        System.out.println(detectCycle.isCyclePresent(head));
        System.out.println(detectCycle.nodeWhereCycleBegins(head).val);
    }
}

class LinkedList {
    LinkedList next;
    int val;

    LinkedList(int val) {
        this.val = val;
    }
}


