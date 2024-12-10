import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] info = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            info[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            info[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }


        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                else {
                    if (info[i][0] < info[j][0] && info[i][1] < info[j][1]) {
                        rank++;
                    }
                }
            }
            info[i][2] = rank;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(info[i][2] + " ");
        }
    }
}
