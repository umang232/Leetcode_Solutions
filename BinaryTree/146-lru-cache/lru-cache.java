import java.util.*;

class LRUCache {
    private final int capacity;
    private final HashMap<Integer, Integer> map;
    private final Deque<Integer> deque;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.deque = new ArrayDeque<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // Move the accessed key to the front of the deque
        deque.remove(key);
        deque.addFirst(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Update the value and move the key to the front
            map.put(key, value);
            deque.remove(key);
            deque.addFirst(key);
        } else {
            // If the key is new and the cache is at capacity, remove the LRU element
            if (deque.size() == capacity) {
                int lruKey = deque.removeLast();
                map.remove(lruKey);
            }
            // Add the new key-value pair
            map.put(key, value);
            deque.addFirst(key);
        }
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */