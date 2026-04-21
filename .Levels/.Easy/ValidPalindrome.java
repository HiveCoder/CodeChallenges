class Solution {
    public boolean isPalindrome(String s) {
        // Initialize two pointers
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            // Skip non-alphanumeric characters on the left
            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
                continue;
            }

            // Skip non-alphanumeric characters on the right
            if (!Character.isLetterOrDigit(rightChar)) {
                right--;
                continue;
            }

            // Compare characters (case-insensitive)
            if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                return false;
            }

            // Move both pointers inward
            left++;
            right--;
        }

        return true;
    }
}
