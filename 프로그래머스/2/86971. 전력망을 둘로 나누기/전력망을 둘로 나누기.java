import java.util.ArrayList;

class Solution {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    
    public int solution(int n, int[][] wires) {
        int answer = -1;
        int diff = n;
        graph = new ArrayList[n+1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < wires.length; i++) {
            int s = wires[i][0];
            int e = wires[i][1];
            
            graph[s].add(e);
            graph[e].add(s);
        }
        
        for (int i = 0; i < wires.length; i++) {
            int s = wires[i][0];
            int e = wires[i][1];
            
            graph[s].remove(Integer.valueOf(e));
            graph[e].remove(Integer.valueOf(s));
            
            visited = new boolean[n+1];
            
            int temp = dfs(1);
            
            graph[s].add(e);
            graph[e].add(s);
            
            diff = Math.min(diff, Math.abs(temp - (n - temp)));
        }
        
        return diff;
    }
    
    int dfs(int start) {
        visited[start] = true;
        int count = 1;
        
        for (int v : graph[start]) {
            if (!visited[v]) {
                count += dfs(v);
            }
        }
        
        return count;
    }
}