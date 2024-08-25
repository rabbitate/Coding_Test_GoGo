import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numArray = new int[n];
        int startIndex = 0;
        int endIndex = 0;
        int count = 0;
        int sum = 1;

        for (int i = 0; i < n; i++) {
            numArray[i] = i+1;
        }

        while (startIndex < n) {
            if (sum < n) {
                endIndex++;
                sum += numArray[endIndex];
            } else if (sum > n) {
                sum -= numArray[startIndex];
                startIndex++;
            } else if (sum == n) {
                count++;
                sum -= numArray[startIndex];
                startIndex++;
            }
        }

        System.out.println(count);
    }
}
