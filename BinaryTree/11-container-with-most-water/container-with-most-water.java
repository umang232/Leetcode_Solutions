class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left =0;
        int right = height.length-1;
        while(left < right){
            int tempArea;
            if(height[left] < height[right]){
                tempArea = height[left] * (right-left);
                left++;
            }else{
                tempArea = height[right] * (right-left);
                right--;
            }
            maxArea = Math.max(tempArea,maxArea);
        }
        return maxArea;
    }
}