
import java.util.Arrays;

class Solution {

    /**
     * Calculates the number of unique paths from the top-left corner
     * to the bottom-right corner of a grid while avoiding obstacles.
     *
     * The robot can only move right or down.
     * A cell containing 1 represents an obstacle, while 0 represents
     * an open space.
     *
     * @param obstacleGrid a 2D array where 1 indicates an obstacle
     *                     and 0 indicates an open cell
     * @return the number of unique valid paths to the destination
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        // Get the dimensions of the grid.
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        /*
         * dp[i][j] stores the number of unique paths from the starting
         * cell (0, 0) to the current cell (i, j).
         *
         * Initially, all cells have zero paths.
         */
        int[][] dp = new int[m][n];

        /*
         * If the starting cell is blocked, the robot cannot move.
         * Therefore, no valid path exists.
         */
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // There is exactly one way to reach the starting cell.
        dp[0][0] = 1;

        /*
         * Traverse every cell in row-major order.
         * This ensures that the cells above and to the left have
         * already been processed before calculating the current cell.
         */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // An obstacle cannot be part of a valid path.
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }

                /*
                 * Add the number of paths from the cell directly above.
                 * This move is possible only when i > 0.
                 */
                if (i > 0) {
                    dp[i][j] += dp[i - 1][j];
                }

                /*
                 * Add the number of paths from the cell directly left.
                 * This move is possible only when j > 0.
                 */
                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }

        /*
         * The bottom-right cell contains the total number of valid
         * paths from the starting cell to the destination.
         */
        return dp[m - 1][n - 1];
    }
}
