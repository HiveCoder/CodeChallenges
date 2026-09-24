import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            // First and last elements are always 1
            row.add(1);

            // Calculate the middle elements
            for (int j = 1; j < i; j++) {
                int value = triangle.get(i - 1).get(j - 1)
                           + triangle.get(i - 1).get(j);

                row.add(value);
            }

            // Add the last 1 if this isn't the first row
            if (i > 0) {
                row.add(1);
            }

            triangle.add(row);
        }

        return triangle;
    }
}
