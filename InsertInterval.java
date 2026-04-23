import java.util.*;

/**
 * This class provides a solution for inserting a new interval into a list of
 * non-overlapping, sorted intervals and merging if necessary.
 */
class Solution {

    /**
     * Inserts a new interval into an existing list of intervals.
     *
     * @param intervals A 2D array of intervals where each interval is represented
     *                  as [start, end]. The intervals are sorted by start time
     *                  and do not overlap.
     * @param newInterval A single interval [start, end] to be inserted.
     * @return A new 2D array of merged intervals after inserting newInterval.
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {

        // List to store the final result after insertion and merging
        List<int[]> result = new ArrayList<>();

        // Pointer to iterate through the intervals array
        int i = 0;

        // Total number of intervals
        int n = intervals.length;

        /**
         * STEP 1: Add all intervals that come BEFORE the new interval.
         *
         * Condition:
         * If the current interval's end is less than the start of newInterval,
         * it means there is NO overlap and it comes completely before.
         *
         * Example:
         * intervals[i] = [1, 2], newInterval = [5, 7]
         * Since 2 < 5 → no overlap → safe to add directly.
         */
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]); // Add non-overlapping interval
            i++; // Move to the next interval
        }

        /**
         * STEP 2: Merge all overlapping intervals with newInterval.
         *
         * Condition:
         * If the current interval's start is <= newInterval's end,
         * they overlap and need to be merged.
         *
         * Merging logic:
         * - Update start to the minimum of both starts
         * - Update end to the maximum of both ends
         *
         * Example:
         * intervals[i] = [3, 6], newInterval = [5, 8]
         * Overlap → merged interval = [3, 8]
         */
        while (i < n && intervals[i][0] <= newInterval[1]) {

            // Update the start of newInterval to the smallest start value
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);

            // Update the end of newInterval to the largest end value
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);

            i++; // Move to the next interval
        }

        // Add the merged interval (or original newInterval if no overlap occurred)
        result.add(newInterval);

        /**
         * STEP 3: Add all remaining intervals AFTER the new interval.
         *
         * At this point, all overlapping intervals have already been merged.
         * The rest of the intervals come after and do not overlap.
         */
        while (i < n) {
            result.add(intervals[i]); // Add remaining intervals
            i++; // Move to next
        }

        /**
         * Convert the result list to a 2D array.
         *
         * result.toArray(new int[result.size()][]) creates a properly sized
         * 2D array and copies all elements from the list into it.
         */
        return result.toArray(new int[result.size()][]);
    }
}
