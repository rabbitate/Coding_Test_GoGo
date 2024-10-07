class Solution {
    public long solution(int w, int h) {
        int gcd = getGCD(w, h);
        long width = w;
        long height = h;
        long answer = (width * height) - ((width / gcd + height / gcd) - 1) * gcd;

        return answer;
    }
    
    int getGCD(int a, int b) {
        int n = Math.min(a, b);
        
        while(true) {
            if (a % n == 0 && b % n == 0) {
                break;
            }
            n--;
        }
        
        return n;
    }
}