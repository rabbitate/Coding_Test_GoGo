s = input().upper()
alist = list(set(s))
cntList = []

for c in alist:
    cntList.append(s.count(c))

if cntList.count(max(cntList)) >= 2: print("?")
else: print(alist[cntList.index(max(cntList))])