import java.util.*;

public class Solution2 {

    public static int sherlockAndAnagrams(String s) {
        Map<String, Integer> freq = new HashMap<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                char[] sub = s.substring(i, j).toCharArray();
                Arrays.sort(sub);
                String key = new String(sub);
                freq.put(key, freq.getOrDefault(key, 0) + 1);
            }
        }

        int count = 0;
        for (int val : freq.values()) {
            count += val * (val - 1) / 2;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        scanner.nextLine();

        for (int t = 0; t < q; t++) {
            String s = scanner.nextLine();
            System.out.println(sherlockAndAnagrams(s));
        }
    }
}
