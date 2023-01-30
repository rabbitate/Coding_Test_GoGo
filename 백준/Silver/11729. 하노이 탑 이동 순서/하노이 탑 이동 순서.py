def hanoi(s,e,cnt):
    if cnt==1:
        print('%d %d' %(s,e))
        return
    m = 6-(s+e)
    hanoi(s,m,cnt-1)
    hanoi(s,e,1)
    hanoi(m,e,cnt-1)

n = int(input())
print(2**n-1)
hanoi(1,3,n)