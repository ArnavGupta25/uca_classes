#include "arithmetic.h"

float addition(float a, float b)
{
    return a + b;
}

float subtraction(float a, float b)
{
    return a - b;
}

float multiplication(float a, float b)
{
    return a * b;
}

float division(float a, float b)
{
    if (b == 0)
    {
        printf("Error: Division by zero is not allowed.");
        return 0;
    }
    else
    {
        return a / b;
    }
}