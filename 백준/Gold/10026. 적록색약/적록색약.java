import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n;
    static char[][] board;
    static boolean[][] isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    private static void bfs(int a, int b, char color, boolean isDisorder) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{a, b});
        isVisited[a][b] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (0 <= newX && newX < n && 0 <= newY && newY < n) {
                    if (isDisorder) {
                        if (color == 'R' || color == 'G') {
                            if (!isVisited[newX][newY] && (board[newX][newY] == 'R' || board[newX][newY] == 'G')) {
                                isVisited[newX][newY] = true;
                                queue.offer(new int[]{newX, newY});
                            }
                        } else {
                            if (!isVisited[newX][newY] && board[newX][newY] == 'B') {
                                isVisited[newX][newY] = true;
                                queue.offer(new int[]{newX, newY});
                            }
                        }
                    } else {
                        if (!isVisited[newX][newY] && board[newX][newY] == color) {
                            isVisited[newX][newY] = true;
                            queue.offer(new int[]{newX, newY});
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        n = Integer.parseInt(bufferedReader.readLine());
        board = new char[n][n];
        isVisited = new boolean[n][n];
        char[] color = {'R', 'G', 'B'};

        for (int i = 0; i < n; i++) {
            String temp = bufferedReader.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = temp.charAt(j);
            }
        }

        int count = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (board[j][k] == color[i] && !isVisited[j][k]) {
                        bfs(j, k, color[i], false);
                        count++;
                    }
                }
            }
        }

        stringBuilder.append(count + " ");

        isVisited = new boolean[n][n];
        count = 0;

        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                if (!isVisited[j][k]) {
                    bfs(j, k, board[j][k], true);
                    count++;
                }
            }
        }

        stringBuilder.append(count);

        System.out.println(stringBuilder.toString());
    }
}
