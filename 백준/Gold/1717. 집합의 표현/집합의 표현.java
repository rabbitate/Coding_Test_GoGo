import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        array = new int[n+1];

        for (int i = 0; i <= n; i++) {
            array[i] = i;
        }

        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int choice = Integer.parseInt(stringTokenizer.nextToken());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());

            if (choice == 1) {
                if (find(start) == find(end)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                union(find(start), find(end));
            }

        }
    }

    static int find(int index) {
        if (array[index] == index) {
            return index;
        } else {
            return find(array[index]);
        }
    }

    static void union(int start, int end) {
        int tempIndex = end;
        while (array[tempIndex] != end) {
            int temp = tempIndex;
            tempIndex = array[tempIndex];
            array[temp] = start;
        }
        array[tempIndex] = start;
    }
}
