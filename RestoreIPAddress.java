import java.util.*;

/**
 * Solution class to restore all possible valid IP address combinations
 * from a given string of digits.
 *
 * An IP address consists of exactly 4 segments separated by dots,
 * where each segment:
 *  - is between 0 and 255
 *  - cannot have leading zeros (except "0" itself)
 *
 * Example:
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 */
class Solution {

    /**
     * Main function that initializes the backtracking process.
     *
     * @param s Input string containing only digits
     * @return List of all valid IP addresses that can be formed
     */
    public List<String> restoreIpAddresses(String s) {
        // This list will store all valid IP addresses
        List<String> result = new ArrayList<>();

        // Start backtracking from index 0 with no parts formed yet
        backtrack(s, 0, new ArrayList<>(), result);

        return result;
    }

    /**
     * Recursive backtracking helper function.
     *
     * @param s       The original input string
     * @param index   Current index in the string being processed
     * @param parts   List of current segments (parts of IP address)
     * @param result  List to store valid IP addresses
     */
    private void backtrack(String s, int index, List<String> parts, List<String> result) {

        // BASE CASE:
        // If we already have 4 segments (parts of an IP address)
        if (parts.size() == 4) {

            // Check if we have used all characters in the string
            // If yes, this is a valid IP address
            if (index == s.length()) {
                // Join the 4 segments with '.' and add to result
                result.add(String.join(".", parts));
            }

            // Either way, stop further recursion
            return;
        }

        /**
         * TRY ALL POSSIBLE SEGMENTS:
         * Each segment can have length 1 to 3 digits
         */
        for (int len = 1; len <= 3; len++) {

            // If the substring goes beyond the string length, stop
            if (index + len > s.length()) break;

            // Extract substring of length 'len'
            String segment = s.substring(index, index + len);

            /**
             * VALIDATION 1: Leading Zero Check
             * - "0" is valid
             * - "01", "00", etc. are NOT valid
             */
            if (segment.length() > 1 && segment.startsWith("0")) continue;

            /**
             * VALIDATION 2: Range Check
             * Convert segment to integer and ensure it is <= 255
             */
            int value = Integer.parseInt(segment);
            if (value > 255) continue;

            /**
             * CHOOSE:
             * Add current segment to parts
             */
            parts.add(segment);

            /**
             * EXPLORE:
             * Recurse with updated index
             */
            backtrack(s, index + len, parts, result);

            /**
             * UNDO (Backtrack):
             * Remove the last added segment to try another possibility
             */
            parts.remove(parts.size() - 1);
        }
    }
}
