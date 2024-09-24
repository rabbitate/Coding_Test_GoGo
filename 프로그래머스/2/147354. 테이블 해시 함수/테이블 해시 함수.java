import java.util.Arrays;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (a, b) -> {
            if (a[col-1] != b[col-1]) {
                return Integer.compare(a[col-1], b[col-1]);
            }
            return Integer.compare(b[0], a[0]);
        });
        
        int answer = 0;
        
        for (int i = row_begin-1; i < row_end; i++) {
            int total = 0;
            for (int j = 0; j < data[0].length; j++) {
                total += data[i][j] % (i+1);
            }
            answer = answer ^ total;
        }
        
        return answer;
    }
}