#include <stdio.h>

void InsertionSort(int narray[], int size) {
    int j;
    for(int i = 1; i < size; i++) {
        int num = narray[i];
        for(j = i-1; j >= 0; j--) {
            if(narray[j] > num) {
                narray[j+1] = narray[j];
            } else {
                break;
            }
        }
        narray[j+1] = num;
    }
}

int main () {
    int n, k;
    scanf("%d %d", &n, &k);

    int narray[n];

    for(int i = 0; i < n; i++) {
        scanf("%d", &narray[i]);
    }

    InsertionSort(narray, n);

    int cutline = narray[n-k];
    printf("%d", cutline);
}