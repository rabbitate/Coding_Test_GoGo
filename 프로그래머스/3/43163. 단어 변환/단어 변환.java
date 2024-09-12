import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Queue<String> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[words.length];
        int answer = 0;
        
        queue.offer(begin);
        
        while(!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                String s = queue.poll();
            
                if (s.equals(target)) return answer;

                for (int j = 0; j < words.length; j++) {
                    if (!isVisited[j] && isValid(s, words[j])) {
                        isVisited[j] = true;
                        queue.offer(words[j]);
                    }
                }
            }
            
            answer++;
        }
        
        return 0;
    }
    
    boolean isValid(String standard, String word) {
        int count = 0;
        
        for (int i = 0; i < standard.length(); i++) {
            if (standard.charAt(i) == word.charAt(i)) {
                count++;
            }
        }
        
        if (count == standard.length()-1) {
            return true;
        }
        
        return false;
    }
}