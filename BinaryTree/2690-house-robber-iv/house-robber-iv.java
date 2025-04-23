public class Solution {
    public int minCapability(int[] nums, int k) {
        int low = 0, high = 0;
        for (int num : nums) {
            high = Math.max(high, num);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canRob(nums, k, mid)) {
                high = mid; // try to minimize max value
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canRob(int[] nums, int k, int cap) {
        int count = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] <= cap) {
                count++;
                i += 2; // skip adjacent house
            } else {
                i++;
            }
        }
        return count >= k;
    }
}
