nlist = [False for _ in range(31)]

for _ in range(28):
    n = int(input())
    nlist[n] = True

for i in range(1,31):
    if nlist[i] == False:
        print(i)