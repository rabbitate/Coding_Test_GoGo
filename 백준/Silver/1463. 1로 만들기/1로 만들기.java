import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        int[] dp = new int[n+1];

        if (n <= 3) {
            if (n == 1) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
            return;
        }

        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= n; i++) {
            int temp = dp[i-1];

            if (i % 2 == 0) {
                temp = Math.min(temp, dp[i/2]);
            }

            if (i % 3 == 0) {
                temp = Math.min(temp, dp[i/3]);
            }

            dp[i] = temp + 1;
        }

        System.out.println(dp[n]);
    }
}
