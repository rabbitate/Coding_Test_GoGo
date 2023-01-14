n = int(input())
nlist = map(int, input().split())
target = int(input())
count = 0

for i in nlist:
    if i == target: count+= 1
        
print(count)