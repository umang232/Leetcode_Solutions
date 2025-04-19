class Solution {
    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> evenFreq = new HashMap<>();
        Map<Integer, Integer> oddFreq = new HashMap<>();

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (i % 2 == 0) {
                evenFreq.put(num, evenFreq.getOrDefault(num, 0) + 1);
            } else {
                oddFreq.put(num, oddFreq.getOrDefault(num, 0) + 1);
            }
        }
        int[][] evenTop2 = getTopTwo(evenFreq);
        int[][] oddTop2 = getTopTwo(oddFreq);

        if(evenTop2[0][0]!=oddTop2[0][0]){
            return n - evenTop2[0][1] - oddTop2[0][1];
        }else{
            int c1 = n - evenTop2[0][1] - oddTop2[1][1];
            int c2 = n - evenTop2[1][1] - oddTop2[0][1];
            return Math.min(c1,c2);
        }
        
    }

    public int [][] getTopTwo(Map<Integer,Integer> map){
        int[][]top = new int[][] {{-1,0}, {-1,0}};
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            if(value > top[0][1]){
                top[1] = top[0];
                top[0] = new int[]{key,value};
            }else if(value > top[1][1]){
                top[1] = new int[] {key,value};
            }
        }
        return top;
    }
}