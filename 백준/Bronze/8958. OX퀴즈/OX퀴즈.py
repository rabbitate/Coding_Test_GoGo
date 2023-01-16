n = int(input())

for _ in range(n):
    count = 0
    score = 0
    quiz = list(input())
    for q in quiz:
        if q == 'O': count += 1
        else: count = 0
        score += count
    print(score)