import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

class Solution {
    static boolean[][] visited;
    static String[] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public LinkedList<Integer> solution(String[] maps) {
        visited = new boolean[maps.length][maps[0].length()];
        map = maps;
        LinkedList<Integer> answer = new LinkedList<>();
        
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    answer.add(bfs(i, j));
                }
            }
        }
        
        if (answer.size() == 0) {
            answer.add(-1);
            return answer;
        } else {
            Collections.sort(answer);
            return answer;
        }
    }
    
    int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        int sum = map[x].charAt(y) - '0';
        
        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int newX = temp[0];
            int newY = temp[1];
            
            for (int i = 0; i < 4; i++) {
                newX = temp[0] + dx[i];
                newY = temp[1] + dy[i];
                
                if (0 <= newX && newX < map.length && 0 <= newY && newY < map[0].length()) {
                    if (map[newX].charAt(newY) != 'X' && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        queue.offer(new int[] {newX, newY});
                        sum += map[newX].charAt(newY) - '0';
                    }
                }
            }
        }
        
        return sum;
    }
}