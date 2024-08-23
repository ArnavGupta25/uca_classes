#include "arithmetic.h"

int main(){
    float x=10;
    float y=5;

    printf("Addition: %f\n", addition(x, y));
    printf("Subtraction: %f\n", subtraction(x, y));
    printf("Multiplication: %f\n", multiplication(x, y));
    printf("Division: %f\n", division(x, y));
    return 0;
}

// gcc -c arithmetic-calculator.c -o run
// ar rcs lib.a run
// gcc arithmetic-main.c -L. lib.a
// ./a.out