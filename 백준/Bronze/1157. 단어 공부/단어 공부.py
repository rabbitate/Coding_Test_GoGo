alphabet = [0 for _ in range(26)]

s = input()
s = s.upper()

for c in s:
    alphabet[ord(c) - ord('A')] += 1
    
maxcnt = max(alphabet)
cnt = 0

for index in range(len(alphabet)):
    if alphabet[index] == maxcnt:
        cnt += 1
        maxalpha = chr(ord('A') + index)

if cnt == 1: print(maxalpha)
else: print("?")