import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] array;
    static int target;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        array = new int[n];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(array);

        int m = Integer.parseInt(bufferedReader.readLine());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < m; i++) {
            target = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(BinarySearch(0, array.length-1));

        }
    }

    static int BinarySearch(int start, int end) {
        if (start > end) return 0;

        int mid = (start + end) / 2;

        if (target == array[mid]) {
            return 1;
        } else if (target > array[mid]) {
            return BinarySearch(mid+1, end);
        } else {
            return BinarySearch(start, mid-1);
        }
    }
}