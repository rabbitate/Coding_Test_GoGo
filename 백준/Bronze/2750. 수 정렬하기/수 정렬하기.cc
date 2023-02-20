#include <stdio.h>

void BubbleSort(int narray[], int size) {
    for (int i = size-1; i >= 0; i--) {
        for(int j = 0; j < i; j++) {
            if (narray[j] > narray[j+1]) {
                int temp = narray[j];
                narray[j] = narray[j+1];
                narray[j+1] = temp;
            }
        }
    }
}

int main() {
    int n;
    scanf("%d", &n);
    int narray[n];

    for (int i = 0; i < n; i++) {
        scanf("%d", &narray[i]);
    }

    BubbleSort(narray,n);

    for (int i = 0; i < n; i++) {
        printf("%d\n", narray[i]);
    }
}