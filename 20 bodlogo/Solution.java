import java.util.*;

public class Solution {
    public static List<Integer> freqQuery(List<List<Integer>> queries) {
        Map<Integer, Integer> freq = new HashMap<>();         // value -> frequency
        Map<Integer, Integer> freqCount = new HashMap<>();    // frequency -> count of numbers
        List<Integer> result = new ArrayList<>();

        for (List<Integer> query : queries) {
            int op = query.get(0);
            int val = query.get(1);

            if (op == 1) {
                int oldFreq = freq.getOrDefault(val, 0);
                int newFreq = oldFreq + 1;

                freq.put(val, newFreq);

                // Update frequency count map
                freqCount.put(oldFreq, freqCount.getOrDefault(oldFreq, 0) - 1);
                freqCount.put(newFreq, freqCount.getOrDefault(newFreq, 0) + 1);

            } else if (op == 2) {
                int oldFreq = freq.getOrDefault(val, 0);
                if (oldFreq > 0) {
                    int newFreq = oldFreq - 1;

                    freq.put(val, newFreq);

                    // Update frequency count map
                    freqCount.put(oldFreq, freqCount.getOrDefault(oldFreq, 0) - 1);
                    freqCount.put(newFreq, freqCount.getOrDefault(newFreq, 0) + 1);
                }

            } else if (op == 3) {
                result.add(freqCount.getOrDefault(val, 0) > 0 ? 1 : 0);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> queries = Arrays.asList(
            Arrays.asList(1, 5),
            Arrays.asList(1, 6),
            Arrays.asList(3, 2),
            Arrays.asList(1, 10),
            Arrays.asList(1, 10),
            Arrays.asList(1, 6),
            Arrays.asList(2, 5),
            Arrays.asList(3, 2)
        );

        List<Integer> result = freqQuery(queries);
        for (int res : result) {
            System.out.println(res);
        }
    }
}
