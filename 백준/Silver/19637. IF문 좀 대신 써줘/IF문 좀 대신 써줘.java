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

        String[] title = new String[n];
        int[] power = new int[n];

        StringBuilder stringBuilder = new StringBuilder("");

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            title[i] = stringTokenizer.nextToken();
            power[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(bufferedReader.readLine());

            int start = 0;
            int end = n-1;

            while (start <= end) {
                int mid = (start + end) / 2;

                if (power[mid] < target) {
                    start = mid+1;
                } else {
                    end = mid-1;
                }
            }

            stringBuilder.append(title[start] +'\n');
        }

        System.out.println(stringBuilder.toString());
    }
}
