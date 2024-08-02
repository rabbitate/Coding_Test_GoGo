import sys
import heapq

n, bag = map(int, sys.stdin.readline().split())
jewels = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
bags = [int(sys.stdin.readline()) for _ in range(bag)]

jewels.sort()
bags.sort()

answer = 0
hq = []

for bag in bags:
    while jewels and jewels[0][0] <= bag:
        heapq.heappush(hq, -heapq.heappop(jewels)[1])
    if hq:
        answer -= heapq.heappop(hq)

print(answer)