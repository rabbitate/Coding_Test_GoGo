n, k = map(int,input().split())
circle = [i for i in range(1,n+1)]
index = -1

print("<", end="")
for _ in range(n):
    for _ in range(k-1):
        circle.append(circle.pop(0))
    if len(circle) != 1: print(circle.pop(0), end=", ")
    else: print(circle.pop(0), end="")
print(">", end="")