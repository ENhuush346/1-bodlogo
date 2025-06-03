import java.io.*;
import java.util.*;

class Result {
    public static int sherlockAndAnagrams(String s) {
        Map<String, Integer> substrCount = new HashMap<>();
        int totalPairs = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                char[] chars = s.substring(i, j).toCharArray();
                Arrays.sort(chars); // Анаграмуудыг ялгахад түлхүүр
                String key = new String(chars);
                substrCount.put(key, substrCount.getOrDefault(key, 0) + 1);
            }
        }

        for (Integer count : substrCount.values()) {
            totalPairs += (count * (count - 1)) / 2; // Хосуудын тоо
        }

        return totalPairs;
    }
}
