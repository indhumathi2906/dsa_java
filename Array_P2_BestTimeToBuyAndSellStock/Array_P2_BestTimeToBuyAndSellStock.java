package Array_P2_BestTimeToBuyAndSellStock;

import java.util.Arrays;

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

    public int maxProfitDP(int[] prices) {
        if (!validatePrices(prices)) return 0;
        int n = prices.length;
        int[] minPriceSoFar = new int[n];
        minPriceSoFar[0] = prices[0];
        for (int i = 1; i < n; i++) {
            minPriceSoFar[i] = Math.min(minPriceSoFar[i - 1], prices[i]);
        }

        int maxProfit = 0;
        for (int i = 1; i < n; i++) {
            int profit = prices[i] - minPriceSoFar[i - 1];
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }

    public int maxProfitOptimal(int[] prices) {
        if (!validatePrices(prices)) return 0;
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Array_P2_BestTimeToBuyAndSellStock solver = new Array_P2_BestTimeToBuyAndSellStock();
        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println("Problem 2: Best Time to Buy and Sell Stock Suite");
        System.out.println("Prices: " + Arrays.toString(prices));
        System.out.println("Brute Force Max Profit: " + solver.maxProfitBruteForce(prices));
        System.out.println("DP Tabulation Profit:   " + solver.maxProfitDP(prices));
        System.out.println("Optimal Greedy Profit:  " + solver.maxProfitOptimal(prices));
    }
}
