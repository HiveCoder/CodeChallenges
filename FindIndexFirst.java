class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        // If needle is longer, impossible to match
        if (m > n) return -1;

        for (int i = 0; i <= n - m; i++) {
            int j = 0;

            // Compare characters one by one
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            // If we matched the whole needle
            if (j == m) {
                return i;
            }
        }

        return -1;
    }
}
