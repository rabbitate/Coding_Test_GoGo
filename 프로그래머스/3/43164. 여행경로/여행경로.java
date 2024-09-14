import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<String> ticket;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length];
        ticket = new ArrayList<>();
        
        dfs("ICN", "ICN", tickets, 0);
        
        Collections.sort(ticket);
        
        return ticket.get(0).split(" ");
    }
    
    void dfs(String start, String route, String[][] tickets, int depth) {
        if (depth == tickets.length) {
            ticket.add(route);
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (visited[i] || !start.equals(tickets[i][0])) continue;
            visited[i] = true;
            dfs(tickets[i][1], route + " " + tickets[i][1], tickets, depth+1);
            visited[i] = false;
        }
    }
}