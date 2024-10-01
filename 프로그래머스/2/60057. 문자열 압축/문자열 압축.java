class Solution {
    public int solution(String s) {
        int len = s.length();
        int answer = len;
        
        if(len == 1) return 1;
        
        for (int i = 1; i <= len / 2; i++) {
            StringBuffer sb = new StringBuffer();
            String prevStr = "";
            int count = 1;
            
            for (int j = 0; j <= len - i; j += i) {
                String curStr = s.substring(j, j + i);
                
                if (prevStr.equals(curStr)) {
                    count++;
                    continue;
                } else if (count > 1) {
                    sb.append(count + prevStr);
                    count = 1;
                } else {
                    sb.append(prevStr);
                }
                
                prevStr = curStr;
            }
            
            sb.append(count > 1 ? count + prevStr : prevStr);
            
            if (len % i != 0) {
                sb.append(s.substring(len - len % i, len));
            }
            
            answer = Math.min(answer, sb.length());
        }
        
        return answer;
    }
}