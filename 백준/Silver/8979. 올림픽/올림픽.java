import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());

        int[][] country = new int[n+1][3];

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int c = Integer.parseInt(stringTokenizer.nextToken());
            for (int j = 0; j < 3; j++) {
                country[c][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        Arrays.sort(country, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                if (a[1] != b[1]) {
                    return a[1] - b[1];
                } else {
                    return a[2] - b[2];
                }
            }
        });

        int rank = 1;
        int stdSum = Arrays.stream(country[0]).sum();

        for (int i = 0; i < n; i++) {
            int sum = Arrays.stream(country[i]).sum();
            if (sum != stdSum) {
                rank++;
                stdSum = sum;
            }
            if (i == k) {
                System.out.println(rank);
            }
        }
    }
}
