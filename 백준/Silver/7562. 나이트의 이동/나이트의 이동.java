import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int l;
    static int curX;
    static int curY;
    static int desX;
    static int desY;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {-2, -1, 1, 2, -2, -1, 1, 2};

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{curX, curY});
        board[curX][curY] = 1;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];

            if (x == desX && y == desY) {
                System.out.println(board[x][y]-1);
                return;
            }

            for (int i = 0; i < 8; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (0 <= newX && newX < l && 0 <= newY && newY < l) {
                    if (board[newX][newY] == 0) {
                        queue.offer(new int[]{newX, newY});
                        board[newX][newY] = board[x][y] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            l = Integer.parseInt(bufferedReader.readLine());

            board = new int[l][l];

            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            curX = Integer.parseInt(stringTokenizer.nextToken());
            curY = Integer.parseInt(stringTokenizer.nextToken());

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            desX = Integer.parseInt(stringTokenizer.nextToken());
            desY = Integer.parseInt(stringTokenizer.nextToken());

            bfs();
        }
    }
}
