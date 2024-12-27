import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int addScore = Integer.parseInt(stringTokenizer.nextToken());
        int p = Integer.parseInt(stringTokenizer.nextToken());
        int rank = 1;

        Integer[] scoreList = new Integer[n];

        if (n != 0) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        }

        for (int i = 0; i < n; i++) {
            scoreList[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        if (n == p && scoreList[n-1] >= addScore) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < n; i++) {
                if (scoreList[i] > addScore) {
                    rank++;
                } else {
                    break;
                }
            }
            System.out.println(rank);

        }

    }
}
