n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
chicken = []
home = []
answer = 2 * n * 2 * n

for i in range(n):
    for j in range(n):
        if arr[i][j] == 1:
            home.append([i, j])
        elif arr[i][j] == 2:
            chicken.append([i, j])

cnt = len(chicken)

def cal(tList):
    totalDistance = 0

    for homeX, homeY in home:
        distance = 2 * n
        for chickenX, chickenY in tList:
            distance = min(distance, abs(homeX - chickenX) + abs(homeY - chickenY))
        totalDistance += distance

    return totalDistance

def dfs(n, tList):
    global answer

    if n == cnt:
        if len(tList) == m:
            answer = min(answer, cal(tList))
        return
    
    dfs(n+1, tList + [chicken[n]])
    dfs(n+1, tList)

dfs(0, [])
print(answer)