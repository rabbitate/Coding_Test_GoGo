import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] lampPos;
    static int n;

    public static boolean isPossible(int pos) {
        int lastPos = 0;
        for (int i = 0; i < lampPos.length; i++) {
            if (lampPos[i] - pos > lastPos) {
                return false;
            } else {
                lastPos = lampPos[i] + pos;
            }
        }
        return lastPos >= n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        int m = Integer.parseInt(bufferedReader.readLine());
        lampPos = new int[m];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < m; i++) {
            lampPos[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int start = 0;
        int end = n;
        int result = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (isPossible(mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(result);
    }
}
