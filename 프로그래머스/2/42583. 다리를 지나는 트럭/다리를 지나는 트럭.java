import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int totalWeight = 0;
        
        Queue<Integer> bridge = new LinkedList<>();
        
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        
        for (int truck : truck_weights) {
            while (true) {
                totalWeight -= bridge.poll();
                
                if (totalWeight + truck <= weight) {
                    totalWeight += truck;
                    bridge.offer(truck);
                    answer++;
                    break;
                } else {
                    bridge.offer(0);
                    answer++;
                }
            }
            
        }
        
        answer += bridge_length;
        
        return answer;
    }
}
