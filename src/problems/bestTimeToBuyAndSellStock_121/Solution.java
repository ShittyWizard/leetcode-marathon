package problems.bestTimeToBuyAndSellStock_121;

// link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock
public class Solution {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minBuy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            maxProfit = Math.max(maxProfit, price - minBuy);
            minBuy = Math.min(price, minBuy);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = new int[]{7,1,5,3,6,4};
        int[] prices2 = new int[]{7,6,4,3,1};
        int[] prices3 = new int[]{7};
        System.out.println(maxProfit(prices1)); // 5
        System.out.println(maxProfit(prices2)); // 0
        System.out.println(maxProfit(prices3)); // 0
    }
}
