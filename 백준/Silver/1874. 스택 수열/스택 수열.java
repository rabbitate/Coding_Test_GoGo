import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numArray = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            numArray[i] = scanner.nextInt();
        }

        int current = 1; // 현재 숫자
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < n; i++) {
            int target = numArray[i];

            if (current <= target) {
                while (current <= target) {
                    stack.push(current++);
                    stringBuffer.append("+\n");
                }
                stack.pop();
                stringBuffer.append("-\n");
            } else {
                int ret = stack.pop();
                if (ret == target) {
                    stringBuffer.append("-\n");
                } else {
                    stringBuffer = new StringBuffer("NO");
                    break;
                }
            }
        }

        System.out.println(stringBuffer);
    }
}
