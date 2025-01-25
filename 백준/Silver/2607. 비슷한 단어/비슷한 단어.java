import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int answer = 0;
        String first = "";
        HashMap<Character, Integer> org = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                first = bufferedReader.readLine();

                for (int j = 0; j < first.length(); j++) {
                    org.put(first.charAt(j), org.getOrDefault(first.charAt(j), 0)+1);
                }
            } else {
                String input = bufferedReader.readLine();
                HashMap<Character, Integer> com = new HashMap<>();

                for (int j = 0; j < input.length(); j++) {
                    com.put(input.charAt(j), com.getOrDefault(input.charAt(j), 0)+1);
                }

                int diffCnt = 0;

                for (char c : org.keySet()) {
                    int orgFreq = org.get(c);
                    int comFreq = com.getOrDefault(c, 0);
                    diffCnt += Math.abs(orgFreq - comFreq);
                }

                for (char c : com.keySet()) {
                    if (!org.containsKey(c)) {
                        diffCnt += com.get(c);
                    }
                }

                if (Math.abs(first.length() - input.length()) <= 1 && diffCnt <= 2) {
                    answer++;
                }
            }

        }

        System.out.println(answer);
    }
}
