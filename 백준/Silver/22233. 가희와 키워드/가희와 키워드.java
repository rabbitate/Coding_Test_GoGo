import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        Set<String> memo = new HashSet<>();

        StringBuilder stringBuilder = new StringBuilder("");

        for (int i = 0; i < n; i++) {
            String temp = bufferedReader.readLine();
            memo.add(temp);
        }

        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            while (stringTokenizer.hasMoreTokens()) {
                String keyword = stringTokenizer.nextToken(",");

                if (memo.contains(keyword)) {
                    memo.remove(keyword);
                }
            }

            stringBuilder.append(memo.size() + "\n");
        }

        System.out.println(stringBuilder.toString());
    }
}
