class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] maxValueInRange = new int[len];
        int maxProfit = 0;
        maxValueInRange[len-1] = prices[len-1];

        for (int i = len-2; i > 0; i--) {
            maxValueInRange[i] = Math.max(prices[i], maxValueInRange[i+1]);
        }

        for (int i = 0; i < len-1; i++) {
            maxProfit = Math.max(maxProfit, maxValueInRange[i+1] - prices[i]);
        }

        return maxProfit;
    }
}