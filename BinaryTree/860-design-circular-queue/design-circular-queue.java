class MyCircularQueue {
    public class Node{
        int value;
        Node next;  
        Node(int value){
            this.value = value;
        }
    }
    private int count;
    private int current_count;
    Node queue;
    Node rear;
    Node front;
    public MyCircularQueue(int k) {
        count = k;
        current_count = 0;
    }
    
    public boolean enQueue(int value) {
        if(current_count < count){
            Node new_node = new Node(value);
            if(current_count == 0){
                queue = new_node;
                queue.next = queue;
                front = queue;
                rear = queue;
            }else{
                rear.next = new_node;
                new_node.next = front;
                rear = rear.next;
            }
            current_count++;
            return true;
        }else{
            return false;
        }
    }
    
    public boolean deQueue() {
        if(current_count == 0){
            return false;
        }else{
            if(current_count == 1){
                front.next = null;
                front = front.next;
            }else{
                front = front.next;
                rear.next = front;
            }
            current_count --;
            return true;
        }
    }
    
    public int Front() {
        return current_count > 0 ? front.value : -1;
    }
    
    public int Rear() {
        return current_count > 0 ? rear.value : -1;
    }
    
    public boolean isEmpty() {
        return current_count == 0;
    }
    
    public boolean isFull() {
        return current_count == count;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */