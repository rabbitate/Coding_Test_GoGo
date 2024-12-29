import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            int[] rankList = new int[n]; // 데이터 리스트
            ArrayList<Integer>[] validTeamScore = new ArrayList[n+1];

            for (int j = 1; j <= n; j++) {
                validTeamScore[j] = new ArrayList<>();
            }

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            // 데이터 입력
            for (int j = 0; j < n; j++) {
                rankList[j] = Integer.parseInt(stringTokenizer.nextToken());
            }

            // 팀별 인원 세기
            HashMap<Integer, Integer> teamCnt = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int teamNum = rankList[j];
                teamCnt.put(teamNum, teamCnt.getOrDefault(teamNum, 0) + 1);
            }

            // 유효한 팀 점수 검사
            int score = 1;
            for (int j = 0; j < n; j++) {
                int teamNum = rankList[j];
                if (teamCnt.get(teamNum) == 6) {
                    validTeamScore[teamNum].add(score++);
                }
            }

            int winnerTotalScore = Integer.MAX_VALUE;
            int winner = -1;

            // 우승팀 구하기
            for (int j = 0; j < n; j++) {
                int teamNum = rankList[j];
                if (teamCnt.get(teamNum) == 6) {
                    int sum = 0;
                    for (int k = 0; k < 4; k++) {
                        sum += validTeamScore[teamNum].get(k);
                    }

                    if (winnerTotalScore > sum) {
                        winnerTotalScore = sum;
                        winner = teamNum;
                    } else {
                        if (winnerTotalScore == sum && validTeamScore[winner].get(4) > validTeamScore[teamNum].get(4)) {
                            winner = teamNum;
                        }
                    }
                }
            }

            stringBuilder.append(winner).append('\n');
        }

        System.out.println(stringBuilder.toString());
    }
}