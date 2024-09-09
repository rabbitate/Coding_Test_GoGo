import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
        int max_x = 0;
        int max_y = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            Arrays.sort(sizes[i]);
            int x = sizes[i][0];
            int y = sizes[i][1];
            
            if (max_x < x) {
                max_x = x;
            }
            if (max_y < y) {
                max_y = y;
            }
        }
        
        return max_x * max_y;
    }
}