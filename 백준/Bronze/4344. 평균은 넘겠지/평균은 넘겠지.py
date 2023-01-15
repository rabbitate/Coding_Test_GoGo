c = int(input())

for _ in range(c):
    count = 0
    nlist = list(map(int, input().split()))
    avg = sum(nlist[1:])/nlist[0]

    for n in nlist[1:]:
        if n > avg:
            count += 1
    prob = count/float(nlist[0])
    print(f"{prob*100:.3f}%")