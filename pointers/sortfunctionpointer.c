#include <stdio.h>

int compareAsc(int a, int b) {
    return a - b;
}

int compareDesc(int a, int b) {
    return b - a;
}

void sort(int arr[], int size, int (*compare)(int, int)) {
    int i, j;
    for (i = 0; i < size - 1; i++) {
        for (j = 0; j < size - 1 - i; j++) {
            if (compare(arr[j], arr[j + 1]) > 0) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

void printArray(int arr[], int size) {
    for (int i = 0; i < size; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}


int main() {
    int arr[] = {5, 2, 9, 1, 5, 6};
    int size = sizeof(arr) / sizeof(arr[0]);

    printArray(arr, size);


    sort(arr, size, compareAsc);
    printf("Sorted array in ascending order: ");
    printArray(arr, size);

    sort(arr, size, compareDesc);
    printf("Sorted array in descending order: ");
    printArray(arr, size);

    return 0;
}

