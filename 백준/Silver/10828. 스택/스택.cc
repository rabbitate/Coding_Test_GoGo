#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef int Data;

typedef struct Stack {
    Data* stackArr;
    int cursor = -1;
    int cnt = 0;
} Stack;

void initStack(Stack* s, int size) {
    s->stackArr = (Data*)malloc(sizeof(Data) * size);
}

int IsEmpty(Stack* s) {
    if (s->cursor == -1) {
        return 1;
    } else {
        return 0;
    }
}

int getCount(Stack* s) {
    return s->cnt;
}

int Peek(Stack* s) {
    if (IsEmpty(s)) {
        return -1;
    } else return s->stackArr[s->cursor];
}

int Pop(Stack* s) {
    if (IsEmpty(s)) {
        return -1;
    } else {
        int popNum = s->stackArr[s->cursor];
        s->cursor -= 1;
        s->cnt -= 1;
        return popNum;
    }
}

void Push(Stack* s, int n) {
    s->cursor += 1;
    s->cnt += 1;
    s->stackArr[s->cursor] = n;
}

int main() {
    int input;
    scanf("%d", &input);
    
    Stack stack;
    initStack(&stack,input);
    
    char cmd[10];
    int n;
    
    for(int i = 0; i < input; i++) {
        scanf("%s", cmd);
        if (strcmp(cmd,"push") == 0) {
            scanf("%d", &n);
            Push(&stack, n);
        } else if (strcmp(cmd,"top") == 0) {
            printf("%d\n", Peek(&stack));
        } else if (strcmp(cmd,"size") == 0) {
            printf("%d\n", getCount(&stack));
        } else if (strcmp(cmd,"empty") == 0) {
            printf("%d\n", IsEmpty(&stack));
        } else if (strcmp(cmd,"pop") == 0) {
            printf("%d\n", Pop(&stack));
        }
    }
}