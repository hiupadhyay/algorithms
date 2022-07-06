package practise.easy;

public class PallindromeList {

    public boolean isPalindrome(ListNode head, ListNode headCopy) {
        ListNode front = headCopy;
        ListNode back = rev(head);
        while (front != null && back != null) {
            if (front.val != back.val)
                return false;
            front = front.next;
            back = back.next;
        }

        return true;
    }

    public ListNode rev(ListNode curr) {
        ListNode prev = null;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1, null);


        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1, null);
        PallindromeList list = new PallindromeList();
        System.out.println(list.isPalindrome(node,head));

    }
}


class ListNode {
    ListNode next;
    int val;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(ListNode next) {
        this.next = next;
    }
}