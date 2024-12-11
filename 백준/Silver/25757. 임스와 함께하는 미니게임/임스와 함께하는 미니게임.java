import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        HashSet<String> idSet = new HashSet<>();
        String game = stringTokenizer.nextToken(); // 게임 종류
        int gameCnt = 0; // 게임 플레이 횟수
        int idCnt = 0;
        int target; // 플레이 인원 (본인 제외)

        if (game.equals("Y")) {
            target = 1;
        } else if (game.equals("F")) {
            target = 2;
        } else {
            target = 3;
        }

        for (int i = 0; i < n; i++) {
            String id = bufferedReader.readLine();

            if (!idSet.contains(id)) {
                idCnt++;
                idSet.add(id);
            }

            if (idCnt == target) {
                gameCnt++;
                idCnt = 0;
            }
        }

        System.out.println(gameCnt);
    }
}
