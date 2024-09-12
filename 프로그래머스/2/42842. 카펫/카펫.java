class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int x = 0;
        int y = 0;
        
        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            if (yellow % i == 0) {
                x = yellow / i;
                int temp = (i * 2) + (x + 2) * 2;
                
                if (temp == brown) {
                    x += 2;
                    y = i + 2;
                    break;
                }
            }
        }
        
        answer = new int[]{x, y};
        
        return answer;
    }
}