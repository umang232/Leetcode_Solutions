class MedianFinder {
    PriorityQueue<Integer> pqs;
    PriorityQueue<Integer> pql;

    public MedianFinder() {
        pqs = new PriorityQueue<>(Collections.reverseOrder());
        pql = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(pqs.size() <= pql.size()){
            if(pqs.size() == 0 || num <= pql.peek()){
                pqs.add(num);
            }else{
                pqs.add(pql.remove());
                pql.add(num);
            }
        }else{
            if(num >= pqs.peek()){
                pql.add(num);
            }else{
                pql.add(pqs.remove());
                pqs.add(num);
            }
        }
    }
    
    public double findMedian() {
        if(pqs.size() == pql.size()){
            int sum = pqs.peek()+pql.peek();
            return (double) sum / 2;
        }else if(pqs.size() > pql.size()){
            return pqs.peek();
        }else{
            return pql.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */