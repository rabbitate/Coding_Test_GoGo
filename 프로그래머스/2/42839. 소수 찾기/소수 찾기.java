import java.util.HashSet;
import java.util.Set;

class Solution {
    static boolean[] visited = new boolean[7];
    static Set<Integer> set;
    public int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();
        
        dfs(numbers, "", 0);
        
        for (int i : set) {
            if(isPrime(i)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    void dfs(String numbers, String number, int depth) {
        if (depth == numbers.length()) {
            return;
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                set.add(Integer.parseInt(number + numbers.charAt(i)));
                dfs(numbers, number+numbers.charAt(i), depth+1);
                visited[i] = false;
            }
        }
    }
    
    boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}