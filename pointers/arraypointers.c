#include <stdio.h>

int main() {

    int arr[6] = {1, 2, 3, 4, 5, 6};
    
    int *ptr = arr;
    
    for (int i = 0; i <= 6; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
    
    for (int i = 0; i <= 6; i++) {
        printf("%d ", *(arr+i));
    }
    printf("\n");
    
    return 0;
}

