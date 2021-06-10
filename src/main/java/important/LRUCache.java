package important;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity);
    }

    public int get(int key) {
        return -1;
    }

    public void put(int key, int value) {

    }
}
