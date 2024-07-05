com = int(input())
line = int(input())
visited = [False for _ in range(com+1)]
coms = [[] for _ in range(com+1)]
cnt = 0

for _ in range(line):
    x, y = map(int, input().split())
    coms[x].append(y)
    coms[y].append(x)

def dfs(start):
    global cnt
    visited[start] = True
    cnt += 1

    for i in coms[start]:
        if not visited[i]:
            dfs(i)

dfs(1)
print(cnt-1)