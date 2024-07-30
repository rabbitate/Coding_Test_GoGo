import heapq

n = int(input())
lecture = [list(map(int, input().split())) for _ in range(n)]

lecture.sort(key=lambda x: x[1])

heap = []

for pay, day in lecture:
    heapq.heappush(heap, pay)
    if len(heap) > day:
        heapq.heappop(heap)

print(sum(heap))