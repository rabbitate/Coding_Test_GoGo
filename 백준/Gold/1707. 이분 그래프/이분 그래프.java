import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] arrayLists;
    static boolean[] isVisited;
    static int[] group;
    static boolean isGraph;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int v = Integer.parseInt(stringTokenizer.nextToken());
            int e = Integer.parseInt(stringTokenizer.nextToken());
            arrayLists = new ArrayList[v+1];
            isVisited = new boolean[v+1];
            group = new int[v+1];
            isGraph = true; // 이분 그래프인지 여부

            for (int j = 1; j <= v; j++) {
                arrayLists[j] = new ArrayList<Integer>();
            }

            for (int j = 0; j < e; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int start = Integer.parseInt(stringTokenizer.nextToken());
                int end = Integer.parseInt(stringTokenizer.nextToken());
                arrayLists[start].add(end);
                arrayLists[end].add(start);
            }

            for (int j = 1; j <= v; j++) {
                if (isGraph) {
                    dfs(j);
                } else {
                    break;
                }
            }

            if (isGraph) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static void dfs(int start) {
        isVisited[start] = true;

        for (int i : arrayLists[start]) {
            if (isVisited[i]) {
                if (group[start] == group[i]) {
                    isGraph = false;
                }
            } else {
                group[i] = (group[start] + 1) % 2;
                dfs(i);
            }
        }
    }
}
