class Solution {
    public boolean isPalindrome(int x) {

        // A palindrome reads the same forward and backward.
        // First, handle edge cases:

        // 1. Negative numbers are NOT palindromes because of the '-' sign.
        //    Example: -121 != 121-
        // 2. Any number ending in 0 (except 0 itself) cannot be a palindrome.
        //    Example: 10 -> reversed is 01 (not equal to 10)
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        // This variable will store the reversed second half of the number.
        int reversedHalf = 0;

        // Reverse ONLY half of the number to optimize performance
        // and avoid integer overflow.
        //
        // Example:
        // x = 1221
        // Iteration 1: reversedHalf = 1, x = 122
        // Iteration 2: reversedHalf = 12, x = 12 (stop here)
        //
        // We stop when reversedHalf >= x, meaning we've processed half.
        while (x > reversedHalf) {
            // Extract the last digit of x (x % 10)
            // Add it to reversedHalf after shifting its digits left (*10)
            reversedHalf = reversedHalf * 10 + x % 10;

            // Remove the last digit from x
            x /= 10;
        }

        // After the loop, we compare the two halves:
        //
        // Case 1: EVEN number of digits
        // Example: 1221
        // x = 12, reversedHalf = 12 → palindrome
        //
        // Case 2: ODD number of digits
        // Example: 12321
        // x = 12, reversedHalf = 123
        // We remove the middle digit by reversedHalf / 10 → 12
        //
        // If either condition matches, it's a palindrome.
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
