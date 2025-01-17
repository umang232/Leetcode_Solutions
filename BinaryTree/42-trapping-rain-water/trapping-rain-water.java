class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 1 || n == 2) {
            return 0;
        }
        int water = 0;
        int leftmax = height[0];
        int rightmax = height[n - 1];
        int i = 1;
        int j = n - 2;
        while (i <= j) {
            if (leftmax <= rightmax) {
                if (height[i] >= leftmax) {
                    leftmax = height[i];
                } else {
                    if ((leftmax - height[i]) > 0) {
                        water += (leftmax - height[i]);
                    }
                }
                i++;
            } else {
                if (height[j] >= rightmax) {
                    rightmax = height[j];
                } else {
                    if ((rightmax - height[j]) > 0) {
                        water += (rightmax - height[j]);
                    }
                }
                j--;
            }
        }
        return water;
    }
}