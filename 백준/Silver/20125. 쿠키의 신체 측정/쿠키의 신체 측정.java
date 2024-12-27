import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        char[][] pan = new char[n][n];

        int heartX = -1;
        int heartY = -1;

        for (int i = 0; i < n; i++) {
            pan[i] = bufferedReader.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (pan[i][j] == '*') {
                    heartX = i+1;
                    heartY = j;
                    break;
                }
            }

            if (heartX != -1) break;
        }

        // 심장 위치
        heartX += 1;
        heartY += 1;
        System.out.println(heartX + " " + heartY);
        heartX--;
        heartY--;

        // 왼쪽 팔
        int leftArm = 0;
        for (int i = heartY-1; i >= 0; i--) {
            if (pan[heartX][i] == '*') {
                leftArm++;
            } else break;
        }

        // 오른쪽 팔
        int rightArm = 0;
        for (int i = heartY+1; i < n; i++) {
            if (pan[heartX][i] == '*') {
                rightArm++;
            } else break;
        }

        // 허리
        int waist = 0;
        int temp = heartX+1;

        while (pan[temp][heartY] == '*') {
            waist++;
            temp++;
        }

        // 왼쪽 다리
        int leftLeg = 0;
        int leftTemp = temp;

        while (leftTemp < n && pan[leftTemp][heartY-1] == '*') {
            leftLeg++;
            leftTemp++;
        }

        // 오른쪽 다리
        int rightLeg = 0;
        int rightTemp = temp;

        while (rightTemp < n && pan[rightTemp][heartY+1] == '*') {
            rightLeg++;
            rightTemp++;
        }

        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
    }
}
