class MedianFinder {
    PriorityQueue<Integer> pqSmall;
    PriorityQueue<Integer> pqLarge;

    public MedianFinder() {
        pqSmall = new PriorityQueue<>(Collections.reverseOrder());
        pqLarge = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(pqSmall.size() <= pqLarge.size()){
            if(pqSmall.isEmpty() || num <= pqLarge.peek()){
                pqSmall.add(num);
            }else{
                pqSmall.add(pqLarge.poll());
                pqLarge.add(num);
            }
        }else{
            if(num >= pqSmall.peek()){
                pqLarge.add(num);
            }else{
                pqLarge.add(pqSmall.poll());
                pqSmall.add(num);
            }
        }
    }
    
    public double findMedian() {
        if(pqSmall.size() > pqLarge.size()){
            return (double) pqSmall.peek();
        }else if(pqSmall.size() < pqLarge.size()){
            return (double) pqLarge.peek();
        }else{
            return (double)(pqSmall.peek()+pqLarge.peek())/2.0;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */