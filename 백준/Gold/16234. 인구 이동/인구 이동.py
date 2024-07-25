from collections import deque

N, L, R = map(int, input().split())

moveX = [-1, 1, 0, 0]
moveY = [0, 0, -1, 1]
country = [list(map(int, input().split())) for _ in range(N)]
answer = 0

def bfs(x, y):
    d = deque()
    d.append((x, y))
    visited[x][y] = True
    union = [(x, y)]
    totalPopulation = country[x][y]

    while d:
        x, y = d.popleft()
        for i in range(4):
            newX = x + moveX[i]
            newY = y + moveY[i]

            if 0 <= newX < N and 0 <= newY < N:
                if visited[newX][newY]: continue

                if L <= abs(country[newX][newY] - country[x][y]) <= R:
                    d.append((newX, newY))
                    visited[newX][newY] = True
                    union.append((newX, newY))
                    totalPopulation += country[newX][newY]
    
    if len(union) > 1:
        changedPopulation = totalPopulation // len(union)

        for x, y in union:
            country[x][y] = changedPopulation
        return 1
    else: return 0

while True:
    flag = 0
    visited = [[False] * N for _ in range(N)]

    for i in range(N):
        for j in range(N):
            if not visited[i][j]:
                flag = max(flag, bfs(i, j))
    
    if flag:
        answer += 1
    else: break               

print(answer)