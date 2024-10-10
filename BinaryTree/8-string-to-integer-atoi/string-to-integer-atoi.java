class Solution {
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;  // Handle empty or null strings
        }

        s = s.trim();  // Trim leading/trailing spaces
        if (s.isEmpty()) {
            return 0;  // If after trimming, string is empty, return 0
        }

        boolean positive = true;
        int index = 0;

        // Check if the first character is a sign
        if (s.charAt(0) == '-') {
            positive = false;
            index++;
        } else if (s.charAt(0) == '+') {
            index++;
        }

        long result = 0;  // Use long to handle overflow
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            result = result * 10 + (s.charAt(index) - '0');  // Convert char to digit

            // Check for overflow beyond Integer limits
            if (positive && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (!positive && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            index++;
        }

        return positive ? (int) result : (int) -result;
    }
}
