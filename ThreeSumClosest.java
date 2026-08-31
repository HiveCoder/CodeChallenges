```java
import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {

        /*
         * STEP 1: Sort the array
         *
         * Why?
         * Sorting allows us to use the "Two Pointer" technique.
         *
         * Example:
         * nums = [-1, 2, 1, -4]
         *
         * After sorting:
         * nums = [-4, -1, 1, 2]
         *
         * Because the numbers are sorted:
         * - Moving 'left' to the right gives us a BIGGER number.
         * - Moving 'right' to the left gives us a SMALLER number.
         *
         * This allows us to intelligently move our pointers
         * instead of checking every possible combination.
         */
        Arrays.sort(nums);


        /*
         * STEP 2: Create a variable to store our best answer.
         *
         * We need to find the sum of 3 numbers that is
         * CLOSEST to the target.
         *
         * We start by assuming that the first 3 numbers
         * give us the closest answer.
         *
         * Example:
         *
         * nums = [-4, -1, 1, 2]
         * target = 1
         *
         * closest = -4 + (-1) + 1
         *         = -4
         *
         * It doesn't necessarily mean -4 is actually the
         * closest answer. We will improve it as we search.
         */
        int closest = nums[0] + nums[1] + nums[2];


        /*
         * STEP 3: Choose the FIRST number.
         *
         * We use 'i' to point at the first number.
         *
         * Example:
         *
         * i
         * ↓
         * [-4, -1, 1, 2]
         *
         * We stop at nums.length - 2 because we need
         * TWO MORE numbers after nums[i].
         *
         * For example, if i is the second-last number,
         * there wouldn't be enough numbers left to choose 3.
         */
        for (int i = 0; i < nums.length - 2; i++) {


            /*
             * STEP 4: Create two pointers.
             *
             * 'left' starts immediately AFTER i.
             *
             * 'right' starts at the LAST number in the array.
             *
             * Example:
             *
             * i     left           right
             * ↓      ↓               ↓
             * [-4,  -1,      1,      2]
             *
             * We now have 3 numbers:
             *
             * nums[i]
             * nums[left]
             * nums[right]
             *
             * These are the 3 numbers whose sum we will check.
             */
            int left = i + 1;
            int right = nums.length - 1;


            /*
             * STEP 5: Keep searching while left and right
             * haven't crossed each other.
             *
             * Once:
             *
             * left >= right
             *
             * there are no more pairs to check for this
             * particular value of i.
             */
            while (left < right) {


                /*
                 * STEP 6: Calculate the sum of our 3 numbers.
                 *
                 * Example:
                 *
                 * nums[i]     = -1
                 * nums[left]  = 1
                 * nums[right] = 2
                 *
                 * sum = -1 + 1 + 2
                 *     = 2
                 */
                int sum = nums[i] + nums[left] + nums[right];


                /*
                 * STEP 7: Check whether this sum is closer
                 * to the target than our previous 'closest' sum.
                 *
                 * We use Math.abs() because we only care about
                 * the DISTANCE from the target.
                 *
                 * Example:
                 *
                 * target = 10
                 *
                 * closest = 7
                 * distance = |7 - 10| = 3
                 *
                 * sum = 12
                 * distance = |12 - 10| = 2
                 *
                 * Since 2 < 3, 12 is closer.
                 *
                 * Therefore:
                 *
                 * closest = 12
                 */
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }


                /*
                 * STEP 8: Check if we found the PERFECT answer.
                 *
                 * If:
                 *
                 * sum == target
                 *
                 * then the difference is:
                 *
                 * |sum - target| = 0
                 *
                 * It is impossible to get closer than 0.
                 *
                 * Therefore, we can immediately return the answer.
                 */
                if (sum == target) {
                    return sum;
                }


                /*
                 * STEP 9: Decide which pointer to move.
                 *
                 * This is the MOST IMPORTANT part of the algorithm.
                 *
                 * Remember:
                 *
                 * The array is sorted.
                 *
                 * Example:
                 *
                 * [-4, -1, 1, 2, 5, 8]
                 *
                 * If we move LEFT to the right:
                 *
                 * -1 → 1 → 2 → 5
                 *
                 * the number gets BIGGER.
                 *
                 * If we move RIGHT to the left:
                 *
                 * 8 → 5 → 2 → 1
                 *
                 * the number gets SMALLER.
                 */


                /*
                 * CASE 1:
                 *
                 * Our sum is TOO SMALL.
                 *
                 * Example:
                 *
                 * target = 10
                 * sum = 6
                 *
                 * We need to make the sum BIGGER.
                 *
                 * Since the array is sorted, we move 'left'
                 * to the right.
                 *
                 * left++;
                 *
                 * This gives us a larger number.
                 */
                if (sum < target) {
                    left++;
                }


                /*
                 * CASE 2:
                 *
                 * Our sum is TOO BIG.
                 *
                 * Example:
                 *
                 * target = 10
                 * sum = 14
                 *
                 * We need to make the sum SMALLER.
                 *
                 * Since the array is sorted, we move 'right'
                 * to the left.
                 *
                 * right--;
                 */
                else {
                    right--;
                }
            }
        }


        /*
         * STEP 10: Return the closest sum.
         *
         * If we didn't find an exact match,
         * 'closest' contains the sum that was
         * closest to the target.
         *
         * Example:
         *
         * target = 1
         * closest = 2
         *
         * return 2;
         */
        return closest;
    }
}
```
