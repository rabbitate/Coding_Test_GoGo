class Solution {
    static int N;
    static int count = 0;
    static int[] arr;
    
    public int solution(int n) {
        N = n;
        arr = new int[n];
        backTracking(0);
        return count;
    }
    
    void backTracking(int depth) {
        if (depth == N) {
            count++;
            return;
        }
        
        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            if (isValid(depth)) {
                backTracking(depth+1);
            }
        }
    }
    
    boolean isValid(int depth) {
        for (int i = 0; i < depth; i++) {
            if (arr[i] == arr[depth]) return false;
            else if (Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) return false;
        }
        
        return true;
    }
}