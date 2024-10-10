class Solution {
    public int beautySum(String s) {
        int sum = 0;
        
        int left = 0;
        int right = 0;
        for(int i =0 ;i<s.length();i++){
            int arr[] = new int[26];
            arr[s.charAt(i)-'a']++;
            for(int j = i+1;j<s.length();j++){
                arr[s.charAt(j)-'a']++;
                int max = maxFreq(arr);
                int min = minFreq(arr);
                if(min != 0){
                    sum += (max-min);
                }
                
            }
        }
        return sum;
    }
    private int maxFreq(int arr[]){
        int max = 0;
        for(int i=0;i<arr.length;i++){
            max = Math.max(max,arr[i]);
        }
        return max;
    }
    private int minFreq(int arr[]){
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                min = Math.min(min,arr[i]);
            }
            
        }
        return min;
    }
}