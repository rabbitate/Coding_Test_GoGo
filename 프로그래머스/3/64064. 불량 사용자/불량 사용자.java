import java.util.HashSet;

class Solution {
    static HashSet<HashSet<String>> hashSet = new HashSet<>();
    static String[] userIds;
    static String[] bannedIds;
    
    public int solution(String[] user_id, String[] banned_id) {
        userIds = user_id;
        bannedIds = banned_id;
        
        dfs(new HashSet<>(), 0);
        
        return hashSet.size();
    }
    
    void dfs(HashSet<String> set, int depth) {
        if (depth == bannedIds.length) {
            hashSet.add(set);
            return;
        }
        
        for (int i = 0; i < userIds.length; i++) {
            if (set.contains(userIds[i])) continue;
            
            if (check(userIds[i], bannedIds[depth])) {
                set.add(userIds[i]);
                dfs(new HashSet<> (set), depth + 1);
                set.remove(userIds[i]);
            }
        }
    }
    
    boolean check(String id, String bannedId) {
        if (id.length() != bannedId.length()) return false;
        
        for (int i = 0; i < id.length(); i++) {
            if (bannedId.charAt(i) != '*' && bannedId.charAt(i) != id.charAt(i)) {
                return false;
            }
        }
        
        return true;
    }
}