class Solution {
    public String solution(String s) {
        int max = 0;
        int min = 0;
        String[] sp = s.split(" ");
        for (int i = 0; i < sp.length; i++) {
            int current = Integer.parseInt(sp[i]);
            if (i == 0) {
                max = current;
                min = current;
            } else {
                if (max < current) max = current;
                if (min > current) min = current;
            }
        }
        
        return String.valueOf(min) + " " + String.valueOf(max);
    }
}