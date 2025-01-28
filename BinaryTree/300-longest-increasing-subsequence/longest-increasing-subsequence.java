class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
Arrays.fill(dp, 1);  // Initialize dp with 1 because each element is its own subsequence
int max = 1;

for (int i = nums.length - 2; i >= 0; i--) {
    for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] < nums[j]) {
            dp[i] = Math.max(dp[i], dp[j] + 1);  // Update dp[i] for increasing subsequence
        }
    }
    max = Math.max(max, dp[i]);  // Update the overall max
}

return max;
    }
}