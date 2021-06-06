package medium;

public class RotateList {

    public static void main(String[] args) {
        RotateList rotateList = new RotateList();
        ListNode head = rotateList.buildList();
        rotateList.print(head);
        ListNode newHead=rotateList.rotateRight(head, 2);
        rotateList.print(newHead);
    }

    private ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0)
            return head;
        ListNode temp = head;
        //move the temp node to the end of list and calcuate the length...
        int len = 1;
        while (temp.next != null) {
            temp = temp.next;
            len++;
        }
        //when i am here it means i am at the very last element  like 5 ->  null
        //lets join last with head.
        temp.next = head;
        //now the list will look like this..
        // 1 -> 2 -> 3 -> 4 -> 5 ->  1 ->2 -> 3-> 4
        k = k % len;
        for (int i = 0; i < len - k; i++) {
            temp = temp.next;
        }
        //3, head will start from 4
        head = temp.next;
        temp.next = null;
        return head;
    }

    private void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println(" null");
        System.out.println();
    }

    private ListNode buildList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
