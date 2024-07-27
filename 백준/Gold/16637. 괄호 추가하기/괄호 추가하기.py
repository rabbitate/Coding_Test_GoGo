n = int(input())
s = list(input())
result = -1 * 2 ** 31

def cal(a, op, b):
    if op == '+':
        return a + b
    elif op == '-':
        return a - b
    elif op == '*':
        return a * b
    elif op == '/':
        return a / b

def dfs(index, value):
    global result

    if index == n-1:
        result = max(result, value)
    
    if index + 2 <= n-1:
        newValue = cal(value, s[index+1], int(s[index+2]))
        dfs(index+2, newValue)

    if index + 4 <= n-1:
        temp = cal(int(s[index+2]), s[index+3], int(s[index+4]))
        newValue = cal(value, s[index+1], temp)
        dfs(index+4, newValue)

dfs(0, int(s[0]))
print(result)