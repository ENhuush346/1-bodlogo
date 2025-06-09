import java.io.*;
import java.util.*;

public class Solution {

    static final int MOD = 1000000007;
    static long[] fact, invFact;

    // Модул дээр factorial урьдчилан тооцох функц
    static void precomputeFactorials(int n) {
        fact = new long[n+1];
        invFact = new long[n+1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i-1] * i) % MOD;
        }
        invFact[n] = modInverse(fact[n], MOD);
        for (int i = n-1; i >= 0; i--) {
            invFact[i] = (invFact[i+1] * (i+1)) % MOD;
        }
    }

    // Ферматийн жижиг теорем ашиглан модул дээрх урвуу тоог олох функц
    static long modInverse(long a, int m) {
        return powMod(a, m-2, m);
    }

    static long powMod(long base, int exp, int mod) {
        long result = 1;
        long cur = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * cur) % mod;
            }
            cur = (cur * cur) % mod;
            exp >>= 1;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Уртаас factorial-үүдийг урьдчилан тооцоё
        precomputeFactorials(s.length());

        int halfLen = 0;
        for (int f : freq) {
            halfLen += f / 2;
        }

        long numerator = fact[halfLen];
        long denominator = 1;
        for (int f : freq) {
            denominator = (denominator * fact[f / 2]) % MOD;
        }

        long result = (numerator * modInverse(denominator, MOD)) % MOD;

        System.out.println(result);
    }
}
