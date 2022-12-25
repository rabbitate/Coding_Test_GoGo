lan = ["aya", "ye", "woo", "ma"] 

def solution(babbling):
    answer = 0
    for i in range(len(lan)):
        for j in range(len(babbling)):
            babbling[j] = babbling[j].replace(lan[i], str(i))
    for i in babbling:
        before = -1
        if i.isdigit():
            for j in range(len(i)):
                if i[j] == before:
                    break
                else: before = i[j]
            else:
                answer += 1                    
               
    return answer