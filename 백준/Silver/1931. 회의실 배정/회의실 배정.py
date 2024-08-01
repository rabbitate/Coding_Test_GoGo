import sys

n = int(input())
conference = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

conference.sort(key=lambda x:(x[1],x[0]))

current = 0
answer = 0

for start, end in conference:
    if start >= current:
        current = end
        answer += 1

print(answer)