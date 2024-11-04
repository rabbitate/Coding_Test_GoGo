class Solution {
    static boolean[] visited;
    static int[][] com;
    static int len;
    
    static void dfs(int i) {
        visited[i] = true;
        for(int k = 0; k < len; k++) {
            if(!visited[k] && i != k && com[i][k] == 1) {
                dfs(k);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        len = n;
        com = computers;
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(i);
                answer++;
            }   
        }
        
        return answer;
    }
}