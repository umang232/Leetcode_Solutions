import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        
        for (int asteroid : asteroids) {
            boolean destroyed = false; // Track if the current asteroid is destroyed
            
            while (!st.isEmpty() && asteroid < 0 && st.peek() > 0) {
                if (st.peek() < -asteroid) {
                    st.pop(); // The positive asteroid is smaller, so it gets destroyed
                    continue; // Check the next one in the stack
                } else if (st.peek() == -asteroid) {
                    st.pop(); // Both asteroids destroy each other
                }
                destroyed = true; // Mark the asteroid as destroyed
                break;
            }

            if (!destroyed) {
                st.push(asteroid); // If the asteroid is not destroyed, push it
            }
        }

        // Convert stack to int[]
        int[] result = new int[st.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = st.pop();
        }
        
        return result;
    }
}
