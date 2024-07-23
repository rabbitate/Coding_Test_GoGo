n, m = map(int, input().split())
visited = [False for _ in range(n+1)]
answer = []

def dfs(start, list):
    if start == m+1:
        answer.append(list)
        return
    
    for i in range(1, n+1):
        if not visited[i]:
            visited[i] = True
            dfs(start+1, list + [i])
            visited[i] = False

dfs(1, [])
for a in answer:
    for i in a:
        print(i, end=" ")
    print()