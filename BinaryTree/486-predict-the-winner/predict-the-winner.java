class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        Integer[][] memo = new Integer[n][n];
        return getScore(nums, 0, n - 1, memo) >= 0;
    }

    private int getScore(int[] nums, int left, int right, Integer[][] memo) {
        if (left == right) return nums[left];
        if (memo[left][right] != null) return memo[left][right];

        int pickLeft = nums[left] - getScore(nums, left + 1, right, memo);
        int pickRight = nums[right] - getScore(nums, left, right - 1, memo);

        return memo[left][right] = Math.max(pickLeft, pickRight);
    }
}
