import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        // HashMap to store number and its index
        Map<Integer, Integer> map = new HashMap<>();

        // Loop through the array
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int complement = target - current;

            // Check if the complement already exists
            if (map.containsKey(complement)) {
                // Return the indices
                return new int[] { map.get(complement), i };
            }

            // Store the current number with its index
            map.put(current, i);
        }

        // This line will never be reached because exactly one solution exists
        return new int[] {};
    }
}
