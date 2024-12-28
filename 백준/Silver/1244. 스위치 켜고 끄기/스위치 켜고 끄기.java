import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] switchArr = new int[n+1];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 1; i <= n; i++) {
            switchArr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int student = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < student; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int gender = Integer.parseInt(stringTokenizer.nextToken());
            int number = Integer.parseInt(stringTokenizer.nextToken());

            if (gender == 1) {
                for (int j = number; j <= n; j += number) {
                    switchArr[j] = switchArr[j] == 1 ? 0 : 1;
                }
            } else {
                int start = number;
                int end = number;

                while (start > 0 && end <= n && switchArr[start] == switchArr[end])  {
                    start--;
                    end++;
                }

                for (int j = start+1; j < end; j++) {
                    switchArr[j] = switchArr[j] == 1 ? 0 : 1;
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            System.out.print(switchArr[i] + " ");
            
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }
}
