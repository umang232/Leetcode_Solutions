class Solution {
    public int trap(int[] height) {
        if(height.length == 1 || height.length == 2){
            return 0;
        }
        int water = 0;
        int leftmax = height[0];
        int rightmax = height[height.length-1];
        int i = 1;
        int j = height.length - 2;
        while(i<=j){
            if(leftmax <= rightmax){
                if(height[i] >= leftmax){
                    leftmax = height[i];
                }else{
                    water += (leftmax - height[i]);
                }
                i++;
            }else{
                if(height[j] >= rightmax){
                    rightmax = height[j];
                }else{
                    water += (rightmax-height[j]);
                }
                j--;
            }
        }
        return water;
    }
}