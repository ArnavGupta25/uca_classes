#include "binary.h"

int addition(int a, int b)
{
    int carry;
    while (b != 0)
    {
        carry = a & b;
        a = a ^ b;
        b = carry << 1;
    }
    return a;
}

int subtraction(int a, int b)
{
    int borrow;
    while (b != 0)
    {
        borrow = (~a) & b;
        a = a ^ b;
        b = borrow << 1;
    }
    return a;
}

int multiplication(int a, int b)
{
    int result = 0;
    while (b != 0)
    {
        if (b & 1)
        {
            result = result + a;
        }
        a = a << 1;
        b = b >> 1;
    }
    return result;
}

int division(int a, int b)
{
    int quotient = 0;
    while (a >= b)
    {
        a = a - b;
        quotient = quotient + 1;
    }
    return quotient;
}

void printBinary(int n)
{
    if (n > 1)
        printBinary(n >> 1);
    printf("%d", n & 1);
}
