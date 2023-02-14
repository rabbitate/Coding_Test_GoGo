#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef int Data;

typedef struct Queue {
    Data* data;
    int front;
    int back;
} Queue;

void initQueue(Queue* q, int n) {
    q->data = (Data*)malloc(sizeof(Data) * n);
    q->front = 0;
    q->back = 0;
}

int size(Queue* q) {
    return (q->back - q->front);
}

int empty(Queue* q) {
    if(q->front == q->back) {
        return 1;
    } else {
        return 0;
    }
}

void push(Queue* q, int n) {
    q->data[q->back++] = n;
}

int pop(Queue* q) {
    if(empty(q)) {
        return -1;
    } else {
        Data rnum = q->data[q->front++];
        return rnum;
    }
}

int front(Queue* q) {
    if(empty(q)) {
        return -1;
    } else {
        return q->data[q->front];
    }
}

int back(Queue* q) {
    if(empty(q)) {
        return -1;
    } else {
        return q->data[q->back-1];
    }
}

int main() {
    int n;
    scanf("%d", &n);
    
    Queue queue;
    initQueue(&queue, n);
    
    for(int i = 0; i < n; i++) {
        char cmd[10];
        scanf("%s", cmd);
        if(!strcmp(cmd, "push")) {
            int num;
            scanf("%d", &num);
            push(&queue, num);
        } else if (!strcmp(cmd, "pop")) {
            printf("%d\n", pop(&queue));
        } else if (!strcmp(cmd, "size")) {
            printf("%d\n", size(&queue));
        } else if (!strcmp(cmd, "empty")) {
            printf("%d\n", empty(&queue));
        } else if (!strcmp(cmd, "front")) {
            printf("%d\n", front(&queue));
        } else if (!strcmp(cmd, "back")) {
            printf("%d\n", back(&queue));
        }
    }
}