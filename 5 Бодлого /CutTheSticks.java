import java.util.*;

public class CutTheSticks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        List<Integer> sticks = new ArrayList<>();
        for (int length : arr) {
            sticks.add(length);
        }

        while (!sticks.isEmpty()) {
            int min = Collections.min(sticks);
            int count = 0;
            for (Iterator<Integer> iterator = sticks.iterator(); iterator.hasNext(); ) {
                int stick = iterator.next();
                if (stick > min) {
                    iterator.remove();
                    iterator = sticks.iterator();
                } else {
                    count++;
                }
            }
            System.out.println(sticks.size());
        }
    }
}
