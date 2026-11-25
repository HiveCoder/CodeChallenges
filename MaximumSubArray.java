/** LeetCode Amazon Test **/

/**
Sub Array Example: [-2,1,-3,4,-1,2,1,-5,1]
**/

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSub = nums[0];
        int curSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (curSum < 0) {
                curSum = 0;
            }

            curSum += nums[i];
            maxSub = Math.max(maxSub, curSum);
        }

        return maxSub;
    }
}
