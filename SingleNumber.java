class Solution {
    //initialization of algo
    public int singleNumber(int[] nums) {
        
        // 'result' will store the XOR of all numbers in the array.
        // We start with 0 because:
        // 0 ^ x = x
        int result = 0;

        // Enhanced for-loop:
        // This goes through every number in the nums array, one at a time.
        //
        // Example:
        // nums = [4, 1, 2, 1, 2]
        //
        // num will be:
        // 4 → then 1 → then 2 → then 1 → then 2
        for (int num : nums) {
            
            // XOR the current number with result.
            //
            // The ^ operator is the XOR (exclusive OR) operator.
            //
            // Important XOR rules:
            //
            // 1. x ^ x = 0
            //    Example: 5 ^ 5 = 0
            //
            // 2. x ^ 0 = x
            //    Example: 5 ^ 0 = 5
            //
            // Because every number appears twice except one,
            // the duplicate numbers will cancel each other out.
            result ^= num;
        }

        // After processing the entire array,
        // result contains the number that appeared only once.
        return result;
    }
}
