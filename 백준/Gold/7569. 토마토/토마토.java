import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][][] board;
    static int h;
    static int n;
    static int m;
    static boolean[][][] isVisited;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();

    private static int bfs() {
        int day = 1;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int z = temp[0];
            int x = temp[1];
            int y = temp[2];

            for (int i = 0; i < 6; i++) {
                int newZ = z + dz[i];
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (0 <= newZ && newZ < h && 0 <= newX && newX < n && 0 <= newY && newY < m) {
                    if (board[newZ][newX][newY] == 0) {
                        board[newZ][newX][newY] = board[z][x][y] + 1;
                        day = Math.max(board[newZ][newX][newY], day);
                        queue.offer(new int[]{newZ, newX, newY});
                    }
                }
            }
        }

        return day;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        m = Integer.parseInt(stringTokenizer.nextToken());
        n = Integer.parseInt(stringTokenizer.nextToken());
        h = Integer.parseInt(stringTokenizer.nextToken());

        board = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int k = 0; k < m; k++) {
                    board[i][j][k] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (board[i][j][k] == 1) {
                        queue.offer(new int[]{i, j, k});
                    }
                }
            }
        }

        int answer = bfs()-1;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (board[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
