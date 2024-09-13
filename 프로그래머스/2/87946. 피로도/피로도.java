class Solution {
    static boolean[] visited;
    static int count = 0;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        dfs(dungeons, k, 0);

        return count;
    }
    
    void dfs(int[][] dungeons, int k, int depth) {
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i] || dungeons[i][0] > k) continue;
            
            visited[i] = true;
            dfs(dungeons, k-dungeons[i][1], depth+1);
            visited[i] = false;
        }
        count = Math.max(depth, count);
    }
}