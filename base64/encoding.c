#include <stdio.h>
#include <string.h>
#include <stdbool.h>

char maps[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

void toBinary(int n, char *binary, int bits) {
    for (int i = bits - 1; i >= 0; i--) {
        binary[i] = (n % 2) + '0';
        n /= 2;
    }
    binary[bits] = '\0';
}

void encodeToBase64(char *input) {
    char binary_string[1024] = "";
    char encoded_string[1024] = "";
    
    // Convert each character to its ASCII value and then to binary
    for (int i = 0; i < strlen(input); i++) {
        char binary[9];
        toBinary(input[i], binary, 8);
        strcat(binary_string, binary);
    }

    // Process the binary string in 6-bit chunks
    for (int i = 0; i < strlen(binary_string); i += 6) {
        char six_bit_chunk[7] = "000000";
        
        // If less than 6 bits are left, pad with zeros
        strncpy(six_bit_chunk, binary_string + i, 6);
        
        // Convert 6-bit binary to decimal
        int decimal_value = 0;
        for (int j = 0; j < 6; j++) {
            decimal_value = decimal_value * 2 + (six_bit_chunk[j] - '0');
        }

        char base64_char = maps[decimal_value];
        strncat(encoded_string, &base64_char, 1);
    }

    printf("Encoded String: %s\n", encoded_string);
}

bool validInput(char* str, int len) {
    bool flag = false;
    for(int i = 0; i < len; i++) {
        if(str[i] == ' ' || str[i] == '\t') {
            flag = true;
        }
    }
    if(flag) {
        printf("Input cannot have white spaces, provide a valid input\n");
        return false;
    }
    return true;
}


int main() {
    char input[256];
    printf("Enter a string to encode: ");
    fgets(input, 256, stdin);
    
    // Remove the newline character if present
    input[strcspn(input, "\n")] = '\0';
    
    int len = strlen(input);
    
    // Validate input before proceeding
    if (!validInput(input, len)) {
        return 1;
    }
    
    encodeToBase64(input);
    return 0;
}