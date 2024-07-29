from collections import deque

R, C, K = map(int, input().split())
road = [list(input()) for _ in range(R)]
visited = [[0] * C for _ in range(R)]

moveX = [-1, 1, 0, 0]
moveY = [0, 0, -1, 1]

answer = 0

def dfs(x, y):
    global answer
    if x == 0 and y == C-1:
        if visited[x][y] == K:
            answer += 1
        return
    
    for i in range(4):
        newX = x + moveX[i]
        newY = y + moveY[i]

        if 0 <= newX < R and 0 <= newY < C and not visited[newX][newY] and road[newX][newY] == '.':
            visited[newX][newY] = visited[x][y] + 1
            dfs(newX, newY)
            visited[newX][newY] = 0

visited[R-1][0] = 1
dfs(R-1, 0)
print(answer)