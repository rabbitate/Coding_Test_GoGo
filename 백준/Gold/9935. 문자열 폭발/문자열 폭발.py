target = input()
bomb = input()

s = []

for t in target:
    s.append(t)
    if s[-len(bomb):] == list(bomb):
        for _ in range(len(bomb)):
            s.pop()

print(''.join(s) if s else 'FRULA')