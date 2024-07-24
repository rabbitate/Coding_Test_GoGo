from collections import deque

height, width = map(int, input().split())
treasureMap = [input() for _ in range(height)]
moveX = [0, 0, -1, 1]
moveY = [-1, 1, 0, 0]
answer = 0

def bfs(i, j):
    visited = [[0] * width for _ in range(height)]
    d = deque()
    visited[i][j] = 1
    d.append((i, j))
    cnt = 0

    while d:
        i, j = d.popleft()

        for r in range(4):
            newX = i + moveX[r]
            newY = j + moveY[r]

            if newX < 0 or newX >= height or newY < 0 or newY >= width:
                continue

            if visited[newX][newY] != 0:
                continue

            if treasureMap[newX][newY] == 'W':
                continue

            d.append((newX, newY))
            visited[newX][newY] = visited[i][j] + 1
            cnt = max(cnt, visited[newX][newY])

    return cnt-1

for i in range(height):
    for j in range(width):
        if treasureMap[i][j] == 'L':
            if i-1 >= 0 and treasureMap[i-1][j] == 'L' and i+1 < height and treasureMap[i+1][j] == 'L':
                continue
            if j-1 >= 0 and treasureMap[i][j-1] == 'L' and j+1 < width and treasureMap[i][j+1] == 'L':
                continue
            answer = max(answer, bfs(i, j))

print(answer)