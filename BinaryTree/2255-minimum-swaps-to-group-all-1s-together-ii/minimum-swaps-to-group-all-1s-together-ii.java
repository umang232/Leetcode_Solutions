class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        // Step 1: Count total number of 1s
        int totalOnes = 0;
        for (int num : nums) {
            if (num == 1) totalOnes++;
        }

        if (totalOnes == 0 || totalOnes == n) return 0;

        // Step 2: Use sliding window of size `totalOnes` on duplicated array
        int maxOnesInWindow = 0;
        int currentOnes = 0;

        for (int i = 0; i < 2 * n; i++) {
            if (i >= totalOnes) {
                if (nums[(i - totalOnes) % n] == 1) currentOnes--;
            }

            if (nums[i % n] == 1) currentOnes++;

            if (i >= totalOnes - 1) {
                maxOnesInWindow = Math.max(maxOnesInWindow, currentOnes);
            }
        }

        // Step 3: Minimum swaps = totalOnes - maxOnesInWindow
        return totalOnes - maxOnesInWindow;
    }
}
