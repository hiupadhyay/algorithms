package practise.askedincompanies;

import java.util.HashMap;
import java.util.Map;


public class LRUCache {
    private DoublyLinkedlist list;
    private Map<Integer, Node> map;
    private int cap;

    public LRUCache(int capacity) {
        list = new DoublyLinkedlist();
        map = new HashMap<>(capacity);
        cap = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            list.moveToHead(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            list.moveToHead(node);
            node.val = value;
        } else {
            node = new Node(key, value);
            if (isFull()) {
                Node tail = list.getLRU();
                map.remove(tail.key);
                list.removeLRU();
            }
            map.put(key, node);
            list.addToHead(node);
        }
    }

    private boolean isFull() {
        return map.size() == cap;
    }

}

class DoublyLinkedlist {
    private Node head;
    private Node tail;

    DoublyLinkedlist() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    void moveToHead(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        addToHead(node);
    }

    void addToHead(Node node) {
        Node tmp = head.next;
        head.next = node;
        node.next = tmp;
        node.prev = head;
        tmp.prev = node;
    }

    void removeLRU() {
        Node newTail = tail.prev.prev;
        newTail.next = tail;
        tail.prev = newTail;
    }

    Node getLRU() {
        return tail.prev;
    }

}

class Node {
    int key;
    int val;
    Node next;
    Node prev;

    Node(int key, int value) {
        this.key = key;
        this.val = value;
    }
}

