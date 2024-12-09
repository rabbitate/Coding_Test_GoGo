import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int p = Integer.parseInt(bufferedReader.readLine());
        int[][] stuArr = new int[p+1][20];
        int[] cnt = new int[p+1];

        for (int i = 1; i <= p; i++) {
            String input = bufferedReader.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(input);
            stringTokenizer.nextToken();
            for (int j = 0; j < 20; j++) {
                stuArr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for (int i = 1; i <= p; i++) {
            for (int j = 1; j < 20; j++) {
                int target = stuArr[i][j];
                int index = j-1;

                while (index >= 0 && stuArr[i][index] > target) {
                    stuArr[i][index+1] = stuArr[i][index];
                    index--;
                    cnt[i]++;
                }

                stuArr[i][index+1] = target;
            }
        }

        for (int i = 1; i <= p; i++) {
            System.out.println(i + " " + cnt[i]);
        }
    }
}
