from collections import deque

R, C = map(int, input().split())

miro = [list(input()) for _ in range(R)]
moveX = [-1, 1, 0, 0]
moveY = [0, 0, -1, 1]

jQueue = deque()
fQueue = deque()

jVisited = [[0] * C for _ in range(R)]
fVisited = [[0] * C for _ in range(R)]

answer = 0

def bfs():
    while fQueue:
        x, y = fQueue.popleft()

        for i in range(4):
            newX = x + moveX[i]
            newY = y + moveY[i]

            if 0 <= newX < R and 0 <= newY < C:
                if fVisited[newX][newY] != 0 or miro[newX][newY] == '#': continue

                fVisited[newX][newY] = fVisited[x][y] + 1
                fQueue.append((newX, newY))
    
    while jQueue:
        x, y = jQueue.popleft()

        for i in range(4):
            newX = x + moveX[i]
            newY = y + moveY[i]

            if 0 <= newX < R and 0 <= newY < C:
                if jVisited[newX][newY] != 0 or miro[newX][newY] == '#': continue
                if jVisited[x][y] + 1 < fVisited[newX][newY] or fVisited[newX][newY] == 0:
                    jVisited[newX][newY] = jVisited[x][y] + 1
                    jQueue.append((newX, newY))
            else: return jVisited[x][y]

    return "IMPOSSIBLE"

for i in range(R):
    for j in range(C):
        if miro[i][j] == 'J':
            jQueue.append((i, j))
            jVisited[i][j] = 1
        elif miro[i][j] == 'F':
            fQueue.append((i, j))
            fVisited[i][j] = 1

print(bfs())