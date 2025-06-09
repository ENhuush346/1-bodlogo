import java.util.*;

public class MinimumSwaps {
    public static int minSwaps(int[] arr) {
        int n = arr.length;

        // Элементийн утга болон индексийг хадгалах
        ArrayList<Pair> arrPos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrPos.add(new Pair(arr[i], i));
        }

        // Элементүүдийг утгаар нь эрэмбэлнэ
        arrPos.sort(Comparator.comparingInt(p -> p.value));

        // Зочлох эсэхийг тэмдэглэх массив
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        int swaps = 0;

        // Цикл бүрийг хайж, солилцоо тооцоолно
        for (int i = 0; i < n; i++) {
            // Хэрвээ аль хэдийн зочилсон эсвэл аль хэдийн зөв байвал үгүйсгэнэ
            if (visited[i] || arrPos.get(i).index == i) {
                continue;
            }

            // Цикл үүсгэх
            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = arrPos.get(j).index;
                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }

        return swaps;
    }

    static class Pair {
        int value;
        int index;
        Pair(int v, int i) {
            value = v;
            index = i;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 8, 5, 4};
        System.out.println(minSwaps(arr1));  // Output: 1

        int[] arr2 = {10, 19, 6, 3, 5};
        System.out.println(minSwaps(arr2));  // Output: 2

        int[] arr3 = {1, 3, 4, 5, 6};
        System.out.println(minSwaps(arr3));  // Output: 0
    }
}
