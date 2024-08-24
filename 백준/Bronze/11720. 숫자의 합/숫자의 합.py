n = int(input())
num = int(input())
sum = 0

for _ in range(n):
    sum += num % 10
    num //= 10
    
print(sum)