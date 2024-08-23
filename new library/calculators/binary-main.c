#include "binary.h"

int main()
{
    int a = 0b0100010; // Binary for 34
    int b = 0b10001;  // Binary for 204

    printf("Addition: ");
    printBinary(addition(a, b));
    printf("\n");

    printf("Subtraction: ");
    printBinary(subtraction(a, b));
    printf("\n");

    printf("Multiplication: ");
    printBinary(multiplication(a, b));
    printf("\n");

    printf("Division: ");
    printBinary(division(a, b));
    printf("\n");

    return 0;
}

// gcc -c binary-calculator.c -o run1
// ar rcs lib1.a run1
// gcc binary-main.c -L. lib1.a
// ./a.out