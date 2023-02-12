while True:
    s = input()
    stack = []

    if s == '.': break

    for c in s:
        if c == '(' or c == '[':
            stack.append(c)
        elif c == ')':
            if stack and stack[-1] == '(': stack.pop()
            else:
                stack.append(c)
        elif c == ']':
            if stack and stack[-1] == '[': stack.pop()
            else:
                stack.append(c)
    
    if not stack: print("yes")
    else: print("no")