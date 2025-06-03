public class Knapsack01 {

    // Function to solve 0/1 Knapsack using DP
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;

        // Create DP table with dimensions (n+1) x (capacity+1)
        int[][] dp = new int[n + 1][capacity + 1];

        // Build the DP table
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    // Include or exclude the item
                    dp[i][w] = Math.max(
                        values[i - 1] + dp[i - 1][w - weights[i - 1]],
                        dp[i - 1][w]
                    );
                } else {
                    // Cannot include the item
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Print the DP table
        System.out.println("DP Table:");
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                System.out.print(dp[i][w] + "\t");
            }
            System.out.println();
        }

        // Return the maximum value
        return dp[n][capacity];
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int capacity = 5;

        int maxValue = knapsack(weights, values, capacity);
        System.out.println("\nMaximum value in knapsack: " + maxValue);
    }
}
