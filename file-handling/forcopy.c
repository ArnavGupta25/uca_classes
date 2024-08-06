#include <stdio.h>

int main() {
    FILE *src, *dest;
    char ch;

    src = fopen("a.txt", "r");
    dest = fopen("b.txt", "w");


    while ((ch = fgetc(src)) != EOF) {
        fputc(ch, dest);
    }
    fputs("this is the destination file",dest);

    fclose(src);
    fclose(dest);

    return 0;
}
