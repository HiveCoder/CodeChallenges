import java.util.*;

/**
 * This class solves the "Combination Sum" problem using backtracking.
 * 
 * Problem:
 * Given an array of distinct integers (candidates) and a target number,
 * find all unique combinations where the chosen numbers add up to the target.
 * 
 * Rules:
 * - You can use the same number multiple times.
 * - The order of numbers does NOT matter (e.g., [2,3] is same as [3,2]).
 */
class Solution {

    /**
     * Main function that starts the backtracking process.
     * 
     * @param candidates Array of positive integers
     * @param target The number we want to reach
     * @return A list of all possible combinations that sum up to target
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        // Stores all valid combinations
        List<List<Integer>> result = new ArrayList<>();
        
        // Start backtracking
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        
        return result;
    }
    
    /**
     * Recursive helper function that builds combinations step by step.
     * 
     * @param candidates Available numbers
     * @param target Remaining value we need to reach
     * @param start Index to control where to start (prevents duplicates)
     * @param current Current combination being built
     * @param result Final list of all valid combinations
     */
    private void backtrack(int[] candidates, int target, int start, 
                           List<Integer> current, List<List<Integer>> result) {
        
        /**
         * BASE CASE:
         * If target becomes 0, it means the current combination adds up correctly.
         * We save a copy of it to the result list.
         */
        if (target == 0) {
            result.add(new ArrayList<>(current)); // store a copy
            return;
        }
        
        /**
         * LOOP THROUGH CHOICES:
         * Try every number starting from "start"
         */
        for (int i = start; i < candidates.length; i++) {
            
            /**
             * SKIP INVALID CASE:
             * If the number is greater than remaining target,
             * it cannot be used.
             */
            if (candidates[i] > target) continue;
            
            /**
             * CHOOSE:
             * Add the number to the current combination
             */
            current.add(candidates[i]);
            
            /**
             * EXPLORE:
             * Recursively try to build the rest of the combination
             * 
             * NOTE:
             * We pass "i" again (not i+1) because we are allowed
             * to reuse the same number multiple times.
             */
            backtrack(candidates, target - candidates[i], i, current, result);
            
            /**
             * BACKTRACK (UNDO):
             * Remove the last added number so we can try a different path
             */
            current.remove(current.size() - 1);
        }
    }
}
