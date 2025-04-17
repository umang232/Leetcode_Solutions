class LRUCache {
    Node head;
    Node tail;
    int capacity;
    Map<Integer, Node> cache;
    public LRUCache(int capacity) {
        head = new Node(0,0);
        tail = new Node(0,0);
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
        cache = new HashMap<>();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }
        Node current = cache.get(key);
        remove(current);
        insert(current);
        return current.value;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node exists = cache.get(key);
            exists.value = value;
            remove(exists);
            insert(exists);
        }else{
            if(cache.size() == capacity){
                Node last = tail.prev;
                remove(last);
                cache.remove(last.key);
            }
            Node newnode = new Node(key,value);
            insert(newnode);
            cache.put(key,newnode);
        }
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void insert(Node node){
        Node headnext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headnext;
        headnext.prev = node;
    }
}


class Node{
    int key, value;
    Node next;
    Node prev;

    Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */