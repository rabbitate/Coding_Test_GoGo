import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> voc = new HashMap<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 0; i < n; i++) {
            String word = bufferedReader.readLine();
            if (word.length() < m) continue;
            voc.put(word, voc.getOrDefault(word, 0)+1);
        }

        List<String> keySet = new ArrayList<>(voc.keySet());
        Collections.sort(keySet, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (Integer.compare(voc.get(o1), voc.get(o2)) != 0) {
                    return Integer.compare(voc.get(o2), voc.get(o1));
                }

                if (o1.length() != o2.length()) {
                    return Integer.compare(o2.length(), o1.length());
                }

                return o1.compareTo(o2);
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (String key : keySet) {
            stringBuilder.append(key + "\n");
        }

        System.out.println(stringBuilder);
    }
}
