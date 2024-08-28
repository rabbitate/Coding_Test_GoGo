import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> {
            int firstAbs = Math.abs(a);
            int secondAbs = Math.abs(b);

            if (firstAbs == secondAbs) {
                return a - b;
            }

            return firstAbs - secondAbs;
        });

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(bufferedReader.readLine());

            if (input == 0) {
                if (priorityQueue.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(priorityQueue.poll());
                }
            } else {
                priorityQueue.add(input);
            }
        }
    }
}
