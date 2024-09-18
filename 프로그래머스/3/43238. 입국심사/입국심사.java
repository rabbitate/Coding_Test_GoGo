import java.util.Arrays;

class Solution {
    static int[] timeArr;
    public long solution(int n, int[] times) {
        long answer;
        timeArr = times;
        Arrays.sort(times);
        long max = (long) times[times.length-1] * n;
        
        answer = binarySearch(0, max, n);
        return answer;
    }
    
    long binarySearch(long start, long end, int target) {
        if (start > end) {
            return start;
        }
        
        long mid = (start + end) / 2;
        
        if (calTime(mid) < target) {
            return binarySearch(mid+1, end, target);
        } else {
            return binarySearch(start, mid-1, target);
        }
    }
    
    long calTime(long time) {
        long count = 0;
        for (int t : timeArr) {
            count += time / t;
        }
        
        return count;
    }
}