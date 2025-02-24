import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] building;
    static int[] dx = new int[2];
    static int F;
    static int S;
    static int G;

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        building[S] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < 2; i++) {
                int pos = cur + dx[i];

                if (pos == G) {
                    System.out.println(building[cur]);
                    return;
                }

                if (1 <= pos && pos <= F) {
                    if (building[pos] == 0) {
                        building[pos] = building[cur] + 1;
                        queue.offer(pos);
                    }
                }
            }
        }

        System.out.println("use the stairs");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        F = Integer.parseInt(stringTokenizer.nextToken());
        S = Integer.parseInt(stringTokenizer.nextToken());
        G = Integer.parseInt(stringTokenizer.nextToken());
        int U = Integer.parseInt(stringTokenizer.nextToken());
        int D = Integer.parseInt(stringTokenizer.nextToken());

        building = new int[F+1];
        dx[0] = U;
        dx[1] = D * -1;

        if (S == G) {
            System.out.println(0);
            return;
        }

        bfs();
    }
}
