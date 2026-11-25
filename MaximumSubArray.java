/** LeetCode Amazon Test **/

/**
Sub Array Example: [-2,1,-3,4,-1,2,1,-5,1]
Time Complexity: O(n) - iterates through the array exactly once.
Space Complexity: O(1) - Uses only two additional variables, regardless of input size
**/

class Solution {
    /**
     * Finds the maximum sum of a contiguous subarray.
     *
     * @param nums Input integer array
     * @return Maximum subarray sum
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int maxSubArray(int[] nums) {
        int maxSub = nums[0];
        int curSum = 0;

        for (int i = 0; i < nums.length; i++) {
            // Reset current sum if it becomes negative
            if (curSum < 0) {
                curSum = 0;
            }

            // Add current element to the running sum
            curSum += nums[i];

            // Update maximum subarray sum
            maxSub = Math.max(maxSub, curSum);
        }

        return maxSub;
    }
}
