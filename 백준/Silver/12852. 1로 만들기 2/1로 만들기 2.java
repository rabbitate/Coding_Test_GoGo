import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());

        int[] dp = new int[1000000 + 1];
        int[] prev = new int[1000000 + 1];

        dp[1] = 0;

        if (n == 1) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + 1;
            prev[i] = i-1;

            if (i % 2 == 0 && dp[i] > dp[i/2] + 1) {
                dp[i] = dp[i/2] + 1;
                prev[i] = i/2;
            }

            if (i % 3 == 0 && dp[i] > dp[i/3] + 1) {
                dp[i] = dp[i/3] + 1;
                prev[i] = i/3;
            }
        }

        System.out.println(dp[n]);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n).append(" ");

        int temp = n;

        while (temp > 1) {
            stringBuilder.append(prev[temp]).append(" ");
            temp = prev[temp];
        }

        System.out.println(stringBuilder.toString());
    }
}
