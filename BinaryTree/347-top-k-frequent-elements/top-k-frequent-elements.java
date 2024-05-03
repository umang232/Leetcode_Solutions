class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int[] arr = new int[k];
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(
            (a,b) -> b.getValue().compareTo(a.getValue())
        );
        pq.addAll(hm.entrySet());
        int l = 0;
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            arr[l] = pq.poll().getKey();
            l++;
        }
        return arr;

    }
}