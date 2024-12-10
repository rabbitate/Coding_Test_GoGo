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

        int[][] country = new int[n][4];

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < 4; j++) {
                country[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        Arrays.sort(country, (a, b) -> {
            if (a[1] != b[1]) {
                return b[1] - a[1];
            } else {
                if (a[2] != b[2]) {
                    return b[2] - a[2];
                } else {
                    return b[3] - a[3];
                }
            }
        });

        int rank = 1;
        int cnt = 1;

        for (int i = 0; i < n; i++) {
            if (i > 0) {
                // 이전 국가와 메달 비교
                if (country[i][1] == country[i - 1][1] &&
                        country[i][2] == country[i - 1][2] &&
                        country[i][3] == country[i - 1][3]) {
                    // 메달 수가 같으면 순위 유지
                    cnt++;
                } else {
                    // 메달 수가 다르면 순위 갱신
                    rank += cnt;
                    cnt = 1;
                }
            }

            // 찾고자 하는 국가의 번호일 경우 출력 후 종료
            if (country[i][0] == k) {
                System.out.println(rank);
                break;
            }
        }
    }
}
