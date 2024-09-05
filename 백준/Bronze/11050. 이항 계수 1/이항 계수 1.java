import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());

        int[][] dp = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            dp[i][i] = 1;
            dp[i][1] = i;
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        System.out.println(dp[n][k]);
    }
}
