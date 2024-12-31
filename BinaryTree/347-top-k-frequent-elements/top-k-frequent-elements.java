import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies using a HashMap
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create an array of lists to group numbers by frequency
        List<Integer>[] arr = new ArrayList[nums.length + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        // Populate the array of lists with numbers based on their frequency
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            arr[entry.getValue()].add(entry.getKey());
        }

        // Step 3: Extract the top K frequent elements
        int[] ans = new int[k];
        int index = 0;

        // Traverse from the highest frequency to the lowest
        for (int i = arr.length - 1; i >= 0 && index < k; i--) {
            for (int num : arr[i]) {
                ans[index++] = num;
                if (index == k) {
                    break; // Stop when we've collected k elements
                }
            }
        }

        return ans;
    }
}
