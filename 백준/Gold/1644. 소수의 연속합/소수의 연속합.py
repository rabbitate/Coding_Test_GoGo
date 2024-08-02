import math

n = int(input())
numCheck = [True for _ in range(n+1)]
primeNum = []
start = end = 0
answer = 0

for i in range(2, int(math.sqrt(n)+1)):
    if numCheck[i]:
        j = 2
        while i * j <= n:
            numCheck[i*j] = False
            j += 1

for i in range(2, len(numCheck)):
    if numCheck[i]:
        primeNum.append(i)


while end <= len(primeNum):
    totalNum = sum(primeNum[start:end])
    if totalNum == n: 
        answer += 1
        end += 1
    elif totalNum < n:
        end += 1
    else:
        start += 1

print(answer)