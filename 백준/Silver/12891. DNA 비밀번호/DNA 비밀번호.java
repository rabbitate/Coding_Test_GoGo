import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static boolean subStringCheck(int[] checkArray, int[] subStringArray) {
        for (int i = 0; i < 4; i++) {
            if (checkArray[i] > subStringArray[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int s = Integer.parseInt(stringTokenizer.nextToken());
        int p = Integer.parseInt(stringTokenizer.nextToken());

        char[] dnaString = bufferedReader.readLine().toCharArray();

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] checkArray = new int[4]; // 문자열 조건

        for (int i = 0; i < 4; i++) {
            checkArray[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int count = 0;

        int[] subStringArray = new int[4];

        for (int i = 0; i <= p-1; i++) {
            if (dnaString[i] == 'A') {
                subStringArray[0]++;
            } else if (dnaString[i] == 'C') {
                subStringArray[1]++;
            } else if (dnaString[i] == 'G') {
                subStringArray[2]++;
            } else if (dnaString[i] == 'T') {
                subStringArray[3]++;
            }
        }

        if (subStringCheck(checkArray, subStringArray)) {
            count++;
        }


        for (int i = p; i < s; i++) {
            int oldIndex = i-p;
            int newIndex = i;

            if (dnaString[oldIndex] == 'A') {
                subStringArray[0]--;
            } else if (dnaString[oldIndex] == 'C') {
                subStringArray[1]--;
            } else if (dnaString[oldIndex] == 'G') {
                subStringArray[2]--;
            } else if (dnaString[oldIndex] == 'T') {
                subStringArray[3]--;
            }

            if (dnaString[newIndex] == 'A') {
                subStringArray[0]++;
            } else if (dnaString[newIndex] == 'C') {
                subStringArray[1]++;
            } else if (dnaString[newIndex] == 'G') {
                subStringArray[2]++;
            } else if (dnaString[newIndex] == 'T') {
                subStringArray[3]++;
            }

            if (subStringCheck(checkArray, subStringArray)) {
                count++;
            }
        }

        System.out.println(count);
    }
}