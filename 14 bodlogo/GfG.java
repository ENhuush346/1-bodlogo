import java.util.*;

class GfG {
    static int lisEndingAtIdx(int[] arr, int idx, int[] memo) {
    
        if (idx == 0)
            return 1;
    
        if (memo[idx] != -1)
            return memo[idx];

 
        int mx = 1;
        for (int prev = 0; prev < idx; prev++)
            if (arr[prev] < arr[idx])
                mx = Math.max(mx, lisEndingAtIdx(arr, prev, memo) + 1);

        memo[idx] = mx;
        return memo[idx];
    }

    static int lis(int[] arr) {
        int n = arr.length;
      
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
      
        int res = 1;
        for (int idx = 1; idx < n; idx++)
            res = Math.max(res, lisEndingAtIdx(arr, idx, memo));
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
        System.out.println(lis(arr));
    }
}
