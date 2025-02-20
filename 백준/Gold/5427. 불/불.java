import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int w;
    static int h;
    static char[][] board;
    static int[][] SVisited;
    static int[][] FVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> FQueue = new LinkedList<>();
    static Queue<int[]> SQueue = new LinkedList<>();

    private static void bfs() {
        while (!FQueue.isEmpty()) {
            int[] temp = FQueue.poll();
            int x = temp[0];
            int y = temp[1];

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (0 <= newX && newX < h && 0 <= newY && newY < w) {
                    if (board[newX][newY] != '#' && FVisited[newX][newY] == 0) {
                        FVisited[newX][newY] = FVisited[x][y] + 1;
                        FQueue.offer(new int[]{newX, newY});
                    }
                }
            }
        }

        while (!SQueue.isEmpty()) {
            int[] temp = SQueue.poll();
            int x = temp[0];
            int y = temp[1];

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX < 0 || newX == h || newY < 0 || newY == w) {
                    System.out.println(SVisited[x][y]+1);
                    return;
                }

                if (0 <= newX && newX < h && 0 <= newY && newY < w) {
                    if (board[newX][newY] == '.' && SVisited[newX][newY] == 0 && (FVisited[newX][newY] == 0 || SVisited[x][y] + 1 < FVisited[newX][newY])) {
                        SVisited[newX][newY] = SVisited[x][y] + 1;
                        SQueue.offer(new int[]{newX, newY});
                    }
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            w = Integer.parseInt(stringTokenizer.nextToken());
            h = Integer.parseInt(stringTokenizer.nextToken());

            board = new char[h][w];
            SVisited = new int[h][w];
            FVisited = new int[h][w];

            for (int j = 0; j < h; j++) {
                String temp = bufferedReader.readLine();
                for (int k = 0; k < w; k++) {
                    board[j][k] = temp.charAt(k);
                }
            }

            for (int j = 0; j < h; j++) {
                for (int k = 0; k < w; k++) {
                    if (board[j][k] == '@') {
                        SQueue.offer(new int[]{j, k});
                    }
                    if (board[j][k] == '*') {
                        FQueue.offer(new int[]{j, k});
                    }
                }
            }

            bfs();

            FQueue.clear();
            SQueue.clear();
        }

    }
}
