from itertools import combinations

n = int(input())
garden = [list(map(int , input().split())) for _ in range(n)]

moveX = [-1, 1, 0, 0]
moveY = [0, 0, -1, 1]

answer = int(1e9)

flower = []

def cal(flowerList):
    global answer
    visited = [[False] * n for _ in range(n)]
    total = 0
    for x, y in flowerList:
        total += garden[x][y]
        visited[x][y] = True
        
        for i in range(4):
            newX = x + moveX[i]
            newY = y + moveY[i]

            if not visited[newX][newY]:
                total += garden[newX][newY]
                visited[newX][newY] = True
            else: return
    answer = min(answer, total)

for i in range(1, n-1):
    for j in range(1, n-1):
        flower.append((i, j))

for flowerList in combinations(flower, 3):
    cal(flowerList)

print(answer)