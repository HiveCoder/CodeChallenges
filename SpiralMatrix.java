import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        // 📌 Result list that will store the spiral traversal order
        List<Integer> result = new ArrayList<>();

        // 🛑 Edge case: if matrix is empty, return empty result immediately
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        // 📌 Define the 4 boundaries of the current "layer"
        int top = 0;                      // top row index (starts at first row)
        int bottom = matrix.length - 1;   // bottom row index (last row)
        int left = 0;                     // left column index (first column)
        int right = matrix[0].length - 1; // right column index (last column)

        // 🔁 Keep processing layers until boundaries overlap
        while (top <= bottom && left <= right) {

            // =========================
            // 1️⃣ LEFT → RIGHT (TOP ROW)
            // =========================
            // We traverse the current top row from left boundary to right boundary
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);  // add each element in the top row
            }

            // After finishing top row, we move the top boundary downward
            // because this row is fully processed
            top++;

            // =========================
            // 2️⃣ TOP → BOTTOM (RIGHT COLUMN)
            // =========================
            // Now traverse the rightmost column from top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]); // add each element in right column
            }

            // After finishing right column, shrink the right boundary
            right--;

            // =========================
            // 3️⃣ RIGHT → LEFT (BOTTOM ROW)
            // =========================
            // Before traversing bottom row, ensure we still have a valid row
            if (top <= bottom) {

                // Traverse bottom row from right to left
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }

                // After finishing bottom row, move bottom boundary upward
                bottom--;
            }

            // =========================
            // 4️⃣ BOTTOM → TOP (LEFT COLUMN)
            // =========================
            // Before traversing left column, ensure we still have a valid column
            if (left <= right) {

                // Traverse left column from bottom to top
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }

                // After finishing left column, move left boundary rightward
                left++;
            }

            // 🔁 After these 4 steps, one full "layer" (outer ring) is removed
        }

        // 📌 Once all layers are processed, return the spiral order result
        return result;
    }
}
