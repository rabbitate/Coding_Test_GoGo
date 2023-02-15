from collections import deque

n = int(input())
nlist = deque([i for i in range(1,n+1)])

while(len(nlist) != 1):
    nlist.popleft()
    nlist.append(nlist.popleft())
    
print(nlist[0])