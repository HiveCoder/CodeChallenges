class Solution {
    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {

            // Find the cheapest day to buy
            if (price < minPrice) {
                minPrice = price;
            }

            // Calculate profit if we sell today
            int profit = price - minPrice;

            // Update maximum profit
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }
}
