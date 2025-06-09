import java.io.*;
import java.util.*;

public class Solution {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        int[][] dp = new int[n+1][k+1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            int[] prefix = new int[k+1];
            prefix[0] = dp[i-1][0];
            for (int j = 1; j <= k; j++) {
                prefix[j] = (prefix[j-1] + dp[i-1][j]) % MOD;
            }

            for (int j = 0; j <= k; j++) {
                int val = prefix[j];
                if (j - i >= 0) {
                    val = (val - prefix[j - i] + MOD) % MOD;
                }
                dp[i][j] = val;
            }
        }

        int S1 = dp[n][k];
        int S2 = 0;
        for (int i = 0; i <= k; i++) {
            S2 = (S2 + dp[n][i]) % MOD;
        }

        System.out.println(S1 + " " + S2);
    }
}
