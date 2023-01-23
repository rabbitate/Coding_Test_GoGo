st = input()
croatia = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
cnt = 0


for i in range(len(croatia)):
    alphabet = croatia[i]
    if alphabet in st:
        st = st.replace(alphabet, str(i))

for s in st:
    if s.isnumeric(): cnt += 1

s = set(s)

for s in st:
    if not(s.isnumeric()): cnt += 1

print(cnt)