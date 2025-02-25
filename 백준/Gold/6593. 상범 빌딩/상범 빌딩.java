import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int L;
    static int R;
    static int C;
    static char[][][] board;
    static int[][][] visited;
    static int[] dz = {-1, 1, 0, 0, 0, 0};
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 0, -1, 1};

    private static void bfs(int a, int b, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{a, b, c});

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int z = temp[0];
            int x = temp[1];
            int y = temp[2];

            for (int i = 0; i < 6; i++) {
                int newZ = z + dz[i];
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (0 <= newZ && newZ < L && 0 <= newX && newX < R && 0 <= newY && newY < C) {
                    if (board[newZ][newX][newY] == 'E') {
                        System.out.printf("Escaped in %d minute(s).\n", visited[z][x][y] + 1);
                        return;
                    }

                    if (visited[newZ][newX][newY] == 0 && board[newZ][newX][newY] == '.') {
                        visited[newZ][newX][newY] = visited[z][x][y] + 1;
                        queue.offer(new int[]{newZ, newX, newY});
                    }
                }
            }
        }


        System.out.println("Trapped!");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            L = Integer.parseInt(stringTokenizer.nextToken());
            R = Integer.parseInt(stringTokenizer.nextToken());
            C = Integer.parseInt(stringTokenizer.nextToken());

            if (L == 0 && R == 0 && C == 0) {
                return;
            }

            board = new char[L][R][C];
            visited = new int[L][R][C];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String temp = bufferedReader.readLine();
                    for (int k = 0; k < C; k++) {
                        board[i][j][k] = temp.charAt(k);
                    }
                }
                bufferedReader.readLine();
            }

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    for (int k = 0; k < C; k++) {
                        if (board[i][j][k] == 'S') {
                            bfs(i, j, k);
                        }
                    }
                }
            }

        }
    }
}
