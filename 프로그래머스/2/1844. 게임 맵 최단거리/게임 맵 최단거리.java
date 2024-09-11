import java.util.Queue;
import java.util.LinkedList;

class Solution {
    static int[][] map;
    static int n;
    static int m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int answer;
        n = maps.length;
        m = maps[0].length;
        map = maps;
        
        bfs(0,0);
        
        if (map[n-1][m-1] == 1) {
            answer = -1;
        } else {
            answer = map[n-1][m-1];
        }
        
        return answer;
    }
    
    void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        map[x][y] = 1;
        
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int a = temp[0];
            int b = temp[1];
            
            for (int i = 0; i < 4; i++) {
                int newX = a + dx[i];
                int newY = b + dy[i];
                
                if (0 <= newX && newX < n && 0 <= newY && newY < m) {
                    if (map[newX][newY] == 1) {
                        map[newX][newY] = map[a][b] + 1;
                        queue.add(new int[]{newX, newY});
                    }
                }
            }
        }
    }
}