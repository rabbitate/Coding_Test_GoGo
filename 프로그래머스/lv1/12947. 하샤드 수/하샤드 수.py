def solution(x):
    og = x
    answer = True
    sum = 0
    while x != 0:
        sum += x % 10
        x //= 10
    if og % sum != 0: answer = False
    return answer