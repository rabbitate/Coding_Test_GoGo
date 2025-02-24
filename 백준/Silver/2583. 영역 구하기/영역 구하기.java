import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int m;
    static int n;
    static int[][] board;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    private static int bfs(int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{a, b});
        board[a][b] = 1;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (0 <= newX && newX < m  && 0 <= newY && newY < n) {
                    if (board[newX][newY] == 0) {
                        board[newX][newY] = board[x][y] + 1;
                        count++;
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

        m = Integer.parseInt(stringTokenizer.nextToken());
        n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());

        board = new int[m][n];
        ArrayList<Integer> square = new ArrayList<>();

        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < k; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());
            int d = Integer.parseInt(stringTokenizer.nextToken());

            int width = c - a;
            int height = d - b;

            for (int j = b; j < b+height; j++) {
                for (int l = a; l < a+width; l++) {
                    board[j][l] = 1;
                }
            }
        }

        for (int j = 0; j < m; j++) {
            for (int l = 0; l < n; l++) {
                if (board[j][l] == 0) {
                    square.add(bfs(j, l));
                    count++;
                }
            }
        }

        square.sort((a, b) -> {
            return a- b;
        });

        stringBuilder.append(count).append('\n');
        for (int i = 0; i < count; i++) {
            stringBuilder.append(square.get(i)).append(' ');
        }

        System.out.println(stringBuilder.toString());
    }
}
