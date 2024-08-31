import java.util.Scanner;

public class Main {
    static int calNum(String num) {
        String[] string = num.split("[+]");
        int sum = 0;
        for (int i = 0; i < string.length; i++) {
            sum += Integer.parseInt(string[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int answer = 0;

        String[] string = input.split("-");

        for (int i = 0; i < string.length; i++) {
            if (i == 0) {
                answer += calNum(string[i]);
            } else {
                answer -= calNum(string[i]);
            }
        }

        System.out.println(answer);
    }
}
