#include <stdio.h>
#include <stdlib.h>

void* initialize(int n) {
    char *arr = (char *)malloc(n);

    for (int i = 0; i < n; i++) {
        arr[i] = '\0';
    }

    return (void*)arr; 
}

int main() {
    int n = 10;
    char *arr = (char *)initialize(n);

    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]); 
    }
    printf("\n");

    free(arr);

    return 0;
}
