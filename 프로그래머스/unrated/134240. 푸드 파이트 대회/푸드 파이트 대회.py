def solution(food):
    answer = '0'
    for i in range(len(food)-1,0,-1):
        for _ in range(food[i]//2):
            answer = str(i) + answer + str(i)
    return answer