import java.util.Arrays;

public class Q322_CoinChange {
    static class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            dp[0] = 0;
            for (int currAmount = 1; currAmount <= amount; currAmount++) {
                int minCoins = -1;
                for (int coin : coins) {
                    if (currAmount >= coin && dp[currAmount - coin] >= 0) {
                        int numCoins = dp[currAmount - coin] + 1;
                        if (minCoins == -1 || numCoins < minCoins) minCoins = numCoins;
                    }
                }
                dp[currAmount] = minCoins;
            }
            return dp[amount];
        }
    }
}
