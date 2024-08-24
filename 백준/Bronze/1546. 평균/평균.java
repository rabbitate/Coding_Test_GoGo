import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int[] score = new int[n];
        int maxScore = 0;
        double answer = 0;

        for(int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(stringTokenizer.nextToken());
            maxScore = Math.max(maxScore, score[i]);
        }

        for(int i = 0; i < n; i++) {
            answer += score[i] / (1.0 * maxScore) * 100;
        }

        System.out.println(answer / n);
    }
}