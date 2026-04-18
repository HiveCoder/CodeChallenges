import java.util.*;
//class 
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Iterate through each number
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for the first number
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            // Step 3: Two-pointer approach
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for the second number
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicates for the third number
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Need a larger number
                } else {
                    right--; // Need a smaller number
                }
            }
        }

        return result;
    }

    // Test the solution
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {-1,0,1,2,-1,-4};
        System.out.println(sol.threeSum(nums1)); // [[-1, -1, 2], [-1, 0, 1]]

        int[] nums2 = {0,1,1};
        System.out.println(sol.threeSum(nums2)); // []

        int[] nums3 = {0,0,0};
        System.out.println(sol.threeSum(nums3)); // [[0,0,0]]
    }
}
