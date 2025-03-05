import java.util.*;

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        List<int[]> events = new ArrayList<>();

        // Create events for pickup and drop-off
        for (int[] trip : trips) {
            events.add(new int[]{trip[1], trip[0]}); // Pickup: (location, passengers)
            events.add(new int[]{trip[2], -trip[0]}); // Drop-off: (location, -passengers)
        }

        // Sort events: First by location, then by passengers (drop-off first if same location)
        Collections.sort(events, (a, b) -> (a[0] == b[0]) ? (a[1] - b[1]) : (a[0] - b[0]));

        int currentCapacity = 0;
        for (int[] event : events) {
            currentCapacity += event[1]; // Update capacity

            if (currentCapacity > capacity) {
                return false; // Overloaded at some point
            }
        }

        return true; // Successfully handled all trips
    }
}
