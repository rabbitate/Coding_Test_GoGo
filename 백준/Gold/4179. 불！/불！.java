import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] board;
    static int[][] fireTime;
    static int[][] jihoonTime;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int r;
    static int c;
    static Queue<int[]> JQueue = new LinkedList<>();
    static Queue<int[]> FQueue = new LinkedList<>();

    private static void bfs() {
        while (!FQueue.isEmpty()) {
            int[] temp = FQueue.poll();
            int x = temp[0];
            int y = temp[1];

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (0 <= newX && newX < r && 0 <= newY && newY < c) {
                    if (board[newX][newY] == '.' && fireTime[newX][newY] == 0) {
                        FQueue.offer(new int[]{newX, newY});
                        fireTime[newX][newY] = fireTime[x][y] + 1;
                    }
                }
            }
        }

        while (!JQueue.isEmpty()) {
            int[] temp = JQueue.poll();
            int x = temp[0];
            int y = temp[1];

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX < 0 || newX >= r || newY < 0 || newY >= c) {
                    System.out.println(jihoonTime[x][y]);
                    return;
                }

                if (board[newX][newY] == '.' && jihoonTime[newX][newY] == 0 && (fireTime[newX][newY] == 0 || jihoonTime[x][y] + 1 < fireTime[newX][newY])) {
                    JQueue.offer(new int[]{newX, newY});
                    jihoonTime[newX][newY] = jihoonTime[x][y] + 1;
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        r = Integer.parseInt(stringTokenizer.nextToken());
        c = Integer.parseInt(stringTokenizer.nextToken());

        board = new char[r][c];
        fireTime = new int[r][c];
        jihoonTime = new int[r][c];

        for (int i = 0; i < r; i++) {
            String temp = bufferedReader.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = temp.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'J') {
                    JQueue.offer(new int[]{i, j});
                    jihoonTime[i][j] = 1;
                }
                if (board[i][j] == 'F') {
                    FQueue.offer(new int[]{i, j});
                    fireTime[i][j] = 1;
                }
            }
        }

        bfs();
    }
}
