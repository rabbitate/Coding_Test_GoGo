class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int posTime = Integer.parseInt(pos.substring(0,2)) * 60 + Integer.parseInt(pos.substring(3));
        int startTime = Integer.parseInt(op_start.substring(0,2)) * 60 + Integer.parseInt(op_start.substring(3));
        int endTime = Integer.parseInt(op_end.substring(0,2)) * 60 + Integer.parseInt(op_end.substring(3));
        int videoTime = Integer.parseInt(video_len.substring(0,2)) * 60 + Integer.parseInt(video_len.substring(3));
        
        if (startTime <= posTime && posTime <= endTime) {
            posTime = endTime;
        }
        
        for (String command : commands) {
            if (command.equals("next")) {
                posTime += 10;
            } else {
                posTime -= 10;
            }
            
            if (posTime < 0) posTime = 0;
            if (posTime > videoTime) posTime = videoTime;
            if (startTime <= posTime && posTime <= endTime) {
                posTime = endTime;
            }
        }
        
        String hour = Integer.toString(posTime / 60);
        String min = Integer.toString(posTime % 60);
        
        if (hour.length() == 1) {
            hour = "0" + hour;
        }
        
        if (min.length() == 1) {
            min = "0" + min;
        }
        
        String answer = hour + ":" + min;
        
        return answer;
    }
}