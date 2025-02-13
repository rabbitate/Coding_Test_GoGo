import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] stepScore = new int[n+1];
        int[][] dp = new int[n+1][3];

        for (int i = 1; i <= n; i++) {
            stepScore[i] = Integer.parseInt(bufferedReader.readLine());
        }
        
        if (n == 1) {
            System.out.println(stepScore[n]);
            return;
        }

        dp[1][1] = stepScore[1];
        dp[1][2] = 0;
        dp[2][1] = stepScore[2];
        dp[2][2] = stepScore[1] + stepScore[2];

        for (int i = 3; i <= n; i++) {
            dp[i][1] = Math.max(dp[i-2][1], dp[i-2][2]) + stepScore[i];
            dp[i][2] = dp[i-1][1] + stepScore[i];
        }

        System.out.println(Math.max(dp[n][1], dp[n][2]));
    }
}
