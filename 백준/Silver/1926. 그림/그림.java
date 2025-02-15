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
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        int count = 0;
        visited[x][y] = true;
        queue.offer(new int[]{x, y});

        while (!queue.isEmpty()) {
            count += 1;
            int[] temp = queue.poll();
            int a = temp[0];
            int b = temp[1];

            for (int i = 0; i < 4; i++) {
                int newX = a + dx[i];
                int newY = b + dy[i];

                if (0 <= newX && newX < n && 0 <= newY && newY < m) {
                    if (board[newX][newY] == 1 && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m];
        int count = 0;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    count++;
                    answer = Math.max(bfs(i, j), answer);
                }
            }
        }

        System.out.println(count);
        System.out.println(answer);
    }
}
