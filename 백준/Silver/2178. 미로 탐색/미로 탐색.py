from collections import deque

n, m = map(int, input().split())

miro = [[] for _ in range(n)]

for i in range(n):
    s = input()
    for j in s:
        miro[i].append(int(j))

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def bfs():
    d = deque()
    d.append((0, 0))

    while d:
        x, y = d.popleft()

        for i in range(4):
            newX = x + dx[i]
            newY = y + dy[i]

            if newX < 0 or newX >= n:
                continue
            if newY < 0 or newY >= m:
                continue
            if miro[newX][newY] != 1:
                continue
            
            miro[newX][newY] = miro[x][y] + 1
            d.append((newX, newY))
    
    return miro[n-1][m-1]

print(bfs())