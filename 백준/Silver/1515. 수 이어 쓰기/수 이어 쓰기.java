import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String num = bufferedReader.readLine();

        int base = 0;
        int pointer = 0;

        while (base++ < 30000) {
            String tmp = String.valueOf(base);
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == num.charAt(pointer)) {
                    pointer++;
                }

                if (pointer == num.length()) {
                    System.out.println(base);
                    return;
                }
            }
        }
    }
}
