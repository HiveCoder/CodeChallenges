import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int index, List<String> parts, List<String> result) {
        // If we already have 4 parts
        if (parts.size() == 4) {
            // If we've used all characters, it's valid
            if (index == s.length()) {
                result.add(String.join(".", parts));
            }
            return;
        }

        // Try 1 to 3 digit segments
        for (int len = 1; len <= 3; len++) {
            if (index + len > s.length()) break;

            String segment = s.substring(index, index + len);

            // Check for leading zeros
            if (segment.length() > 1 && segment.startsWith("0")) continue;

            // Check numeric range
            int value = Integer.parseInt(segment);
            if (value > 255) continue;

            // Choose
            parts.add(segment);

            // Explore
            backtrack(s, index + len, parts, result);

            // Undo choice (backtrack)
            parts.remove(parts.size() - 1);
        }
    }
}
