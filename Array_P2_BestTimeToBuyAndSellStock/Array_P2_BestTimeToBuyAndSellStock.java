package Array_P2_BestTimeToBuyAndSellStock;

/**
 * Array Problem 2: 121. Best Time to Buy and Sell Stock (LeetCode #121)
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * Description:
 * You are given an array prices where prices[i] is the price of a given stock on the i-th day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * Time Complexity: Brute Force O(N^2), DP Tabulation O(N), Optimal Greedy O(N)
 * Space Complexity: Brute Force O(1), DP Tabulation O(N), Optimal Greedy O(1)
 */
public class Array_P2_BestTimeToBuyAndSellStock {

    public boolean validatePrices(int[] prices) {
        return prices != null && prices.length >= 2;
    }

    public int maxProfitBruteForce(int[] prices) {
        if (!validatePrices(prices)) return 0;
        int maxProfit = 0;
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
}
