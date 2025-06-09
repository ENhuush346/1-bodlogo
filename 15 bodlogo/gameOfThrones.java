import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'gameOfThrones' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String gameOfThrones(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int oddCount = 0;
        for (int count : freq) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        if ((s.length() % 2 == 0 && oddCount == 0) || (s.length() % 2 == 1 && oddCount == 1)) {
            return "YES";
        } else {
            return "NO";
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter ашиглахгүй, зөвхөн системийн гаралт руу бичнэ.
        String s = bufferedReader.readLine();

        String result = Result.gameOfThrones(s);

        System.out.println(result);

        bufferedReader.close();
    }
}
