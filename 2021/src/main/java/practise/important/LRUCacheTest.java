package practise.important;

public class LRUCacheTest {
    public static void main(String[] args) {
        LRUCache lruCache=new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(2,2);
        lruCache.get(2);
        lruCache.put(3,2);
        lruCache.get(2);
        lruCache.get(3);

    }
}
