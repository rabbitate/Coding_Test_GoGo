import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
        int max = 0;
        int min = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            Arrays.sort(sizes[i]);
            int x = sizes[i][0];
            int y = sizes[i][1];
            
            if (max < x) {
                max = x;
            }
            if (min < y) {
                min = y;
            }
        }
        
        return max * min;
    }
}