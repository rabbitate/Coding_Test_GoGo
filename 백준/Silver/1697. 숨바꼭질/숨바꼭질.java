import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());

        int[] board = new int[100000+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            if (cur == k) break;

            if (cur - 1 >= 0 && board[cur-1] == 0) {
                board[cur-1] = board[cur] + 1;
                queue.offer(cur-1);
            }

            if (cur + 1 <= 100000 && board[cur+1] == 0) {
                board[cur+1] = board[cur] + 1;
                queue.offer(cur+1);
            }

            if (cur * 2 <= 100000 && board[cur*2] == 0) {
                board[cur*2] = board[cur] + 1;
                queue.offer(cur*2);
            }
        }

        System.out.println(board[k]);
    }
}
