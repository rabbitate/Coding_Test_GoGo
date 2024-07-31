import sys

n = int(input())
cow = [list(map(int ,sys.stdin.readline().split())) for _ in range(n)]
cow.sort()
end = 0

for arrive, duration in cow:
    if end <= arrive:
        end = arrive + duration
    else:
        end += duration

print(end) 