import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] gasStation = new int[n];
        int[] distance = new int[n-1];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n-1; i++) {
            distance[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            gasStation[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int cost = 0;
        int current = gasStation[0];

        for (int i = 0; i < n-1; i++) {
            if (gasStation[i] < current) {
                current = gasStation[i];
            }

            cost += current * distance[i];
        }

        System.out.println(cost);
    }
}
