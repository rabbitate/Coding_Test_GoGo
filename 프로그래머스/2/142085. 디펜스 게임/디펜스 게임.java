import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Collections;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < enemy.length; i++) {
            n -= enemy[i];
            pq.offer(enemy[i]);
            
            if (n < 0) {
                if (k > 0) {
                    n += pq.poll();
                    k -= 1;
                } else {
                    return i;
                }
            }        
        }
        
        return enemy.length;
    }
}