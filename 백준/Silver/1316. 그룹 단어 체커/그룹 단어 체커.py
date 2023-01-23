n = int(input())
cnt = 0
before = '-1'

for _ in range(n):
    st = input()
    clist = []
    for s in st:
        if before != s and s in clist:
            break
        before = s
        clist.append(s)
    else:
        cnt +=1
        
print(cnt)