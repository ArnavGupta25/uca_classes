#include <stdio.h>

int main(void) {
    unsigned int a = 1044848;
    int *b = &a;
    char *c = &a;
   
   //number when more than 128 will give different answers due to 8 bits in a byte
 
    printf("Address stored in b: %d\n", *b);
    printf("Address stored in c: %d\n", *c);
    
    return 0;
}

