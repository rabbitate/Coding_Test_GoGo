def solution(k, m, score):
    answer = 0
    box = []
    score.sort(reverse=True)
    for i in range(1,len(score)//m+1):
        answer += score[m * i -1] * m
        
    return answer