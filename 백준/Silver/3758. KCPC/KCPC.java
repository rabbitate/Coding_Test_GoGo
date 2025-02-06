import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bufferedReader.readLine());

        for (int j = 0; j < T; j++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int n = Integer.parseInt(stringTokenizer.nextToken());
            int k = Integer.parseInt(stringTokenizer.nextToken());
            int t = Integer.parseInt(stringTokenizer.nextToken());
            int m = Integer.parseInt(stringTokenizer.nextToken());

            int[][] team = new int[n+1][4]; // 점수, 풀이 제출 횟수, 제출 시간, 팀 ID
            int[][] scoreArr = new int[n+1][k+1];

            for (int i = 1; i <= m; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());

                int teamID = Integer.parseInt(stringTokenizer.nextToken());
                int probID = Integer.parseInt(stringTokenizer.nextToken());
                int score = Integer.parseInt(stringTokenizer.nextToken());

                if (scoreArr[teamID][probID] < score) {
                    team[teamID][0] -= scoreArr[teamID][probID];
                    scoreArr[teamID][probID] = score;
                    team[teamID][0] += score;
                }

                team[teamID][1]++;
                team[teamID][2] = i;
                team[teamID][3] = teamID;
            }

            Arrays.sort(team, (a, b) -> {
                if (a[0] == b[0] && a[1] == b[1]) {
                    return a[2] - b[2];
                } else if (a[0] == b[0]) {
                    return a[1] - b[1];
                }

                return b[0] - a[0];
            });

            for (int i = 0; i < n; i++) {
                if (team[i][3] == t) {
                    System.out.println(i+1);
                }
            }
        }
    }
}
