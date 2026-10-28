// 121. Best Time to Buy and Sell Stock

// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

public class Stock_buy_sell {

    // My Solution
    static int maxProfit(int[] prices) {
        // for buying
        int b = Integer.MAX_VALUE;
        int maxp = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < b) {
                b = prices[i];
            }

            if (prices[i] - b > maxp) {
                maxp = prices[i] - b;
            }
        }

        return maxp;

        // WRONG DUE TO TIME CONSTRAINTS (O(n^2))
        
        // int maxp = 0;
        // for(int i = 0; i < prices.length - 1; i++){
        // for(int j = i; j < prices.length; j++){
        // if(prices[j] - prices[i] > maxp){
        // maxp = prices[j] - prices[i];
        // }
        // }
        // }
        // return maxp;
    }

    public static void main(String[] args) {
        // Example 1:
        // Input: prices = [7,1,5,3,6,4]
        // Output: 5
        // Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit =
        // 6-1 = 5.
        int[] prices1 = { 7, 1, 5, 3, 6, 4 };
        System.out.println("Output 1: " + maxProfit(prices1));

        // Example 2:
        // Input: prices = [7,6,4,3,1]
        // Output: 0
        // Explanation: In this case, no transactions are done and the max profit = 0.
        int[] prices2 = { 7, 6, 4, 3, 1 };
        System.out.println("Output 2: " + maxProfit(prices2));
    }
}
