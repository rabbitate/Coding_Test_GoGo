import java.util.ArrayList;

class Solution {
    static boolean[][] visited;
    static int[][] computer;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n][n];
        computer = computers;
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && computers[i][j] == 1) {
                    dfs(i, j);
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    void dfs(int x, int y) {
        if (visited[x][y]) {
            return;
        }
        
        visited[x][y] = true;
        visited[y][x] = true;
        
        for (int i = 0; i < computer.length; i++) {
            if (computer[y][i] == 1) {
                dfs(y, i);
            }
        }
    }
}