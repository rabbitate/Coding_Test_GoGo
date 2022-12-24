def solution(s):
    answer = 0
    og = cmp = 0
    for c in s:
        if og == cmp:
            ch = c
            answer += 1
        if c == ch:
            og += 1
        else:
            cmp += 1
    return answer