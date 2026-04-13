class Solution {

    /**
     * Adds two binary strings and returns their sum as a binary string.
     *
     * <p><b>Concept:</b>
     * This method simulates manual binary addition:
     * - Start from the rightmost digits (least significant bits)
     * - Add corresponding digits along with a carry
     * - Store the result and update the carry
     * - Reverse the final result since we build it backwards
     *
     * <p><b>Example:</b>
     * Input: a = "1010", b = "1011"
     * Output: "10101"
     *
     * <p><b>Time Complexity:</b> O(max(n, m))
     * <br>We traverse both strings once.
     *
     * <p><b>Space Complexity:</b> O(max(n, m))
     * <br>We store the result in a StringBuilder.
     *
     * @param a First binary string
     * @param b Second binary string
     * @return Binary sum of a and b
     */
    public String addBinary(String a, String b) {

        // StringBuilder is used for efficient string manipulation
        // (better than using String concatenation in a loop)
        StringBuilder result = new StringBuilder();

        // Pointers starting from the end of each string
        // (rightmost side = least significant bit)
        int i = a.length() - 1;
        int j = b.length() - 1;

        // Carry stores the overflow when sum exceeds 1 (in binary)
        int carry = 0;

        /**
         * Loop continues while:
         * - There are still digits left in string 'a'
         * - OR there are digits left in string 'b'
         * - OR there is a remaining carry
         */
        while (i >= 0 || j >= 0 || carry != 0) {

            // Start sum with the carry from previous step
            int sum = carry;

            // If there are still digits in 'a', add current digit to sum
            if (i >= 0) {
                // Convert char ('0' or '1') to integer (0 or 1)
                sum += a.charAt(i) - '0';
                i--; // Move to next digit (left)
            }

            // If there are still digits in 'b', add current digit to sum
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--; // Move to next digit (left)
            }

            /**
             * In binary:
             * sum can be 0, 1, 2, or 3
             *
             * sum % 2 → gives the current bit (0 or 1)
             * sum / 2 → gives the carry (0 or 1)
             */
            
            // Append the current binary digit to result
            result.append(sum % 2);

            // Update carry for next iteration
            carry = sum / 2;
        }

        /**
         * The result is built in reverse order
         * (from least significant bit to most significant bit),
         * so we reverse it before returning.
         */
        return result.reverse().toString();
    }
}
