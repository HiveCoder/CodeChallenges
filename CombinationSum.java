import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] candidates, int target, int start, 
                           List<Integer> current, List<List<Integer>> result) {
        
        // Base case: target reached
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // Explore choices
        for (int i = start; i < candidates.length; i++) {
            // Skip if number exceeds remaining target
            if (candidates[i] > target) continue;
            
            // Choose
            current.add(candidates[i]);
            
            // Stay at i (not i+1) because we can reuse same number
            backtrack(candidates, target - candidates[i], i, current, result);
            
            // Undo (backtrack)
            current.remove(current.size() - 1);
        }
    }
}
