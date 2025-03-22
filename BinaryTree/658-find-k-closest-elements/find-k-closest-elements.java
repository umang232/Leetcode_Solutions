class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = 0;
        List<Integer> result = new ArrayList<>();
        while(right < k){
            result.add(arr[right]);
            right++;
        }
        for(int i = right;i<arr.length;i++){
            if(Math.abs(arr[i] - x) < Math.abs(result.get(0) - x)){
                result.remove(result.get(0));
                result.add(arr[i]);
                left++;
            }
        }
        return result;
    }
}