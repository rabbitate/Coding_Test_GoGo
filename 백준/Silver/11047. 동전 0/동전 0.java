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

        int[] coin = new int[n];
        int coinIndex = 0;

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            coin[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = n-1; i >= 0; i--) {
            if (coin[i] <= k) {
                coinIndex = i;
                break;
            }
        }

        int count = 0;

        for (int i = coinIndex; i >= 0; i--) {
            if (k == 0) break;
            else if (k / coin[i] == 0) continue;
            else {
                count += k / coin[i];
                k %= coin[i];
            }
        }

        System.out.println(count);
    }
}
