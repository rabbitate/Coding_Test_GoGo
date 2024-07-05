from collections import deque

N, M, V = map(int, input().split())
visited = [False for _ in range(N+1)]
vertex = [[] for _ in range(N+1)]

for i in range(1,M+1):
    x,y = map(int, input().split())
    vertex[x].append(y)
    vertex[y].append(x)

for v in vertex:
    v.sort()

def dfs(start):
    visited[start] = True
    print(start, end = " ")

    for v in vertex[start]:
        if not visited[v]:
            dfs(v)

def bfs(start):
    d = deque()
    print(start, end= " ")
    visited[start] = True
    d.append(start)

    while d:
        n = d.popleft()

        for i in vertex[n]:
            if not visited[i]:
                print(i, end=" ")
                visited[i] = True
                d.append(i)

dfs(V)
print()
visited = [False for _ in range(N+1)]
bfs(V)