def isPalindrome(s,f,l):
    global rcnt
    rcnt += 1
    if f>=l: return 1
    else:
        if s[f]!=s[l]: return 0
        else: return isPalindrome(s,f+1,l-1)
        
n = int(input())

for _ in range(n):
    s = input()
    rcnt = 0
    print(isPalindrome(s, 0, len(s)-1), end=" ")
    print(rcnt)