st = input()
croatia = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
cnt = 0


for i in range(len(croatia)):
    alphabet = croatia[i]
    if alphabet in st:
        st = st.replace(alphabet, str(i))
            
print(len(st))