#include <stdio.h>

void InsertionSort(int narray[], int size) {
    for(int i = 0; i < size-1; i++) {
        int min = i;
        for(int j = i+1; j <= size-1; j++) {
            if(narray[min] > narray[j]) {
                min = j;
            }
        }
        if(i != min) {
            int temp = narray[i];
            narray[i] = narray[min];
            narray[min] = temp;
        }
    }
}

int main () {
    int narray[5];

    for(int i = 0; i < 5; i++) {
        scanf("%d", &narray[i]);
    }

    InsertionSort(narray, 5);

    int sum = 0;

    for(int i = 0; i < 5; i++) {
        sum += narray[i];
    }

    printf("%d\n", sum/5);
    printf("%d", narray[2]);
}