n = int(input())
x, y = map(int, input().split())
relationship = int(input())

family = [[] for _ in range(n+1)]
visited = [False for _ in range(n+1)]
answer = []

for _ in range(relationship):
    i, j = map(int, input().split())
    family[i].append(j)
    family[j].append(i)

def dfs(start, cnt):
    cnt += 1
    visited[start] = True

    if start == y:
        answer.append(cnt)

    for i in family[start]:
        if not visited[i]:
            dfs(i, cnt)

dfs(x, -1)
print(-1 if len(answer) == 0 else answer[0])