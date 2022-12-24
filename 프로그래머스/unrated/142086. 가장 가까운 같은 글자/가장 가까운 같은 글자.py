def solution(s):
    answer = []
    alphabet = [-1 for _ in range(26)]
    for i in range(0,len(s)):
        index = ord(s[i]) - ord('a')
        if alphabet[index] == -1:
            answer.append(-1)
            alphabet[index] = i
        else:
            answer.append(i - alphabet[index])
            alphabet[index] = i
    return answer
