public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(bufferedReader.readLine());

        for (int qItr = 0; qItr < q; qItr++) {
            String s = bufferedReader.readLine();
            int result = Result.sherlockAndAnagrams(s);
            System.out.println(result);
        }

        bufferedReader.close();
    }
}
