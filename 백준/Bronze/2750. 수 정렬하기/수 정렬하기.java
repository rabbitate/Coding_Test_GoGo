import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void BubbleSort(int[] array) {
        for (int i = array.length-1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] numArray = new int[n];

        for (int i = 0; i < n; i++) {
            numArray[i] = Integer.parseInt(bufferedReader.readLine());
        }

        BubbleSort(numArray);

        for (int i = 0; i < n; i++) {
            System.out.println(numArray[i]);
        }
    }
}
