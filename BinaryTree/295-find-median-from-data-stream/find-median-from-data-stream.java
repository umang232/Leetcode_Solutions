class MedianFinder {
    PriorityQueue<Integer> pqSmall;
    PriorityQueue<Integer> pqLarge;

    public MedianFinder() {
        pqSmall = new PriorityQueue<>(Collections.reverseOrder());
        pqLarge = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(pqSmall.size() <= pqLarge.size()){
            if(pqSmall.size() == 0 || num <= pqLarge.peek()){
                pqSmall.add(num);
            }else{
                pqSmall.add(pqLarge.remove());
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
        if(pqSmall.size() == pqLarge.size()){
            int sum = pqSmall.peek() + pqLarge.peek();
            return (double) sum/2;
        }else if(pqSmall.size() > pqLarge.size()){
            return pqSmall.peek();
        }else{
            return pqLarge.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */