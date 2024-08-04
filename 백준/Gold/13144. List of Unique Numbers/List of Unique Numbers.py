import sys

n = int(input())
numbers = list(map(int, sys.stdin.readline().split()))
visited = [False for _ in range(100001)]
answer = 0
start = end = 0

while start < n and end < n:
    if not visited[numbers[end]]:
        visited[numbers[end]] = True
        end += 1
        answer += end - start
    else:
        visited[numbers[start]] = False
        start += 1

print(answer)