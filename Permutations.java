import java.util.*;

/**
 * This class provides a solution to generate all possible permutations
 * of a given array of integers using the backtracking approach.
 */
class Solution {

    /**
     * Main function to generate permutations.
     *
     * @param nums The input array of integers.
     * @return A list containing all possible permutations of nums.
     */
    public List<List<Integer>> permute(int[] nums) {

        // This will store all the final permutations
        List<List<Integer>> result = new ArrayList<>();

        // Boolean array to track which elements are already used in the current permutation
        boolean[] used = new boolean[nums.length];

        // Start the backtracking process with an empty current permutation
        backtrack(nums, used, new ArrayList<>(), result);

        // Return all generated permutations
        return result;
    }

    /**
     * Backtracking helper function to build permutations.
     *
     * @param nums The original input array
     * @param used Boolean array indicating whether an element is already included
     * @param current The current permutation being constructed
     * @param result The final list storing all permutations
     */
    private void backtrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {

        // ========================
        // BASE CASE
        // ========================
        // If the current permutation size equals the input size,
        // we have formed a complete permutation
        if (current.size() == nums.length) {

            // Add a COPY of the current permutation to result
            // (Important: avoid reference issues)
            result.add(new ArrayList<>(current));

            // Stop further exploration for this branch
            return;
        }

        // ========================
        // CHOICE LOOP
        // ========================
        // Try every element in nums
        for (int i = 0; i < nums.length; i++) {

            // ------------------------
            // SKIP USED ELEMENTS
            // ------------------------
            // If this element is already included in the current permutation,
            // skip it to avoid duplicates in the same permutation
            if (used[i]) continue;

            // ------------------------
            // CHOOSE
            // ------------------------
            // Mark the element as used
            used[i] = true;

            // Add the element to the current permutation
            current.add(nums[i]);

            // ------------------------
            // EXPLORE
            // ------------------------
            // Recursively build the rest of the permutation
            backtrack(nums, used, current, result);

            // ------------------------
            // UN-CHOOSE (BACKTRACK)
            // ------------------------
            // Remove the last added element (undo the choice)
            current.remove(current.size() - 1);

            // Mark the element as unused so it can be reused in other branches
            used[i] = false;
        }
    }
}
