import java.util.Queue;
import java.util.LinkedList;

class Solution {
    static final int SIZE = 101;
    static int[][] map = new int[SIZE][SIZE];
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {       
        for (int i = 0; i < rectangle.length; i++) {
            int sx = rectangle[i][0] * 2;
            int sy = rectangle[i][1] * 2;
            int ex = rectangle[i][2] * 2;
            int ey = rectangle[i][3] * 2;
            
            draw(sx, sy, ex, ey);
        }
        
        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }
    
    void draw(int sx, int sy, int ex, int ey) {
        for (int x = sx; x <= ex; x++) {
            for (int y = sy; y <= ey; y++) {
                if (map[x][y] == 2) continue;
                if (x == sx || x == ex || y == sy || y == ey) {
                    map[x][y] = 1;
                } else {
                    map[x][y] = 2;
                }
            }
        }
    }
    
    int bfs(int cX, int cY, int iX, int iY) {
        Queue<int[]> queue = new LinkedList<>();
        
        map[cX][cY] = 0;
        queue.offer(new int[]{cX, cY});
        
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            
            if (x == iX && y == iY) {
                return map[x][y] / 2;
            }
            
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                
                if (newX < 0 || newX >= map.length || newY < 0 || newY >= map[0].length) continue;
                
                if (map[newX][newY] == 1) {
                    map[newX][newY] = map[x][y] + 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        
        return -1;
    }
}