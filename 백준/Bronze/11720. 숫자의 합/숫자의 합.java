import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String num = scanner.next();
        char[] numArray = num.toCharArray();
        int answer = 0;

        for(int i = 0; i < n; i++) {
            answer += numArray[i] - '0';
        }
        System.out.println(answer);
    }
}