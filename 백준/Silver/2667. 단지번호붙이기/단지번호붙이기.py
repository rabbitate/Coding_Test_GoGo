from collections import deque

n = int(input())
houses = [[] for _ in range(n)]
answer = []

for i in range(n):
    line = input()
    for s in line:
        houses[i].append(int(s))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
    d = deque()
    cnt = 1
    d.append((x, y))
    houses[x][y] = 2

    while d:
        x, y = d.popleft()
        for i in range(4):
            newX = x + dx[i]
            newY = y + dy[i]

            if newX < 0 or newX >= n:
                continue
            if newY < 0 or newY >= n:
                continue
            if houses[newX][newY] != 1:
                continue

            houses[newX][newY] = houses[x][y] + 1
            d.append((newX, newY))
            cnt += 1
    
    return cnt

for i in range(n):
    for j in range(n):
        if houses[i][j] == 1:
            answer.append(bfs(i, j))

print(len(answer))
answer.sort()
for i in answer:
    print(i)