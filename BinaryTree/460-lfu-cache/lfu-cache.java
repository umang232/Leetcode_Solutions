class LFUCache {
    private final int capacity;
    private int curSize;
    private int minFreq;
    private Map<Integer, DLLNode> cache;
    private Map<Integer, DoubleLinkedList> frequencyMap;

    public LFUCache(int capacity) {
        this.capacity =capacity;
        this.curSize = 0;
        this.minFreq = 0;
        cache = new HashMap<>();
        frequencyMap = new HashMap<>();
    }
    
    public int get(int key){
        if(!cache.containsKey(key)){
            return -1;
        }
        DLLNode node = cache.get(key);
        updateNode(node);
        return node.value;
    }
    public void put(int key, int value){
        if(capacity == 0){
            return;
        }
        if(cache.containsKey(key)){
            DLLNode node = cache.get(key);
            node.value = value;
            updateNode(node);
        }else{
            curSize++;
            if(curSize > capacity){
                DoubleLinkedList minfreqList = frequencyMap.get(minFreq);
                DLLNode rem = minfreqList.removeLast();
                cache.remove(rem.key);
                curSize--;
            }
            minFreq = 1;
            DLLNode nn = new DLLNode(key,value);
            DoubleLinkedList cur = frequencyMap.getOrDefault(1, new DoubleLinkedList());
            cur.addNode(nn);
            frequencyMap.put(1,cur);
            cache.put(key, nn);
        }
    }

    private void updateNode(DLLNode node){
        int freq = node.frequency;
        DoubleLinkedList list = frequencyMap.get(freq);
        list.removeNode(node);
        if(freq == minFreq && list.listSize == 0){
            minFreq++;
        }
        node.frequency++;
        DoubleLinkedList newList = frequencyMap.getOrDefault(node.frequency, new DoubleLinkedList());
        newList.addNode(node);
        frequencyMap.put(node.frequency, newList);
    }
}

class DoubleLinkedList {
    int listSize;
    DLLNode head;
    DLLNode tail;
    public DoubleLinkedList(){
        this.listSize = 0;
        head = new DLLNode(0,0);
        tail = new DLLNode(0,0);
        head.next = tail;
        tail.prev= head;
    }
    public void addNode(DLLNode node){
        DLLNode headnext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headnext;
        headnext.prev = node;
        listSize++;
    }
    public void removeNode(DLLNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        listSize--;
    }
    public DLLNode removeLast(){
        if(listSize > 0){
            DLLNode lastnode = tail.prev;
            removeNode(lastnode);
            return lastnode;
        }
        return null;
    }
}


class DLLNode {
    int key;
    int value;
    int frequency;
    DLLNode next;
    DLLNode prev;
    DLLNode(int key, int value){
        this.key = key;
        this.value = value;
        this.frequency = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */