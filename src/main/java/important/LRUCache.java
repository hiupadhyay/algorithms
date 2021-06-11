package important;

import datastructure.DoublyLinkedList;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

    private DoublyLinkedList linkedList = new DoublyLinkedList();
    private Map<Integer, Integer> map;
    private int size;

    public LRUCache(int size) {
        this.size = size;
        this.map = new LinkedHashMap<>(this.size);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            linkedList.bringAhead(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (isFull()) {
            int lru = linkedList.removeLRU();
            map.remove(lru);
        }
        map.put(key, value);
        linkedList.add(key);
    }

    public boolean isFull() {
        return this.size == map.size();
    }

    public int capacity() {
        return map.size();
    }

    public void showCache() {
        System.out.println(map);
    }
}
