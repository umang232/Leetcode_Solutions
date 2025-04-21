class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";

        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        // If k > 0, remove from end
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // Build final number
        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);

        // Remove leading zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
