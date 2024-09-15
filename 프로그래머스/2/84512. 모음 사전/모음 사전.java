import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static ArrayList<String> list;
    public int solution(String word) {
        int answer = 0;
        list = new ArrayList<>();
        
        dfs("", new String[]{"A", "E", "I", "O", "U"}, 0);
        
        return list.indexOf(word);
    }
    
    void dfs(String current, String[] word, int depth) {
        list.add(current);
        
        if (depth == word.length) {
            return;
        }
        
        for (int i = 0; i < word.length; i++) {
            dfs(current + word[i], word, depth+1);
        }
    }
}