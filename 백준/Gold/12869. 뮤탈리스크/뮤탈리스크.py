from collections import deque
from itertools import permutations

n = int(input())
scv = list(map(int, input().split()))

if n < 3:
    for _ in range(3-n):
        scv.append(0)
        
visited = [[[0] * 61 for _ in range(61)] for _ in range(61)]
attack = [9, 3, 1]

def bfs():
    d = deque()
    d.append((scv[0], scv[1], scv[2]))
    visited[scv[0]][scv[1]][scv[2]] = 1

    while d:
        x, y, z = d.popleft()

        for i, j, k in permutations(attack, 3):
            newX = max(0, x - i)
            newY = max(0, y - j)
            newZ = max(0, z - k)

            if visited[newX][newY][newZ]: continue

            visited[newX][newY][newZ] = visited[x][y][z] + 1

            if newX == 0 and newY == 0 and newZ == 0: return visited[x][y][z]

            d.append((newX, newY, newZ))

print(bfs())