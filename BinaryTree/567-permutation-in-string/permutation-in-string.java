import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] sone1 = new int[26];
        int[] sone2 = new int[26];

        // Populate the frequency array for s1
        for (int i = 0; i < s1.length(); i++) {
            sone1[s1.charAt(i) - 'a']++;
        }

        // Populate the initial window in s2
        for (int i = 0; i < s1.length(); i++) {
            sone2[s2.charAt(i) - 'a']++;
        }

        // Check the initial window
        if (Arrays.equals(sone1, sone2)) {
            return true;
        }

        // Slide the window across s2
        for (int j = s1.length(); j < s2.length(); j++) {
            sone2[s2.charAt(j) - 'a']++; // Add the new character to the window
            sone2[s2.charAt(j - s1.length()) - 'a']--; // Remove the old character from the window

            if (Arrays.equals(sone1, sone2)) {
                return true;
            }
        }

        return false;
    }
}
