def solution(k, score):
    answer = []
    award = []
    for i in score:
        award.append(i)
        award.sort()
        if len(award) <= k:
            answer.append(award[0])
        else:
            award = award[-k:]
            answer.append(award[0])
    return answer