class Solution {
    public int maxProfit(int[] prices) {

        int minimumPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price : prices){

            // Find cheapest day to buy
            if(price < minimumPrice){
                minimumPrice = price;
            }

            // Calculate profit if selling today
            int profit = price - minimumPrice;

            // Keep the best profit
            if(profit > maxProfit){
                maxProfit = profit;
            }
        }

        return maxProfit;
    }
}
