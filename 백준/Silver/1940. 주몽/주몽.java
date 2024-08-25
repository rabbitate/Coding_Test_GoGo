import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer( bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int[] materialArray = new int[n];

        for (int i = 0; i < n; i++) {
            materialArray[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(materialArray);

        int firstIndex = 0;
        int secondIndex = 1;
        int sum;
        int count = 0;

        while (firstIndex < n-1) {
            sum = materialArray[firstIndex] + materialArray[secondIndex];

            if (sum == m) {
                count++;
                firstIndex++;
                secondIndex = firstIndex + 1;
            } else if (sum < m) {
                if (secondIndex < n-1) {
                    secondIndex++;
                } else {
                    firstIndex++;
                    secondIndex = firstIndex + 1;
                }
            } else {
                firstIndex++;
                secondIndex = firstIndex + 1;
            }
        }

        System.out.println(count);
    }
}