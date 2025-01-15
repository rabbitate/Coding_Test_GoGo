import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());

        String table = bufferedReader.readLine();
        boolean[] check = new boolean[n];
        int cnt = 0;

        for (int i = 0; i < table.length(); i++) {
            if (table.charAt(i) == 'P') {
                boolean isValid = false;

                for (int j = i-k; j < i; j++) {
                    if (j >= 0) {
                        if (!check[j] && table.charAt(j) == 'H') {
                            check[j] = true;
                            cnt++;
                            isValid = true;
                            break;
                        }
                    }
                }

                if (isValid) continue;

                for (int j = i+1; j < i+k+1; j++) {
                    if (j < n) {
                        if (!check[j] && table.charAt(j) == 'H') {
                            check[j] = true;
                            cnt++;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
