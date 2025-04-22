class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxQueue = new ArrayDeque<>();
        Deque<Integer> minQueue = new ArrayDeque<>();
        int left = 0, result = 0;

        for (int right = 0; right < nums.length; right++) {
            while (!maxQueue.isEmpty() && nums[maxQueue.peekLast()] <= nums[right]) {
                maxQueue.pollLast();
            }
            maxQueue.addLast(right);

            while (!minQueue.isEmpty() && nums[minQueue.peekLast()] >= nums[right]) {
                minQueue.pollLast();
            }
            minQueue.addLast(right);

            // If condition breaks, shrink the window
            while (nums[maxQueue.peekFirst()] - nums[minQueue.peekFirst()] > limit) {
                if (maxQueue.peekFirst() == left) maxQueue.pollFirst();
                if (minQueue.peekFirst() == left) minQueue.pollFirst();
                left++;
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
