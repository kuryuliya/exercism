import java.util.List;

class Knapsack {

    int maximumValue(int maximumWeight, List<Item> items) {
        if (items.isEmpty() || maximumWeight <= 0) {
            return 0;
        }
        
        int n = items.size();
        int[][] dp = new int[n + 1][maximumWeight + 1];
        
        // Fill the dp table
        for (int i = 1; i <= n; i++) {
            Item currentItem = items.get(i - 1);
            
            for (int w = 0; w <= maximumWeight; w++) {
                // Don't include current item
                dp[i][w] = dp[i - 1][w];
                
                // Include current item if it fits
                if (currentItem.weight <= w) {
                    dp[i][w] = Math.max(dp[i][w], dp[i - 1][w - currentItem.weight] + currentItem.value);
                }
            }
        }
        
        return dp[n][maximumWeight];
    }

}