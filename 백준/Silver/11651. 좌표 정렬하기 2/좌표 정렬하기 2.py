n = int(input())
nlist = []

for _ in range(n):
    nlist.append(list(map(int, input().split())))
    
nlist.sort(key=lambda x:(x[1],x[0]))

for i in range(n):
    print(nlist[i][0], nlist[i][1])