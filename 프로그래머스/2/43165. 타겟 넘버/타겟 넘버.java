class Solution {
    static int answer;
    static int numCount;
    static int[] number;
    public int solution(int[] numbers, int target) {
        answer = 0;
        number = numbers;
        numCount = numbers.length;
        
        dfs(0, 0, target);
        
        return answer;
    }
    
    static void dfs(int depth, int sum, int target) {
        if (depth == numCount) {
            if (sum == target) {
                answer++;
                return;
            }
        } else {
            dfs(depth+1, sum+number[depth], target);
            dfs(depth+1, sum-number[depth], target);
        }
    }
}