import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        int M = Integer.parseInt(parts[0]);
        int N = Integer.parseInt(parts[1]);
        int R = Integer.parseInt(parts[2]);

        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }

        int layers = Math.min(M, N) / 2;

        for (int layer = 0; layer < layers; layer++) {
            int rows = M - 2 * layer;
            int cols = N - 2 * layer;
            int perimeter = 2 * (rows + cols) - 4;

            int rEffective = R % perimeter;
            if (rEffective == 0) continue;

            // Extract layer elements to list
            List<Integer> elems = new ArrayList<>();

            // top row
            for (int j = layer; j < layer + cols; j++) elems.add(matrix[layer][j]);
            // right col
            for (int i = layer + 1; i < layer + rows - 1; i++) elems.add(matrix[i][layer + cols - 1]);
            // bottom row
            for (int j = layer + cols - 1; j >= layer; j--) elems.add(matrix[layer + rows - 1][j]);
            // left col
            for (int i = layer + rows - 2; i > layer; i--) elems.add(matrix[i][layer]);

            // Rotate anti-clockwise by rEffective
            Collections.rotate(elems, -rEffective);

            // Put back
            int idx = 0;
            // top row
            for (int j = layer; j < layer + cols; j++) matrix[layer][j] = elems.get(idx++);
            // right col
            for (int i = layer + 1; i < layer + rows - 1; i++) matrix[i][layer + cols - 1] = elems.get(idx++);
            // bottom row
            for (int j = layer + cols - 1; j >= layer; j--) matrix[layer + rows - 1][j] = elems.get(idx++);
            // left col
            for (int i = layer + rows - 2; i > layer; i--) matrix[i][layer] = elems.get(idx++);
        }

        // Print result
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(matrix[i][j]);
                if (j != N - 1) sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
