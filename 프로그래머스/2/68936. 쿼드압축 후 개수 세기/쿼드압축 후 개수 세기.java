class Solution {
    static int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        quad(arr, 0, 0, arr.length);
        return answer;
    }
    
    void quad(int[][] arr, int x, int y, int size) {
        if (isAvailable(arr, x, y, size, arr[x][y])) {
            if (arr[x][y] == 0) {
                answer[0]++;
            } else {
                answer[1]++;
            }
            return;
        }
        
        quad(arr, x, y, size / 2);
        quad(arr, x + size / 2, y, size / 2);
        quad(arr, x, y + size / 2, size / 2);
        quad(arr, x + size / 2, y + size / 2, size / 2);
    }
    
    boolean isAvailable(int[][] arr, int x, int y, int size, int value) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}