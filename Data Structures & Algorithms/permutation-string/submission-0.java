class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // Fill frequency of s1 and first window of s2
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        int matches = 0;

        // Count how many characters have equal frequencies
        for (int i = 0; i < 26; i++) {
            if (s1Count[i] == s2Count[i]) {
                matches++;
            }
        }

        int left = 0;

        // Slide the window
        for (int right = s1.length(); right < s2.length(); right++) {

            if (matches == 26) {
                return true;
            }

            // Add new character
            int index = s2.charAt(right) - 'a';
            s2Count[index]++;

            if (s2Count[index] == s1Count[index]) {
                matches++;
            } else if (s2Count[index] == s1Count[index] + 1) {
                matches--;
            }

            // Remove left character
            index = s2.charAt(left) - 'a';
            s2Count[index]--;

            if (s2Count[index] == s1Count[index]) {
                matches++;
            } else if (s2Count[index] == s1Count[index] - 1) {
                matches--;
            }

            left++;
        }

        return matches == 26;
    }
}