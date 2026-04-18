import java.util.HashMap;
import java.util.Map;

class Solution {

    /**
     * Converts a Roman numeral string into its integer equivalent.
     *
     * Roman numerals follow specific rules:
     * - Symbols are usually added (e.g., VI = 5 + 1 = 6)
     * - If a smaller value appears before a larger one, it is subtracted
     *   (e.g., IV = 5 - 1 = 4, IX = 10 - 1 = 9)
     *
     * @param s The Roman numeral string (e.g., "XIV", "MCMXCIV")
     * @return The integer value of the Roman numeral
     */
    public int romanToInt(String s) {

        // Create a map to store Roman numeral characters and their integer values
        Map<Character, Integer> map = new HashMap<>();

        // Populate the map with standard Roman numeral values
        map.put('I', 1);     // 1
        map.put('V', 5);     // 5
        map.put('X', 10);    // 10
        map.put('L', 50);    // 50
        map.put('C', 100);   // 100
        map.put('D', 500);   // 500
        map.put('M', 1000);  // 1000

        // Variable to store the final computed integer value
        int total = 0;

        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {

            // Get the integer value of the current Roman numeral character
            int current = map.get(s.charAt(i));

            /*
             * Check if:
             * 1. There is a next character (i < length - 1)
             * 2. The current value is less than the next value
             *
             * If both conditions are true, this indicates a subtractive case:
             * Example: IV → I (1) comes before V (5), so we subtract 1
             */
            if (i < s.length() - 1 && current < map.get(s.charAt(i + 1))) {

                // Subtract the current value from total
                total -= current;

            } else {
                /*
                 * Otherwise, this is a normal additive case:
                 * Example: VI → V (5) + I (1)
                 */

                // Add the current value to total
                total += current;
            }
        }

        // Return the final computed integer value
        return total;
    }
}
