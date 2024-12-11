import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String input = bufferedReader.readLine();
            if (input.trim().equals("end")) break;

            int mo = 0;
            int moCnt = 0;
            int jaCnt = 0;
            int isValid = 0;

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == 'a' || input.charAt(i) == 'e' || input.charAt(i) == 'i' || input.charAt(i) == 'o' || input.charAt(i) == 'u') {
                    mo++;
                    moCnt++;
                    jaCnt = 0;
                } else {
                    jaCnt++;
                    moCnt = 0;
                }

                if (jaCnt >= 3 || moCnt >= 3) {
                    isValid = -1;
                    break;
                }

                if (i > 0) {
                    if (input.charAt(i) == input.charAt(i-1)) {
                        if (!(input.charAt(i) == 'e' || input.charAt(i) == 'o')) {
                            isValid = -1;
                            break;
                        }
                    }
                }
            }

            if (mo == 0) {
                isValid = -1;
            }

            if (isValid == 0) {
                System.out.println("<" + input + "> is acceptable.");
            } else {
                System.out.println("<" + input + "> is not acceptable.");
            }
        }
    }
}
