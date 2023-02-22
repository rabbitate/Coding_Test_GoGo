#include <stdio.h>

int temp[1000000];

void Merge(int narray[], int start, int mid, int end) {
    // int temp[end+1];
    // for(int i = 0; i <= end; i++) {
    //     temp[i] = narray[i];
    // }
    int i = start;
    int j = mid+1;
    int k = start;
    while(i<=mid && j<=end) {
        if(narray[i] > narray[j]) {
            temp[k++] = narray[j++];
        } else {
            temp[k++] = narray[i++];
        }
    }

    if(i > mid) {
        for(int l = j; l <= end; l++) {
            temp[k++] = narray[l];
        }
    } else {
        for(int l = i; l <= mid; l++) {
            temp[k++] = narray[l];
        }
    }

    for(int i = start; i <= end; i++) {
        narray[i] = temp[i];
    }
}

void MergeSort(int narray[], int start, int end) {
    if(start < end) {
        int mid = (start+end)/2;
        MergeSort(narray,start,mid);
        MergeSort(narray,mid+1,end);
        Merge(narray,start,mid,end);
    }
}

int main() {
    int n;
    scanf("%d", &n);

    int narray[n];

    for(int i = 0; i < n; i++) {
        scanf("%d", &narray[i]);
    }

    MergeSort(narray, 0, n-1);

    for(int i = 0; i < n; i++) {
        printf("%d\n", narray[i]);
    }
}