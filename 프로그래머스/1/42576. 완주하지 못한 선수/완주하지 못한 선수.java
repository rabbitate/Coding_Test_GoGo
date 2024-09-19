import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        String answer = "";
        
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }        
        
        for (String c : completion) {
            if(map.containsKey(c)) {
                map.put(c, map.getOrDefault(c, 0) - 1);
            }
        }
        
        for (String k : map.keySet()) {
            if (map.get(k) == 1) {
                answer = k;
                break;
            }
        }
        
        return answer;
    }
}