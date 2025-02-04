import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        char[] cArr = str.toCharArray();

        int zeroCnt = 0;
        int oneCnt = 0;

        for (int i = 0; i < cArr.length; i++) {
            if (cArr[i] == '0') {
                zeroCnt++;
            } else {
                oneCnt++;
            }
        }

        zeroCnt /= 2;
        oneCnt /= 2;

        for (int i = cArr.length-1; i >= 0 && zeroCnt > 0; i--) {
            if (cArr[i] == '0') {
                cArr[i] = '2';
                zeroCnt--;
            }
        }

        for (int i = 0; i < cArr.length && oneCnt > 0; i++) {
            if (cArr[i] == '1') {
                cArr[i] = '2';
                oneCnt--;
            }
        }

        for (char c : cArr) {
            if (c != '2') {
                System.out.print(c);
            }
        }
    }
}
