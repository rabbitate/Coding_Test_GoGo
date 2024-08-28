import java.util.Scanner;

public class Main {
    public static void SelectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int maxIndex = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[maxIndex];
            array[maxIndex] = temp;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int[] numArray = new int[input.length()];

        for (int i = 0; i < input.length(); i++) {
            numArray[i] = input.charAt(i) - '0';
        }

        SelectionSort(numArray);

        for (int i = 0; i < input.length(); i++) {
            System.out.print(numArray[i]);
        }
    }
}
