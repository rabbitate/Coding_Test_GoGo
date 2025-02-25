import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] board;
    static int[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    private static void bfs(int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{a, b, 0});
        visited[a][b][0] = 1;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            int breakCnt = temp[2];

            if (x == n-1 && y == m-1) {
                System.out.println(visited[x][y][breakCnt]);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (0 <= newX && newX < n && 0 <= newY && newY < m) {
                    if (board[newX][newY] == 0 && visited[newX][newY][breakCnt] == 0) {
                        visited[newX][newY][breakCnt] = visited[x][y][breakCnt] + 1;
                        queue.offer(new int[]{newX, newY, breakCnt});
                    } else if (board[newX][newY] == 1 && breakCnt == 0) {
                        visited[newX][newY][1] = visited[x][y][0] + 1;
                        queue.offer(new int[]{newX, newY, 1});
                    }
                }
            }
        }

        System.out.println(-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        board = new int[n][m];
        visited = new int[n][m][2];

        for (int i = 0; i < n; i++) {
            String temp = bufferedReader.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = temp.charAt(j) - '0';
            }
        }

        bfs(0, 0);
    }
}
