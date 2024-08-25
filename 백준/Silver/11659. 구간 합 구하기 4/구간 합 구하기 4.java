import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int[] numArray = new int[n];
        int[] sumArray = new int[n];

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            numArray[i] = Integer.parseInt(stringTokenizer.nextToken());
            if (i == 0) {
                sumArray[i] = numArray[i];
            } else {
                sumArray[i] = sumArray[i-1] + numArray[i];
            }
        }

        for (int k = 0; k < m; k++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken())-1;
            int j = Integer.parseInt(stringTokenizer.nextToken())-1;

            int answer;
            if (i == 0) {
                answer = sumArray[j];
            } else {
                answer = sumArray[j] - sumArray[i-1];
            }

            System.out.println(answer);
        }

    }
}
