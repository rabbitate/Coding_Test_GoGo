import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int caseNum = Integer.parseInt(stringTokenizer.nextToken());

        int[] num = new int[n];
        int[] dp = new int[n+1];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i-1] + num[i-1];
        }

        for (int i = 0; i < caseNum; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());

            if (start == end) {
                stringBuilder.append(num[start - 1]).append('\n');
                continue;
            }

            stringBuilder.append(dp[end]-dp[start-1]).append('\n');
        }

        System.out.println(stringBuilder.toString());
    }
}
