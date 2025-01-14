import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int x = Integer.parseInt(stringTokenizer.nextToken());

        int[] visits = new int[n];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            visits[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int sum = 0;
        int maxSum = 0;
        int cnt = 0;

        for (int i = 0; i <= n-x; i++) {
            if (i == 0) {
                for (int j = 0; j < x; j++) {
                    sum += visits[j];
                }
                maxSum = sum;
                cnt++;
            } else {
                sum = sum - visits[i-1] + visits[i+x-1];
                if (maxSum == sum) {
                    cnt++;
                } else {
                    if (sum > maxSum) {
                        maxSum = sum;
                        cnt = 1;
                    }
                }
            }
        }

        if (maxSum == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxSum);
            System.out.println(cnt);
        }
    }
}
