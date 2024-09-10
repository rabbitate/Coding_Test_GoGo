class Solution {
    public int[] solution(int[] answers) {
        int answerLength = answers.length;
        int[] personA = {1,2,3,4,5};
        int[] personB = {2,1,2,3,2,4,2,5};
        int[] personC = {3,3,1,1,2,2,4,4,5,5};
        int countA = 0;
        int countB = 0;
        int countC = 0;
        
        for (int i = 0; i < answers.length; i++) {
            int indexA = i % personA.length;
            if (personA[indexA] == answers[i]) {
                countA++;
            }
            
            int indexB = i % personB.length;
            if (personB[indexB] == answers[i]) {
                countB++;
            }
            
            int indexC = i % personC.length;
            if (personC[indexC] == answers[i]) {
                countC++;
            }  
        }
        
        int[] arr = {countA, countB, countC};
        
        int max = countA;
        int count = 0;
        
        for (int i : arr) {
            if (max < i) {
                max = i;
            }
        }
        
        for (int i : arr) {
            if (max == i) {
                count++;
            }
        }
        
        int[] answer = new int[count];
        int peopleIndex = 0;

        for (int i = 0; i < 3; i++) {
            if (arr[i] == max) {
                answer[peopleIndex++] = i+1;
            }
        }
        
        return answer;
    }
}