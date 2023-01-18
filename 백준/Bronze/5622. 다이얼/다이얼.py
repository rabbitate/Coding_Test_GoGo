dial = ['ABC', 'DEF', 'GHI', 'JKL', 'MNO', 'PQRS', 'TUV', 'WXYZ']
str = input()
time = 0

for c in str:
    for i in range(len(dial)):
        if c in dial[i]:
            time += i+3
            
print(time)