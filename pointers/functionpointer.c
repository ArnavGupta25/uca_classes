#include <stdio.h>

int add(int a, int b) {
    return a + b;
}

int subtract(int a, int b) {
    return a - b;
}

int multiply(int a, int b) {
    return a * b;
}

int divide(int a, int b) {
    if (b != 0) {
        return a / b;
    } else {
        printf("Error: Division by zero!\n");
        return 0;
    }
}

void performop(int (*operation)(int, int), int a, int b) {
    printf("%d\n", operation(a, b));
}


int main() {
    
    performop(add, 10, 5);
    performop(subtract, 10, 5);
    performop(multiply, 10, 5);
    performop(divide, 10, 5);

    return 0;
}


