class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // avoids potential overflow

            if (nums[mid] == target) {
                return mid; // found the target
            } else if (nums[mid] < target) {
                left = mid + 1; // search in the right half
            } else {
                right = mid - 1; // search in the left half
            }
        }

        // If not found, left is the correct insertion index
        return left;
    }
}
