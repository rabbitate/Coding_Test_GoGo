def solution(number, limit, power):
    answer = 0
    nlist = [1 for _ in range(number+1)]
    for i in range(2, number+1):
        for j in range(i, number+1, i):
            nlist[j] += 1
    for i in nlist:
        if i > limit:
            answer += power
        else:
            answer += i
    answer -= 1
    return answer