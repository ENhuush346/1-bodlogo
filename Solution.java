import java.util.*;

public class Solution {
    public static long getWays(int n, int[] coins) {
        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] coins = new int[m];
        for (int i = 0; i < m; i++) {
            coins[i] = scanner.nextInt();
        }

        System.out.println(getWays(n, coins));
    }
}
