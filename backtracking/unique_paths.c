#include <stdio.h>

void printAllPathsUtil(int mat[100][100], int i, int j, int m, int n, int path[], int index) {
    path[index] = mat[i][j];
    index++;

    if (i == m - 1 && j == n - 1) {
        for (int k = 0; k < index; k++) {
            printf("%d ", path[k]);
        }
        printf("\n");
        return;
    }

    if (i < m - 1) {
        printAllPathsUtil(mat, i + 1, j, m, n, path, index);
    }

    if (j < n - 1) {
        printAllPathsUtil(mat, i, j + 1, m, n, path, index);
    }
}

void printAllPaths(int mat[100][100], int m, int n) {
    int path[100 * 100];
    printAllPathsUtil(mat, 0, 0, m, n, path, 0);
}

int main() {
    int mat[100][100] = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    
    int m = 3, n = 3;

    printAllPaths(mat, m, n);

    return 0;
}
